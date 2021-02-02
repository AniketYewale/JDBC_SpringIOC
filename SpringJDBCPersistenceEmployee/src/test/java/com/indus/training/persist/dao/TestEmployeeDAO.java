package com.indus.training.persist.dao;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.indus.training.persist.entity.Employee;
import com.indus.training.persist.exception.EmployeePersistException;

public class TestEmployeeDAO 
{

	private IEmployeeDAO iEmployeeDAO = null;
	private ApplicationContext ctx = null;

	@Before
	public void setUp() throws Exception 
	{
	 // iEmployeeDAO = new EmployeeDAO();
		ctx = new ClassPathXmlApplicationContext("beans.xml");
		iEmployeeDAO = (IEmployeeDAO) ctx.getBean("employeeDAOObj");
	}

	@After
	public void tearDown() throws Exception 
	{
		iEmployeeDAO = null;
		ctx = null;
	}


	@Test
	public void findEmployeeByIDTest1() {
		int employeeId = 100;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateinString = "1987-06-17";
		Date ConvDate;
		
		Employee employeeExpObj = new Employee();
		Employee employeeActObj = null;
		

		try {
			ConvDate = sdf.parse(dateinString);
			
			employeeExpObj.setEmployee_id(100);
			employeeExpObj.setfName("Steven");
			employeeExpObj.setlName("King");
			employeeExpObj.setEmail("steven.king@sqltutorial.org");
			employeeExpObj.setPhoneNumber("515.123.4567");
			employeeExpObj.setHireDate(ConvDate);
			employeeExpObj.setJobID(4);
			employeeExpObj.setSalary(24000.00);
			employeeExpObj.setManagerID(0);
			employeeExpObj.setDepartmentID(9);		

			employeeActObj = iEmployeeDAO.findEmployeeByID(employeeId);
			System.out.println("Test Act Output : " + employeeActObj);
			System.out.println("Test Exp Output : " + employeeExpObj);

		 }catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (EmployeePersistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(employeeExpObj, employeeActObj);

	}
	
	
	@Test
	public void findEmployeeByIDTest2() {
		int employeeId = 101;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateinString = "1989-09-21";
		Date ConvDate;
		
		Employee employeeExpObj = new Employee();
		Employee employeeActObj = null;
		

		try {
			ConvDate = sdf.parse(dateinString);
			
			employeeExpObj.setEmployee_id(101);
			employeeExpObj.setfName("Neena");
			employeeExpObj.setlName("Kochhar");
			employeeExpObj.setEmail("neena.kochhar@sqltutorial.org");
			employeeExpObj.setPhoneNumber("515.123.4568");
			employeeExpObj.setHireDate(ConvDate);
			employeeExpObj.setJobID(5);
			employeeExpObj.setSalary(17000.00);
			employeeExpObj.setManagerID(100);
			employeeExpObj.setDepartmentID(9);		

			employeeActObj = iEmployeeDAO.findEmployeeByID(employeeId);
			System.out.println("Test Act Output : " + employeeActObj);
			System.out.println("Test Exp Output : " + employeeExpObj);

		 }catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (EmployeePersistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(employeeExpObj, employeeActObj);

	}
	
	
}
