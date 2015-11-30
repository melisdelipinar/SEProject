/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author xxxxxxxxx
 */
public class database {
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    static final String DOMAIN_NAME="localhost";
    static final String DB_NAME="yemekgetir";
    static final String DB_URL="jdbc:mysql://" + DOMAIN_NAME + "/" + DB_NAME;
    
    private static  String username = "root";
    private static  String password = "";
    private static Connection connection=null;

    public database() {
    }

    
    
    
   public static boolean startDB(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection(DB_URL, username, password);
            
        } catch (ClassNotFoundException ex) {
           System.out.println("startdb - sqlexception");
            return false;
        } catch (SQLException ex) {
            System.out.println("startdb - exception");
            return false;
        }
        
        return true;
    }
    
    
    public static  boolean closeDB(){
        try {
            connection.close();
            
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static String getPassword() {
        return password;
    }

    public static String getUsername() {
        return username;
    }

}
