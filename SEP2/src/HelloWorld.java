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
	public static void main(String[] args)
	{
		// Employee
		Date date = new Date(01,01,2010);
		Employee emp = new Employee("lukas", "STRONL", "GAIDZIU10", "12311", "lukasass@gmail.com", "+458488484", "LOl", date);
		EmployeeList emplist = new EmployeeList();
		try {
			emplist.addEmployee(emp);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		Project proj = new Project(2,"name", false, false, 1, date, 10000, "swx", "B", "winningP", date, date, emp);
		ProjectList projlist = new ProjectList();
		try {
			projlist.addProjet(proj);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		Payment payment = new Payment(13, 2000, 20, 1800, 200, 10, proj, emp);
		
		

		Database database = null;
		try {
			database = new Database();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	//	database.saveEmployeeList(emplist);		
		database.saveProjectList(projlist);		
	//	database.saveEmployeeList(emplist);		
		
       //database.saveMilestone(mil1);
		//database.saveEmployee(emp);
	//database.savePayment(payment);
	//	database.saveProject(proj);
		
		ArrayList list = new ArrayList<>();
		list = database.getAllEmployees();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		

		

		
		
		
		
		
		
	}
}