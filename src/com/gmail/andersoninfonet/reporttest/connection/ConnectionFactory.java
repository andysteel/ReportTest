package com.gmail.andersoninfonet.reporttest.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	

	public Connection getConnection(){
		try{
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			return DriverManager.getConnection("jdbc:mysql://localhost/contatos", "root", "502010");
		}catch(SQLException e){
			throw new RuntimeException();
		}
	}
}
