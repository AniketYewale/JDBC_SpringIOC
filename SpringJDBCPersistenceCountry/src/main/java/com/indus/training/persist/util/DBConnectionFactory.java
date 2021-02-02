package com.indus.training.persist.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.indus.training.persist.dao.ICountryDAO;
import com.indus.training.persist.dao.impl.CountryDAO;
import com.indus.training.persist.exception.PersistException;

public class DBConnectionFactory {
	
	private Properties dbProperties = new Properties();
	

	private DBConnectionFactory(String fileName) 
	{

		BufferedReader inputStream = null;
		try {
			inputStream = new BufferedReader(new FileReader(fileName));
			dbProperties.load(inputStream);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (inputStream != null)
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	} 
	

	// Instance factory method
	public static DBConnectionFactory getFactoryObject()
	   {
	      return new DBConnectionFactory("C:\\IndusTraining\\Advanced Java\\3. JDBC Basics\\JDBCPersistence\\src\\main\\resources\\DBProperties.txt");
	   }
	
	
	
	public Connection getDBConnection() throws PersistException 
	{ 
		Connection dbConObj = null;

		try {
				dbConObj = DriverManager.getConnection(dbProperties.getProperty("url"), dbProperties.getProperty("username"), dbProperties.getProperty("password"));
			} catch (SQLException e) {
			throw new PersistException("HR Schema: Countries Table : Country Class : Problem creating connection object", e);
		}

		return dbConObj;
	}
	
	
	public void closeConnection(Connection conObj) throws PersistException
	{
		try {
			conObj.close();
		} catch (SQLException e) {
			throw new PersistException("DBConnectionFactory : getDBConnection method : Problem closing connection object");
		}
	}
	
	
}
