package com.happy.util;

import java.sql.*;

public class DBUtil {
    
    public static Connection getConnection()
    {
    	Connection conn=null;
		try
		{
		  Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
		  conn=DriverManager.getConnection("jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=HappyDB;user=sa;password=sa");
		  return conn;
		}
		catch(Exception e){
		e.printStackTrace();
		System.out.println("¡¨Ω” ß∞‹£°");
		return null;
		}
    }
    
}