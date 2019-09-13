/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codelevelsecurity.services;

import codelevelsecurity.db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Taranpreet Kaur
 */
public class UserActivityServices {
    public String getCurrentTime()
    {
      
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
		return sdf.format(d);
    }
        public int insertLoginTime(int Userid)
        {
         Connection conn=null;
         PreparedStatement pstmt=null;
         ResultSet rs=null;
         try
         {
             conn= DBConnection.connect();
             pstmt=conn.prepareStatement("insert into useractivitymaster(user_id,Login_time) values(?,?)");
             pstmt.setInt(1,Userid);//errror
             pstmt.setString(2,getCurrentTime());
             int i=pstmt.executeUpdate();
             if(i>0)
             {
                 pstmt=conn.prepareStatement("select max(Activity_Id) from useractivitymaster");
                 rs=pstmt.executeQuery();
                 if(rs.next())
                         {
                             return rs.getInt("max(Activity_ID)");
                         }
             }
         }
         catch(Exception e)
         {
              System.out.println("insert login time " + e);
        } finally
        {
            try
            {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        return 0;
    
         }
        public void UpdateLogoutTime(int id)
        {
          
         Connection conn=null;
         PreparedStatement pstmt=null;
         try
         {
             conn= DBConnection.connect();
             pstmt=conn.prepareStatement("update useractivitymaster set Logout_Time=? where Activity_ID=?");
             pstmt.setInt(2,id);//errror
             pstmt.setString(1,getCurrentTime());
             int i=pstmt.executeUpdate();
         }   
         catch(Exception e)
         {
              System.out.println("getAllRecords" +e);
        } finally
        {
            try
            {
              //  rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
         }
    
         }
        
}
