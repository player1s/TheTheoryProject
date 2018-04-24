package Mediator;

import java.sql.SQLException;
import Model.Employee;
import Model.EmployeeList;
import utility.persistence.MyDatabase;

public class Database implements Persistence{

	
	private MyDatabase db;
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
	private static final String USER = "postgres";
	private static final String PASSWORD = "Zujevas10";

	public Database() throws ClassNotFoundException {
		this.db = new MyDatabase(DRIVER, URL, USER, PASSWORD);
	}

	
	
	@Override
	public synchronized void saveEmployee(Employee emp) {
		String sql = "insert into" + " employeedb.employee" + " values('" + emp.getMemberID() + "'," + "'" + emp.getFirstName() + "'," + "'" + emp.getLastName() + "'," + "'" + emp.getAdress() + "'," + "'" + emp.getCPRnumber() + "'," + "'" + emp.getEmail() + "'," + "'" + emp.getPhoneNr() + "'," + "'" + emp.getDefoultTaxCard() + "'," + "'" + emp.getDOB() + "');"; 
		try {
			System.out.println(sql);
			db.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public synchronized void saveEmployeeList(EmployeeList eList)
	{
		for(int i = 0; i < eList.getNumberOfEmployees(); i++)
		{
			saveEmployee(eList.getEmployee(i));
		}
	}
	
 
}