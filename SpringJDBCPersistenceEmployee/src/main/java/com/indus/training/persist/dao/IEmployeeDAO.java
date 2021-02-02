package com.indus.training.persist.dao;

import com.indus.training.persist.entity.Employee;
import com.indus.training.persist.exception.EmployeePersistException;

public interface IEmployeeDAO 
{
	public Employee findEmployeeByID(int employeeId) throws EmployeePersistException;

}
