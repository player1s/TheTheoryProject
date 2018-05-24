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
		Employee emp = new Employee(12,"lukas", "STRONL", "GAIDZIU10", "12311", "lukasass@gmail.com", "+458488484", "LOl", date);

		Payment payment = new Payment(12, 2000, 20, 1800, 200, 10);
		Project proj = new Project(2,"name", false, false, 1, date, 10000, "swx", "B", "winningP", date, date, emp);
		

		Database database = null;
		try {
			database = new Database();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
				
       //database.saveMilestone(mil1);
		//database.saveEmployee(emp);
	//database.savePayment(payment);
		//database.saveProject(proj);
		
		ArrayList list = new ArrayList<>();
		list = database.getAllProjects();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		

		

		
		
		
		
		
		
	}
}