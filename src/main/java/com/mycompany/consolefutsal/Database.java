
package com.mycompany.consolefutsal;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    public static void main(String[] args) throws ClassNotFoundException,SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String database="COMPANY";
        String server ="localhost";
        String username = "saugat";
        String password = "Nepal@123";
        int port = 3306;
        String ConnectionString="jdbc:mysql://"+server+":"+port+"/"+database;
        Connection con;
        con = DriverManager.getConnection(ConnectionString,username,password);
        if(con!=null){
            System.out.println("Connection Established");
        }
        
        
    }
    
}
