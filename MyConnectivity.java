/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
class MyConnectivity {
    public static Connection getConnection() throws SQLException 
    {  
         Connection con=null;
         try {
             Class.forName("com.mysql.jdbc.Driver");
              // System.out.println("loaded");
              con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam?serverTimeZone=UTC","root","");
             // System.out.println("connected");
         } catch (ClassNotFoundException | SQLException ex) {
             Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
         } 
     
      return con; 
    }
public static void main(String[] args){
    
}
    
    
}
