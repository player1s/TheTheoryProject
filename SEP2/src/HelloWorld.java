import java.sql.SQLException;
import java.util.ArrayList;

import Mediator.Database;
import Model.Date;
import Model.Employee;
import Model.EmployeeList;
import Model.Milestone;
import Model.Payment;
import Model.Project;

public class HelloWorld {
	public static void main(String[] args)
	{
		// Employee
		Date date = new Date(01,01,2010);
		Employee emp = new Employee("12","lukas", "STRONL", "GAIDZIU10", "12311", "lukasass@gmail.com", "+458488484", "LOl", date);
		Employee emp1 = new Employee("12","lukas", "STRONL", "GAIDZIU10", "12311", "lukasass@gmail.com", "+458488484", "LOl", date);

	//	Payment payment = new Payment("12", 2000, 20, 1800, 200, 10);
		Project proj = new Project(1, false, false, 1, date, 10000, "swx", "B", "DUCHAS", date, date);
		Milestone mil1 = new Milestone("sd","sfwfss",1,date);
	/*	
		Database database = null;
		try {
			database = new Database();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		EmployeeList list = new EmployeeList();
		try {
			list.addEmployee(emp);
			list.addEmployee(emp1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int i = 0; i < list.getNumberOfEmployees(); i++) {
			System.out.println(list.getEmployee(i));
		}
		
		
       //database.saveMilestone(mil1);
		//database.saveEmployee(emp);
	//database.savePayment(payment);
		//database.saveProject(proj);
		
		/*ArrayList list = new ArrayList<>();
		list = database.getAllEmployees();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}*/
		
		

		

		
		
		
		
		
		
	}
}