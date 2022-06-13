package com.wirpro;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
   
	private Connection connection;
	private Statement statement;
	
	public Connection createConnection() throws SQLException 
	{
		String jdbcURL = "jdbc:derby:studentdb;create=true";
		connection = DriverManager.getConnection(jdbcURL);
		System.out.println("DB Connected Created..");
		
		
		String createSQL ="Create Table Student (id int not null generated always as identity," 
		                   + "name varchar(60), subject varchar(60), assignment varchar(60), points int)" ;
		statement = connection.createStatement();                  
		statement.executeUpdate(createSQL);
		
		return connection;
	}
	
	public void closeConnection() {
		try {
			String dropSQL = "drop table Student";
			statement = connection.createStatement();
			statement.executeUpdate(dropSQL);
			
			String jdbcShutdownURL = "jdbc:derby:;shutdown=true";
			DriverManager.getConnection(jdbcShutdownURL);
			
		}catch(SQLException e) {
			if(e.getSQLState().equals("XJ015")) {
				System.out.println("DB Shutdown Gracefully..");
			}
			//e.printStackTrace();
		}
	}
	
}
