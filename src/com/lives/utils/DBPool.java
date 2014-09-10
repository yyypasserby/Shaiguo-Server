package com.lives.utils;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBPool {

	final static String driverName = "com.mysql.jdbc.Driver";
	final static String url = "jdbc:mysql://223.3.80.99:3306/Shaiguotest";
	private String username = "admin";
	private String pwd = "140";
	int minSize = 1;
	int initialSize = 1;
	int maxSize=500;
	int incrementalSize =5;
	int maxIdleTime = 60;
	private static DBPool dbPool;
	private ComboPooledDataSource dataSource;
	
	static {
		try {
			dbPool = new DBPool();
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public DBPool() throws PropertyVetoException{
		dataSource = new ComboPooledDataSource();
		dataSource.setUser(username);
		dataSource.setPassword(pwd);
		dataSource.setJdbcUrl(url);
		dataSource.setDriverClass(driverName);
		dataSource.setInitialPoolSize(this.initialSize);
		dataSource.setMinPoolSize(this.minSize);
		dataSource.setMaxPoolSize(this.maxSize);
		dataSource.setAcquireIncrement(this.incrementalSize);
		dataSource.setMaxStatements(maxSize);
		dataSource.setMaxIdleTime(maxIdleTime);
	}
	
	public final static DBPool getInstance(){
		return dbPool;
	}
	
	public final Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Pool connection failed");
			e.printStackTrace();
			return null;
		}
	}
}
