package com.wirpro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoadStudentData {
    
	public void loadStudentData(Connection con) throws IOException {
		String line;
    	File file;
    	FileReader fileReader = null;
    	BufferedReader bReader = null;
    	try {
    		 file = new File("src\\main\\resources\\data.txt");
   		     String fileName = file.getAbsolutePath();
   	         fileReader = new FileReader(fileName);
   	         bReader = new BufferedReader(fileReader);
   	         line = bReader.readLine();
    	     while( line != null)
    	     {
    	    	 
    	    	 String[] lineArray = line.trim().split(",");
    	    	 
    	    	 String sql = "insert into Student(name,subject,assignment,points) values(?,?,?,?)";
    	    	 PreparedStatement ps = con.prepareStatement(sql);
    	    	 ps.setString(1, lineArray[1]);
    	    	 ps.setString(2, lineArray[2]);
    	    	 ps.setString(3, lineArray[3]);
    	    	 ps.setInt(4, Integer.parseInt(lineArray[5]));
    	    	 ps.executeUpdate();
    	    	 
    	    	 line = bReader.readLine();
    	     }
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    	finally {
    		bReader.close();
    		fileReader.close();
  
    	}
	}
	
	public void displayData(Connection con) throws SQLException {
		
		String sql = "select * from Student";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getString(3) + "," + rs.getString(4) + "," + rs.getInt(5));
		}
	}
}
