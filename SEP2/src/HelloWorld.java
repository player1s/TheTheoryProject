import java.sql.SQLException;
import java.util.ArrayList;

import Mediator.Database;
import Model.Date;
import Model.Employee;
import Model.EmployeeList;
import Model.Milestone;
import Model.Payment;
import Model.PaymentList;
import Model.Project;
import Model.ProjectList;

public class HelloWorld {
	public static void main(String[] args) throws Exception {
		Database database = null;
		try {
			database = new Database();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		// Employee Start-----------------------------------------------------------------------------------------------
		/*
			// Add Employee Start++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			java.sql.Date date = new java.sql.Date(0,0,0);     // we got a feature here that java.sql.Date counts from 1899.12.31
			Employee emp = new Employee(15,"lukas", "STRONL", "GAIDZIU10", "12311", "lukasass@gmail.com", "+458488484", "LOl",date);
			database.saveEmployee(emp);
			// Add Employee End++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 */
		/*
			// ListAll Employee Start***************************************************************************************************
			database.getAllEmployeesToString();
			// ListAll Employee End***************************************************************************************************
		*/
		/*
			// ListByID Employee Start***************************************************************************************************
			database.getEmployeeByIdToString(4);
			// ListByID Employee End***************************************************************************************************
		*/
		/*
			// Remove Employee Start***************************************************************************************************
			database.removeEmployeeById(9); // throws exception but removes stuff good
			// Remove Employee End***************************************************************************************************
		*/	 
		
		// Employee End-----------------------------------------------------------------------------------------------
		
		
	
		// Project Start-----------------------------------------------------------------------------------------------
		/*
			// Add Project Start++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			java.sql.Date deadline = new java.sql.Date(0,0,0);
			java.sql.Date startDate = new java.sql.Date(0,0,0);
			java.sql.Date endDate = new java.sql.Date(0,0,0);	// we got a feature here that java.sql.Date counts from 1899.12.31
			Project proj = new Project(3, true, false, 1,deadline, 4584, "MrNIIIICE", "boi, I want this job", startDate, endDate, "Ablazer", "awesomeFreelanceSite", 1);
			database.saveProject(proj);
			// Add Project End++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 */
		/*
			// ListAll Project Start***************************************************************************************************
			database.getAllProjectsToString();
			// ListAll Project End***************************************************************************************************
		*/
		/*
			// ListByID Project Start***************************************************************************************************
			database.getProjectByIdToString(3);
			// ListByID Project End***************************************************************************************************
		*/
		/*
			// Remove Project Start***************************************************************************************************
			database.removeProjectById(2); // throws exception but removes stuff good
			// Remove Project End***************************************************************************************************
		*/	 
		
		// Project End-----------------------------------------------------------------------------------------------
		
		
		
		// Payment Start-----------------------------------------------------------------------------------------------
		/*
			// Add Payment Start++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			Payment paym = new Payment(4,500, 43, 400, 100, 250, 1, 1);
			database.savePayment(paym);
			// Add Payment End++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		*/
		/*
			// ListAll Payment Start***************************************************************************************************
			database.getAllPaymentsToString();
			// ListAll Payment End***************************************************************************************************
		*/
		/*
			// ListByID Payment Start***************************************************************************************************
			database.getPaymentByIdToString(4);
			// ListByID Payment End***************************************************************************************************
		*/
		/*
			// Remove Payment Start***************************************************************************************************
			database.removePaymentById(4); // throws exception but removes stuff good
			// Remove Payment End***************************************************************************************************
		*/	 
		
		// Payment End-----------------------------------------------------------------------------------------------
	
		


	}
}