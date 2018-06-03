import java.sql.SQLException;
import java.util.ArrayList;

import Mediator.Database;
import Mediator.ModelManager;
import Model.Date;
import Model.Employee;
import Model.Milestone;
import Model.Payment;
import Model.Project;

public class HelloWorld {
	public static void main(String[] args) throws Exception {
		Database database = null;
		ModelManager modelManager = null;
		try {
			database = new Database();
			modelManager = new ModelManager();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		// Employee Start-----------------------------------------------------------------------------------------------
		/*
			// Add Employee Start++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			java.sql.Date date = new java.sql.Date(0,0,0);     // we got a feature here that java.sql.Date counts from 1899.12.31
			Employee emp = new Employee(null,"lukas", "STRONL", "GAIDZIU10", "12311", "lukasass@gmail.com", "+458488484", "LOl",date);
			database.saveEmployee(emp);
			// Add Employee End++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		*/
		
			// ListAll Employee Start***************************************************************************************************
	//	modelManager.getAllEmployees();
			// ListAll Employee End***************************************************************************************************
		
	
			// ListByID Employee Start***************************************************************************************************
	//	modelManager.getEmployeeById(771);
			// ListByID Employee End***************************************************************************************************
	
		
			// Remove Employee Start***************************************************************************************************
	//	modelManager.removeEmployeeById(12); // throws exception but removes stuff good
			// Remove Employee End***************************************************************************************************
			 
		
		// Employee End-----------------------------------------------------------------------------------------------
		
		
	
		// Project Start----------------------------------------------------------------------------------------------- tested 0206
		
			// Add Project Start++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			java.sql.Date deadline = new java.sql.Date(0,0,0);
			java.sql.Date startDate = new java.sql.Date(0,0,0);
			java.sql.Date endDate = new java.sql.Date(0,0,0);	// we got a feature here that java.sql.Date counts from 1899.12.31
			Employee emp = modelManager.getEmployeeById(3);
			Project proj = new Project(true, false, 1,deadline, 4584, "MrNIIIICE", "boi, I want this job", startDate, endDate, "Ablazer2", "awesomeFreelanceSite", emp.getEmployeeID(), null);
			database.saveProject(proj);
			// Add Project End++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		
			// ListAll Project Start***************************************************************************************************
		//	modelManager.getAllProjects();
			// ListAll Project End***************************************************************************************************
		
		
			// ListByID Project Start***************************************************************************************************
		//	modelManager.getProjectById(3);
			// ListByID Project End***************************************************************************************************
		
		
			// Remove Project Start***************************************************************************************************
		//	modelManager.removeProjectById(2); // throws exception but removes stuff good
			// Remove Project End***************************************************************************************************
			 
		
		// Project End-----------------------------------------------------------------------------------------------
		
		
		
		// Payment Start----------------------------------------------------------------------------------------------- tested 0206
		/*
			// Add Payment Start++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			Employee emp = modelManager.getEmployeeById(771);
			Project proj = modelManager.getProjectById(1);
			Payment paym = new Payment(1,null,500, 43, 400, 100, 250, emp.getEmployeeID(), proj.getProjectID());
			database.savePayment(paym);
			// Add Payment End++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		*/
		
			// ListAll Payment Start***************************************************************************************************
		//	modelManager.getAllPayments();
			// ListAll Payment End***************************************************************************************************
		
		
			// ListByID Payment Start***************************************************************************************************
		//	modelManager.getPaymentById(1);
			// ListByID Payment End***************************************************************************************************
		
		
			// Remove Payment Start***************************************************************************************************
		//	modelManager.removePaymentById(1); // throws exception but removes stuff good
			// Remove Payment End***************************************************************************************************
		 
		
		// Payment End-----------------------------------------------------------------------------------------------
	
		// Milestone Start-----------------------------------------------------------------------------------------------
				/*
					// Add Milestone Start++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					java.sql.Date deadline = new java.sql.Date(0,0,0);
					Employee emp = modelManager.getEmployeeById(771);
					Project proj = modelManager.getProjectById(1);
					Milestone mil = new Milestone("description", 400, deadline, null, emp.getEmployeeID(), proj.getProjectID());
					database.saveMilestone(mil);
					// Add Milestone End++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				*/
				
					// ListAll Milestone Start***************************************************************************************************
				//	modelManager.getAllMilestones();
					// ListAll Milestone End***************************************************************************************************
				
				
					// ListByID Milestone Start***************************************************************************************************
				//	modelManager.getMilestoneById(4);
					// ListByID Milestone End***************************************************************************************************
				
				
					// Remove Milestone Start***************************************************************************************************
				//	modelManager.removeMilestoneById(2); // throws exception but removes stuff good
					// Remove Milestone End***************************************************************************************************
					 
				
				// Milestone End-----------------------------------------------------------------------------------------------



	}
}