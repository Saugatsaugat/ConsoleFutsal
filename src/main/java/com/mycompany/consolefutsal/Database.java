package com.mycompany.consolefutsal;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    Connection con;
    public Database() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String database = "COMPANY";
        String server = "localhost";
        String username = "saugat";
        String password = "Nepal@123";
        int port = 3306;
        String ConnectionString = "jdbc:mysql://" + server + ":" + port + "/" + database;
        con = DriverManager.getConnection(ConnectionString, username, password);
    }
    public Connection getCon(){
        return con;
    }  
    
}
