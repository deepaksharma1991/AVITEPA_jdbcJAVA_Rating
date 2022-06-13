package com.wirpro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import com.wirpro.utils.AverageCalculator;

public class StudentCalculator {
	
	private Map<String,HashMap<String,Integer>> studentMap;
	private AverageCalculator avgCal;

	public void studentAverage(Connection con,String name) throws SQLException {
		
		studentMap = new HashMap<String,HashMap<String,Integer>>();
		avgCal = new AverageCalculator();
		
		String nameURL = "select subject,assignment,points from Student where name='" + name + "'";
		
		fetchData(con,nameURL);
		
		if(studentMap.isEmpty()) {
			System.out.println("Student named " + name + " doesn't exists :");		
		}else {
			avgCal.constructMap(studentMap,"Subject");
		}
		
	}
	
	public void subjectAverage(Connection con,String subject) throws SQLException {
		
		studentMap = new HashMap<String,HashMap<String,Integer>>();
		avgCal = new AverageCalculator();
		
		String nameURL = "select name,assignment,points from Student where subject='" + subject + "'";
		
		fetchData(con,nameURL);
		
		if(studentMap.isEmpty()) {
			System.out.println("Subject named " + subject + " doesn't exists :");
		}else {
			avgCal.constructMap(studentMap,"Name");
		}
		
	}
	
	
	public void fetchData(Connection connection,String sqlURL) throws SQLException {
		Statement st = connection.createStatement();	
		ResultSet rs = st.executeQuery(sqlURL);
		
		while(rs.next()) {
			
			if(studentMap.containsKey(rs.getString(1).trim())) {
				HashMap<String,Integer> hm1 = studentMap.get(rs.getString(1).trim());
				hm1.put(rs.getString(2).trim(),rs.getInt(3));
			}else {
				HashMap<String,Integer> hm2 = new HashMap<String,Integer>();
				hm2.put(rs.getString(2).trim(),rs.getInt(3));
				studentMap.put(rs.getString(1).trim(), hm2);
			}
		} //while loop ends
	}//fetchData ends
}
