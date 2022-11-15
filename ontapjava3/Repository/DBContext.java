/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ontapjava3.Repository;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DBContext {
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123456";
    private static final String SERVER = "NGUYENDUCHIEU\\SQLEXPRESS";
    private static final String PORT = "1433";
    private static final String DATABASE_NAME = "FINALASS_FPOLY_NET_JAVA_SM22_BL2";

    private static String CONNECT_STRING;

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = String.format("jdbc:sqlserver://%s:%s;databaseName=%s;"
                    + "user=%s;password=%s;encrypt=true;trustServerCertificate=true;",
                    SERVER, PORT, DATABASE_NAME, USERNAME, PASSWORD);
            CONNECT_STRING = url;
            System.out.println("Connect String có dạng: " + CONNECT_STRING);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(CONNECT_STRING);
    }
}
