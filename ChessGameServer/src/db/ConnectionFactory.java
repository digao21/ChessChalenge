/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class ConnectionFactory {
    private static boolean hasInitialized = false;
    private final static String drive = "com.mysql.jdbc.Driver";
    private final static String dbURL = "jdbc:mysql://localhost/sakila";
    private final static String user = "root";
    private final static String password = "dramsql";
    
    public static void initialize(){
        try {
            Class.forName(drive);
            hasInitialized = true;
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("ConnectionFactory initialize fail: drive not found");
        }
    }

    public static Connection newConnection(){        
        try {
            return DriverManager.getConnection(dbURL,user,password);
        } catch (SQLException ex) {
            if(!hasInitialized)                
                throw new RuntimeException("Cant connect to database\n" + "ConnectionFactory is not initialized");
            else
                throw new RuntimeException("Cant connect to database\n" + ex.toString());
        }
        
    }
    
}
