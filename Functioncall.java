package com.ty.callingfunction;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Functioncall {
public static void main(String[] args) {
	String url = "jdbc:postgresql://localhost:5432/students";
	String username = "postgres";
	String password = "123";
	try {
		//step1
		Class.forName("org.postgresql.Driver");
		
		//step 2
	 Connection	con=DriverManager.getConnection(url,username,password);
	 
	 //step 3
	 CallableStatement cstm=con.prepareCall("select count_by_gender(?)");
	 //step 4
	 cstm.setString(1,"male");
	 
	 ResultSet rs=cstm.executeQuery();
	 
	 rs.next();
	 int result=rs.getInt(1);
	 System.out.println("the result is "+result);
	 con.close();
	 
	 
	 
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 	
}
}
