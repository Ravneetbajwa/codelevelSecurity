/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codelevelsecurity.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Taranpreet Kaur
 */
public class DBConnection {
      public static Connection connect() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql:///CodeLevelSecurity";           //it is connecting   //firstly finally works then try works;
            conn = DriverManager.getConnection(url, "root", "");
            return (conn);
        } catch (Exception e) {
            System.out.println("connect" + e);
        }
        return (conn);                   //it is a connection file 
    }

    
}
