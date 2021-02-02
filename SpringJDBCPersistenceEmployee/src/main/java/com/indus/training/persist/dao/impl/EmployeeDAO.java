package com.indus.training.persist.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.indus.training.persist.dao.IEmployeeDAO;
import com.indus.training.persist.entity.Employee;
import com.indus.training.persist.exception.EmployeePersistException;
import com.indus.training.persist.util.DBConnectionFactory;

public class EmployeeDAO implements IEmployeeDAO 
{

	private DBConnectionFactory dbConnFactoryObj;

	
	public void setDbConnFactoryObj(DBConnectionFactory dbConnFactoryObj) 
	{
		this.dbConnFactoryObj = dbConnFactoryObj;
	}


	public Employee findEmployeeByID(int employeeId) throws EmployeePersistException 
	{
		Employee employeeObj = null;

		Connection hrDbConObj = null;
		Statement hrDbEmployeeStmt = null;
		ResultSet hrDbEmployeeResultset = null;

		try {
			hrDbConObj = dbConnFactoryObj.getDBConnection();

			hrDbEmployeeStmt = hrDbConObj.createStatement();

			String selectSQL = "SELECT * FROM HR.EMPLOYEES E WHERE E.EMPLOYEE_ID = '" + employeeId + "'";

			hrDbEmployeeResultset = hrDbEmployeeStmt.executeQuery(selectSQL);

			while (hrDbEmployeeResultset.next()) 
			{
				employeeObj = new Employee();
				employeeObj.setEmployee_id(hrDbEmployeeResultset.getInt("EMPLOYEE_ID"));
				employeeObj.setfName(hrDbEmployeeResultset.getString("FIRST_NAME"));
				employeeObj.setlName(hrDbEmployeeResultset.getString("LAST_NAME"));
				employeeObj.setEmail(hrDbEmployeeResultset.getString("EMAIL"));
				employeeObj.setPhoneNumber(hrDbEmployeeResultset.getString("PHONE_NUMBER"));
				employeeObj.setHireDate(hrDbEmployeeResultset.getDate("HIRE_DATE"));
				employeeObj.setJobID(hrDbEmployeeResultset.getInt("JOB_ID"));
				employeeObj.setSalary(hrDbEmployeeResultset.getDouble("SALARY"));
				employeeObj.setManagerID(hrDbEmployeeResultset.getInt("MANAGER_ID"));
				employeeObj.setDepartmentID(hrDbEmployeeResultset.getInt("DEPARTMENT_ID"));

			}
		} catch (Exception ex) {
			throw new EmployeePersistException(
					"HR Schema: Employee Table : Employee Class : findEmployeeByID : Processing Select query and ResultSet", ex);
		} finally {
			if (hrDbEmployeeResultset != null) 
			{
				try {
					hrDbEmployeeResultset.close();
				} catch (SQLException e) {
					throw new EmployeePersistException(
							"HR Schema: Employee Table :Employee Class : findEmployeeByID : Unable to close Result Set ",
							e);
				}
			}

			if (hrDbEmployeeStmt != null) 
			{
				try {
					hrDbEmployeeStmt.close();
				} catch (SQLException e) {
					throw new EmployeePersistException(
							"HR Schema: Employee Table :Employee Class : findEmployeeByID : Unable to close JDBC Statement ",
							e);
				}
			}

			if (hrDbConObj != null) 
			{
				dbConnFactoryObj.closeConnection(hrDbConObj);
			}
		}

		return employeeObj;
	}

}