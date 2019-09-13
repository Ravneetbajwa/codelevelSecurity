/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codelevelsecurity.services;

import codelevelsecurity.beans.ProgramMasterBean;
import codelevelsecurity.beans.ProgramUpdateMasterBean;
import codelevelsecurity.db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author win8
 */
public class ProgramUpdateServices {
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    ArrayList al=null;
     public int getProgramId(int ui,String pn)
    {
        int programId=0;
        try
        {
            conn= DBConnection.connect();
            pstmt=conn.prepareStatement("select Programid from programmaster where Userid=? && Programname=?");
            pstmt.setInt(1,ui);
            pstmt.setString(2, pn);
            rs=pstmt.executeQuery();
            al=new ArrayList();
            if(rs.next())
            {
                programId=rs.getInt("Program id");
                System.out.println(programId);
            }
        }
        catch(Exception e)
        {
            System.out.println("ProgramsUpdateServices/getProgramId: "+e);
        }
        finally
        {
            try
            {
                rs.close();
                pstmt.close();
                conn.close();
            }
            catch(Exception e)
            {
                System.out.println("ProgramsUpdateServices/getProgramId :"+e);
            }
        }
        return programId;
    }
     public boolean addProgramUpdateMaster(ProgramUpdateMasterBean objbean)
     {
         try
         {
              conn = DBConnection.connect();
            pstmt = conn.prepareStatement("insert into programupdatemaster(Programid,Updatedate) values(?,?)");
           
            pstmt.setInt(1, objbean.getProgramId());
            
            
            pstmt.setString(2, objbean.getUpdateDate());
            
            
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("ProgramsUpdateServices/addProgramsUpdateMaster():" + e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("ProgramsUpdateServices/addProgramsUpdateMaster():" + e);
            }
        }
         return false;
         
     }
    public ArrayList programsUpdateReport()
    {
        try
        {
            conn= DBConnection.connect();
            pstmt=conn.prepareStatement("select programmaster.Programid,Userid,Programname,Createdate,Updatedate from programmaster inner join programupdatemaster on programmaster.Programid=programupdatemaster.Programid");
            //pstmt=conn.prepareStatement("select * from programupdatemaster");
            rs=pstmt.executeQuery();
            al=new ArrayList();
            while(rs.next())
            {
                ProgramMasterBean objbean= new ProgramMasterBean();
                objbean.setProgramId(rs.getInt("Programid"));
                objbean.setUserId(rs.getInt("Userid"));
                objbean.setProgramName(rs.getString("Programname"));
                objbean.setCreateDate(rs.getString("Createdate"));
                objbean.setUpdateDate(rs.getString("Updatedate"));
                al.add(objbean);
            }
        }
        catch(Exception e)
        {
            System.out.println("ProgramsUpdateServices/programsUpdateReport() :"+e);
        }
        finally
        {
            try
            {
                rs.close();
                pstmt.close();
                conn.close();
            }
            catch(Exception e)
            {
                System.out.println("ProgramsUpdateServices/programsUpdateReport() :"+e);
            }
        }
        return al;
    }
    /* public ArrayList getUsersByNameDate(String un,String date)
    {
        ArrayList al=null;
        try
        {
            conn=DBConnection.connect();
            if(!un.isEmpty() && date.isEmpty())
            {
            pstmt=conn.prepareStatement("select programmaster.Program_ID,programmaster.User_ID,Program_Name,Create_Date,Update_Date from programmaster inner join programupdatemaster on programmaster.Program_ID=programupdatemaster.Program_ID inner join usermaster on programmaster.User_ID=usermaster.User_ID  where Username=?");
            pstmt.setString(1, un);
            }
            else if(un.isEmpty() && !date.isEmpty())
            {
            pstmt=conn.prepareStatement("select programmaster.Program_ID,programmaster.User_ID,Program_Name,Create_Date,Update_Date from programmaster inner join programupdatemaster on programmaster.Program_ID=programupdatemaster.Program_ID inner join usermaster on programmaster.User_ID=usermaster.User_ID  where date(Create_Date) Like ?");
            pstmt.setString(1, date+"%");
            
            }
            else
            {
                pstmt=conn.prepareStatement("select programmaster.Program_ID,programmaster.User_ID,Program_Name,Create_Date,Update_Date from programmaster inner join programupdatemaster on programmaster.Program_ID=programupdatemaster.Program_ID inner join usermaster on programmaster.User_ID=usermaster.User_ID  where Username=? && date(Create_Date) Like ?");
                pstmt.setString(1, un);
                pstmt.setString(2, date+"%");
            }
            rs=pstmt.executeQuery();
            al=new ArrayList();
            while(rs.next())
            {
                ProgramMasterBean objbean=new ProgramMasterBean();
                objbean.setProgramId(rs.getInt("Program_ID"));
                objbean.setUserId(rs.getInt("User_ID"));
                objbean.setProgramName(rs.getString("Program_Name"));
                objbean.setCreateDate(rs.getString("Create_Date"));
                objbean.setUpdateDate(rs.getString("Update_Date"));
                al.add(objbean);
            }
         }
        catch(Exception e)
        {
            System.out.println("UserAcitivityServices/getUserByName() :"+e);
        }
        finally
        {
            try
            {
                rs.close();
                pstmt.close();
                conn.close();
            }
            catch(Exception e)
            {
                System.out.println("UserAcitivityServices/getUserByName() :"+e);
            }
        }
        return al;
    }*/
    
}
