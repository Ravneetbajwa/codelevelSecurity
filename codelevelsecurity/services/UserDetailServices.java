/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codelevelsecurity.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import codelevelsecurity.beans.UserBean;
import codelevelsecurity.db.DBConnection;

/**
 *
 * @author Taranpreet Kaur
 */
public class UserDetailServices {

    public ArrayList<UserBean> getAllRecords() {
        Connection conn = null;//class for connection
        PreparedStatement pst = null;//to execute query
        ResultSet rs = null;//to fetch rresult
        ArrayList<UserBean> al = null;//to store data of EmpBean type
        UserBean objbean = null;
        try {//get all fields
            conn = DBConnection.connect();//static method is called .//for doing connection.
            pst = conn.prepareStatement("select * from usermaster");//com folder is api,	
            rs = pst.executeQuery();
            al = new ArrayList<UserBean>();
            while (rs.next()) {
                objbean = new UserBean();
                objbean.setUserid(rs.getInt("Userid"));
                objbean.setUsername(rs.getString("Username"));
                objbean.setPassword(rs.getString("Password"));
                objbean.setUsertype(rs.getString("Usertype"));
                objbean.setName(rs.getString("Name"));
                objbean.setContact(rs.getString("Contact"));
                objbean.setEmail(rs.getString("Email"));
                objbean.setAddress(rs.getString("Address"));
                objbean.setUserstatus(rs.getBoolean("Userstatus"));
                objbean.setGender(rs.getBoolean("Gender"));
                objbean.setDOB(rs.getString("DOB"));
                al.add(objbean);
            }
            return al;
        } 
        catch (Exception e) 
        {
            System.out.println("getAllRecords" + e);
        } finally
        {
            try
            {
                rs.close();
                pst.close();
                conn.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        return al;
    }

    public boolean AddRecord(UserBean objbean) {
        Connection conn = null;//class for connection
        PreparedStatement pst = null;//to execute query
        try 
        {
            conn = DBConnection.connect();//static method is called .//
            pst = conn.prepareStatement("insert into usermaster values(?,?,?,?,?,?,?,?,?,?,?)");//com folder is api,	
            //  int i=	pst.executeUpdate();//it returns the index of the row in which data is stored;
            pst.setInt(1, objbean.getUserid());
            pst.setString(2, objbean.getUsername());
            pst.setString(3, objbean.getPassword());
            pst.setString(4, objbean.getUsertype());
            pst.setBoolean(5, objbean.isUserstatus());
            pst.setString(6, objbean.getName());
            pst.setString(7, objbean.getAddress());
            pst.setString(8, objbean.getContact());
            pst.setString(9, objbean.getEmail());
            pst.setBoolean(10, objbean.isGender());
            pst.setString(11, objbean.getDOB());
            int i = pst.executeUpdate();//it returns the index of the row in which data is stored;
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e)
        {
            System.out.println("AddRecord" + e);
        } 
        finally
        {
            try 
            {
                //rs.close();
                pst.close();
                conn.close();
            } 
            catch (Exception ex)
            {
                System.out.println(ex);
            }
        }
        return false;
    }
   /* public ArrayList<UserBean> getAllRecords() {
        Connection conn = null;//class for connection
        PreparedStatement pst = null;//to execute query
        ResultSet rs = null;//to fetch rresult
        ArrayList<UserBean> al = null;//to store data of EmpBean type
        UserBean objbean = null;
        try {//get all fields
            conn = DBConnection.connect();//static method is called .//for doing connection.
            pst = conn.prepareStatement("select * from usermaster");//com folder is api,	
            rs = pst.executeQuery();
            al = new ArrayList<UserBean>();
            while (rs.next()) {
                objbean = new UserBean();
                objbean.setUserid(rs.getInt("Userid"));
                objbean.setUsername(rs.getString("Username"));
                objbean.setPassword(rs.getString("Password"));
                objbean.setUsertype(rs.getString("Usertype"));
                objbean.setName(rs.getString("Name"));
                objbean.setContact(rs.getString("Contact"));
                objbean.setEmail(rs.getString("Email"));
                objbean.setAddress(rs.getString("Address"));
                objbean.setUserstatus(rs.getBoolean("Userstatus"));
                objbean.setGender(rs.getBoolean("Gender"));
                objbean.setDOB(rs.getString("DOB"));
                al.add(objbean);
            }
            return al;
        } 
        catch (Exception e) 
        {
            System.out.println("getAllRecords" + e);
        } finally
        {
            try
            {
                rs.close();
                pst.close();
                conn.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        return al;
    }*/

    public boolean UpdateById(UserBean objbean) 
        {
             Connection conn=null;//class for connection
            PreparedStatement pst=null;//to execute query
            try
            {
             conn=DBConnection.connect();//static method is called .//
             pst=conn.prepareStatement("update usermaster set Username=?,Password=?,Name=?,Address=?,Contact=?,Email=?,Gender=?,Userstatus=?,DOB=? where Userid=?");//com folder is api,	    
              pst.setString(1,objbean.getUsername());
              pst.setInt(10,objbean.getUserid());
              pst.setString(2,objbean.getPassword()); 
              pst.setString(3,objbean.getName());
              pst.setString(4,objbean.getAddress());
               pst.setString(5,objbean.getContact());
               pst.setString(6,objbean.getEmail());
               pst.setBoolean(7,objbean.isGender());
                pst.setString(9,objbean.getDOB());
               pst.setBoolean(8,objbean.isUserstatus());
              int i=pst.executeUpdate();
                 if(i>0)
                 {
                     return true;
                 }
                 else
                 {
                     return false;                     }
                  }
            catch(Exception e)
             {
                 System.out.println("UpdateById"+e);
             }
              finally
             {
                 try
                 {
                     //rs.close();
                         pst.close();
                         conn.close();
                 }
                 catch(Exception ex)
                 {
                     System.out.println(ex);
                 }
             }
                return true;
     }


    public int getMaxID() {
        Connection conn = null;//class for connection
        PreparedStatement pst = null;//to execute query
        ResultSet rs = null;//to fetch rresult
        ArrayList<UserBean> al = null;//to store data of EmpBean type
        UserBean objbean = null;
        try {
            conn = DBConnection.connect();//static method is called .//
            pst = conn.prepareStatement("select max(Userid) from usermaster");
            rs = pst.executeQuery();//it returns the index of the row in which data is stored;
            while (rs.next()) 
            {
                return rs.getInt("max(userid)") + 1;
            }
		//it returns the index of the row in which data is stored;

        } 
        catch (Exception e)
        {
            System.out.println("getMaxid" + e);
        } finally
        {
            try
            {
                rs.close();
                pst.close();
                conn.close();
            }
            catch (Exception ex)
            {
                System.out.println(ex);
            }
        }
        return 0;

    }
}
