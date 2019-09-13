/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codelevelsecurity.services;

import codelevelsecurity.beans.ProgramAccessMasterBean;
import codelevelsecurity.beans.ProgramMasterBean;
import codelevelsecurity.db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author win8
 */
public class ProgramAccessedServices {

    Connection conn = null;
    PreparedStatement pstmt = null,pstm=null;
    ResultSet rs = null,ts=null;
    ArrayList<ProgramMasterBean> al = null;

    public int getProgramId(int ui, String pn) {
        int programId = 0;
        try {
            conn = DBConnection.connect();
            System.out.println("UserID " + ui + "Program NAme :" + pn);
            pstmt = conn.prepareStatement("select programid from programmaster where userid=? and programname=?");
            pstmt.setInt(1, ui);
            pstmt.setString(2, pn);
            rs = pstmt.executeQuery();
            al=new ArrayList();
            System.out.println("here " + rs);
            if (rs.next()) {
                programId = rs.getInt("Programid");

                System.out.println("get program id :" + programId);
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
        return programId;
    }

    public boolean addProgramAccessMaster(ProgramAccessMasterBean objbean) {
        System.out.print(objbean.getProgramId());
        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("insert into programaccessmaster(Programid,Userid,Accessdate) values(?,?,?)");

            pstmt.setInt(1, objbean.getProgramId());
            pstmt.setInt(2, objbean.getUserId());

            pstmt.setString(3, objbean.getAccessDate());

            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("AccessedProgramsServices/addProgramsMAster():........." + e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("AccessedProgramsServices/addProgramsServices():" + e);
            }
        }
        return false;

    }

    public ArrayList<ProgramMasterBean> accessedProgramsReport() {
        try {
            conn = DBConnection.connect();
            //pstmt=conn.prepareStatement("select programmaster.Programid,Userid,Programname,Createdate,Accessdate from programmaster inner join programaccessmaster on programmaster.Programid=programaccessmaster.Programid");
            pstmt = conn.prepareStatement("select * from programaccessmaster");
            rs = pstmt.executeQuery();
            al = new ArrayList();
            ProgramMasterBean objbean = null;
           int i = 0;
            while (rs.next()) {
                objbean = new ProgramMasterBean();
                objbean.setProgramaccessid(rs.getInt("programaccessid"));
                objbean.setProgramId(rs.getInt("Programid"));
               i = rs.getInt("Programid");
                
                System.out.println("id is "+i);
                objbean.setUserId(rs.getInt("Userid"));
                objbean.setAccessDate(rs.getString("accessdate"));
                System.out.println("count");

                pstm = conn.prepareStatement("select * from programmaster where programid=?");
                pstm.setInt(1, i);
                ts = pstm.executeQuery();

                while (ts.next()) {
                    objbean.setProgramName(ts.getString("programname"));
                    objbean.setCreateDate(ts.getString("createdate"));
             al.add(objbean);
                }
               
            }

            return al;
        } catch (Exception e) {
            System.out.println("AccessedProgramsServices/accessedProgramsReport() :" + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("AccessedProgramsServices/AccessedProgramsReport() :" + e);
            }
        }
        return al;
    }

    public ArrayList getUsersByNameDate(String un, String date) {
        ArrayList al = null;
        try {
            conn = DBConnection.connect();
            if (!un.isEmpty() && date.isEmpty()) {
                pstmt = conn.prepareStatement("select programmaster.Program_ID,programmaster.User_ID,Program_Name,Create_Date,Access_Date from programmaster inner join programaccessmaster on programmaster.Program_ID=programaccessmaster.Program_ID inner join usermaster on programmaster.User_ID=usermaster.User_ID  where Username=?");
                pstmt.setString(1, un);
            } else if (un.isEmpty() && !date.isEmpty()) {
                pstmt = conn.prepareStatement("select programmaster.Program_ID,programmaster.User_ID,Program_Name,Create_Date,Access_Date from programmaster inner join programaccessmaster on programmaster.Program_ID=programaccessmaster.Program_ID inner join usermaster on programmaster.User_ID=usermaster.User_ID  where date(Access_Date) Like ?");
                pstmt.setString(1, date + "%");

            } else {
                pstmt = conn.prepareStatement("select programmaster.Program_ID,programmaster.User_ID,Program_Name,Create_Date,Access_Date from programmaster inner join programaccessmaster on programmaster.Program_ID=programaccessmaster.Program_ID inner join usermaster on programmaster.User_ID=usermaster.User_ID  where Username=? && date(Access_Date) Like ?");
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
                objbean.setUpdateDate(rs.getString("Access_Date"));
                al.add(objbean);
            }
        } catch (Exception e) {
            System.out.println("AccessedProgramsServices/getUserByNameDate() :" + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("AccessedProgramsServices/getUserByNameDate() :" + e);
            }
        }
        return al;
    }

}
