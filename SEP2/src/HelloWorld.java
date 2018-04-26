import Mediator.Database;
import Model.Date;
import Model.Employee;
import Model.Payment;
import Model.Project;

public class HelloWorld {
	public static void main(String[] args)
	{
		// Employee
		Date date = new Date(30,01,2010);
		Employee emp = new Employee("M15","LukaasS", "STRONL", "GAIDZIU10", "12311", "lukasass@gmail.com", "+458488484", "LOl", date);
		//String sql = "insert into Employee values('" + emp.getMemberID() + "'," + "'" + emp.getFirstName() + "'," + "'" + emp.getLastName() + "'," + "'" + emp.getAdress() + "'," + "'" + emp.getCPRnumber() + "'," + "'" + emp.getEmail() + "'," + "'" + emp.getPhoneNr() + "'," + "'" + emp.getDefoultTaxCard() + "'," + "'" + emp.getDOB() + ");"; 
		//System.out.println(sql);
		// Payment
		Payment payment = new Payment(1, 2000, 20, 1800, 200);
		Project project = new Project(1, false, false, 1, date, 10000, 2, "LEVENTE EX DEE", "B", "DUCHAS", date, date);
		
		Database database = null;
		try {
			database = new Database();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		database.saveEmployee(emp);
		database.savePayment(payment);
		database.saveProject(project);
		
		
		
		
	}
}