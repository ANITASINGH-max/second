/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineexam;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author roneetmichael
 */
public class DBConnection {
    
    public DBConnection()
    {
        
    }
    public static Connection getConnection() 
    {  
         try {
             Class.forName("com.mysql.jdbc.Driver");
               System.out.println("loaded");
               Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam?serverTimeZone=UTC","root","" );
              System.out.println("connected");
              return con;
         } catch (ClassNotFoundException | SQLException ex) {
             return null;
         } 
         
     
     
    }
    public static void main(String[] args) {
        
        getConnection();
           
    }
}