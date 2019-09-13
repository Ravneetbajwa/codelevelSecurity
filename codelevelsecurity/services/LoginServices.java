/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codelevelsecurity.services;

import codelevelsecurity.beans.UserBean;
import codelevelsecurity.db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Taranpreet Kaur
 */
public class LoginServices {
    public UserBean authenticateUser(String un)
    {
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        UserBean objbean=null;
        try
        {
            conn=DBConnection.connect();
            pstmt=conn.prepareStatement("select * from usermaster where Username=?");//only username is matched
           pstmt.setString(1,un);
           rs=(pstmt.executeQuery());//when select query is used
           if(rs.next())
           {
              objbean=new UserBean();
              objbean.setUserid(rs.getInt("Userid"));
             objbean.setUsername(rs.getString("Username"));
              objbean.setPassword(rs.getString("Password"));   
               objbean.setUsertype(rs.getString("Usertype"));
                objbean.setUserstatus(rs.getBoolean("UserStatus"));
                return objbean; 
           }
        }
        catch(Exception e)
                {
                    System.out.println("Authenticate user"+e);
                }
        finally
        {
            try
            {
                rs.close();
                pstmt.close();
                conn.close();
            }
            catch(Exception ex)
            {
                System.out.println(ex);
            }
        }
        return objbean;
    }
    public String[] ForgotPassword(String un)
    {
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String res[]=null;
        try
        {
           conn=DBConnection.connect();
           pstmt=conn.prepareStatement("select Email,Password from usermaster where Username=?");//only username is matched
           pstmt.setString(1,un);
           rs=(pstmt.executeQuery());//when select query is used
           if(rs.next())
           {
                      
           }
               else
               {
                   return res;//it returns invalid username ,password.
               }
           }
        
        catch(Exception e)
                {
                    System.out.println("Forgot Password"+e);
                }
        finally
        {
            try
            {
                rs.close();
                pstmt.close();
                conn.close();
            }
            catch(Exception ex)
            {
                System.out.println(ex);
            }
        }
        return res;
}
    
}
