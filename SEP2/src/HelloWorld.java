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
	public static void main(String[] args) {
		Database database = null;
		try {
			database = new Database();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// Employee
		Date date = new Date(01, 01, 2010);
		//	Employee emp = new Employee("lukas", "STRONL", "GAIDZIU10", "12311", "lukasass@gmail.com", "+458488484", "LOl",date);

	
	
		EmployeeList emplist = new EmployeeList();
		emplist.setEmployeeList(database.getAllEmployees());
		ProjectList projlist = new ProjectList();
		projlist.setProjectList(database.getAllProjects());
		
		System.out.println(projlist.getProjectByID(210));
		
		//Payment
		PaymentList paymlist = new PaymentList();
		Payment paym = new Payment(2000, 20, 1800, 200, 10, projlist.getProjectByID(210), emplist.getEmployeeByID(735));
		
		try {
			paymlist.addPayment(paym);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	
		
		// database.saveEmployeeList(emplist);
		//database.saveProjectList(projlist);
		 database.savePaymentList(paymlist);

		// database.saveMilestone(mil1);
		// database.saveEmployee(emp);
		// database.savePayment(payment);
		// database.saveProject(proj);

		ArrayList list = new ArrayList<>();
		list = database.getAllEmployees();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		

	}
}