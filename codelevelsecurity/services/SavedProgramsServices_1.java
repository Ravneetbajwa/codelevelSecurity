/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codelevelsecurity.services;

import codelevelsecurity.beans.ProgramMasterBean;
import codelevelsecurity.db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author win8
 */
public class SavedProgramsServices_1 {

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList al = null;

    public int getUserId(String un) {
        int userId = 0;
        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("select Userid from usermaster where Username=?");
            pstmt.setString(1, un);
            rs = pstmt.executeQuery();
            al = new ArrayList();
            if (rs.next()) {
                userId = rs.getInt("Userid");

            }
        } catch (Exception e) {
            System.out.println("SavedProgramsServices/getUserId: " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("SavedProgramsServices/getUserId :" + e);
            }
        }
        return userId;
    }

    public String getCurrentDate() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(d);

        System.out.println(date);
        return date;
    }

    public boolean addProgramsMaster(ProgramMasterBean objbean) {
        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("insert into programmaster(Userid,Programname,Programpath,Createdate) values(?,?,?,?)");
            //pstmt.setInt(1, objbean.getProgramId());
            pstmt.setInt(1, objbean.getUserId());
            pstmt.setString(2, objbean.getProgramName());
            pstmt.setString(3, objbean.getProgramPath());
            pstmt.setString(4, objbean.getCreateDate());

            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("SavedProgramsServices/addProgramsMaster():" + e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("SavedProgramsServices/addProgramsServices():" + e);
            }
        }
        return false;

    }

    public ArrayList savedProgramsReport() {
        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("select * from programmaster");
            rs = pstmt.executeQuery();
            al = new ArrayList();
            while (rs.next()) {
                ProgramMasterBean objbean = new ProgramMasterBean();
                objbean.setProgramId(rs.getInt("Programid"));
                objbean.setUserId(rs.getInt("Userid"));
                objbean.setProgramName(rs.getString("Programname"));
                objbean.setCreateDate(rs.getString("Createdate"));
                objbean.setProgramPath(rs.getString("Programpath"));
                al.add(objbean);
            }
        } catch (Exception e) {
            System.out.println("SavedProgramsServices/savedProgramsReport() :" + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("SavedProgramsServices/SavedProgramsReport() :" + e);
            }
        }
        return al;
    }

  /*  public ArrayList getUsersByNameDate(String un, String date) {
        ArrayList al = null;
        try {
            conn = DBConnection.connect();
            if (!un.isEmpty() && date.isEmpty()) {
                pstmt = conn.prepareStatement("select * from programmaster  where Username=?");
                pstmt.setString(1, un);
            } else if (un.isEmpty() && !date.isEmpty()) {
                pstmt = conn.prepareStatement("select * from programmaster  where date(Creatdate) Like ?");
                pstmt.setString(1, date + "%");

            } else {
                pstmt = conn.prepareStatement("select * from programmaster  where Username=? && date(Createdate) Like ?");
                pstmt.setString(1, un);
                pstmt.setString(2, date + "%");
            }
            rs = pstmt.executeQuery();
            al = new ArrayList();
            while (rs.next()) {
                ProgramMasterBean objbean = new ProgramMasterBean();
                objbean.setProgramId(rs.getInt("Program_ID"));
                objbean.setUserId(rs.getInt("User_ID"));
                objbean.setProgramName(rs.getString("Program_Name"));
                objbean.setCreateDate(rs.getString("Create_Date"));
                objbean.setProgramPath(rs.getString("Program_Path"));
                al.add(objbean);
            }
        } catch (Exception e) {
            System.out.println("SavedProgramsServices/getUserByNameDate() :" + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("SavedProgramsServices/getUserByNameDate() :" + e);
            }
        }
        return al;
    }*/
}
