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
import java.util.ArrayList;

/**
 *
 * @author Taranpreet Kaur
 */
public class ProfileDetailServices {

    public UserBean getbyid(int id) {
        Connection conn = null;//class for connection
        PreparedStatement pst = null;//to execute query
        ResultSet rs = null;//to fetch rresult

        UserBean objbean = null;
        try {//get all fields
            conn = DBConnection.connect();//static method is called .//for doing connection.
            pst = conn.prepareStatement("select * from usermaster where userid=?");//com folder is api,	
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                objbean = new UserBean();
                objbean.setUserid(rs.getInt("Userid"));
                objbean.setUsername(rs.getString("Username"));
                objbean.setPassword(rs.getString("Password"));
                // objbean.setUsertype(rs.getString("Usertype"));
                objbean.setName(rs.getString("Name"));
                objbean.setContact(rs.getString("Contact"));
                objbean.setEmail(rs.getString("Email"));
                //objbean.setAddress(rs.getString("Address"));
                // objbean.setUserstatus(rs.getBoolean("Userstatus"));
                //objbean.setGender(rs.getBoolean("Gender"));
                objbean.setDOB(rs.getString("DOB"));
                System.out.println("dob "+rs.getString("DOB"));
                return objbean;
            }

        } catch (Exception e) {
            System.out.println("getbyid" + e);
        } finally {
            try {
                rs.close();
                pst.close();
                conn.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        return null;
    }

    public boolean UpdateById(UserBean objbean) {
        Connection conn = null;//class for connection
        PreparedStatement pst = null;//to execute query
        try {
            conn = DBConnection.connect();//static method is called .//
            pst = conn.prepareStatement("update usermaster set Password=?,Name=?,Contact=?,Email=?,DOB=? where Userid=?");//com folder is api,	    
            //  pst.setString(1,objbean.getUsername());
            pst.setInt(6, objbean.getUserid());
            pst.setString(1, objbean.getPassword());
            pst.setString(2, objbean.getName());
            //pst.setString(,objbean.getAddress());
            pst.setString(3, objbean.getContact());
            pst.setString(4, objbean.getEmail());
            //pst.setBoolean(7,objbean.isGender());
            pst.setString(5, objbean.getDOB());
            // pst.setBoolean(8,objbean.isUserstatus());
            int i = pst.executeUpdate();
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("UpdateById" + e);
        } finally {
            try {
                //rs.close();
                pst.close();
                conn.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        return false;
    }

}
