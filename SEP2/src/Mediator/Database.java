package Mediator;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import Model.Date;
import Model.Employee;
import Model.Payment;
import Model.PaymentList;
import Model.Project;
import Model.ProjectList;
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

	
	

	public synchronized void saveEmployee(Employee emp) {
		String sql = "insert into" + " risetheorydb.employee" + " values('" + emp.getEmployeeID() + "'," + "'" + emp.getFirstName() + "'," + "'" + emp.getLastName() + "'," + "'" + emp.getAdress() + "'," + "'" + emp.getCPRnumber() + "'," + "'" + emp.getEmail() + "'," + "'" + emp.getPhoneNr() + "'," + "'" + emp.getDefoultTaxCard() + "'," + "'" + emp.getDOB() + "');"; 
		try {
			db.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public synchronized void savePayment(Payment paym) {
		String sql = "insert into" + " risetheorydb.payment" + " values('" + paym.getPaymentID() + "'," + "'" + paym.getGrossSalary() + "'," + "'" + paym.getHoursWorked() + "'," + "'" + paym.getNetSalary() + "'," + "'" + paym.getHolidayPay() + "'," + "'" + paym.getCompanyGain() + "');"; 
		try {
			db.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public synchronized void saveProject(Project proj) {
		String sql = "insert into" + " risetheorydb.project" + " values('" + proj.getProjectID() + "'," + "'" + proj.getIsCompleted() + "'," + "'" + proj.getIsSomeoneWorkingOn() + "'," + "'" + proj.getCaseType() + "'," + "'" + proj.getDeadLine() + "'," + "'" + proj.getPaymentOfProject() + "'," + "'" + proj.getMilestone() + "'," + "'" + proj.getNameOfContractor() + "'," + "'" + proj.getSite() + "'," + "'" + proj.getWinningProposal() + "'," + "'" + proj.getStartDate() + "'," + "'" + proj.getEndDate()+ "');"; 
		try {
			db.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public synchronized void saveEmployeeList(EmployeeList empList)
	{
		for(int i = 0; i < empList.getNumberOfEmployees(); i++)
		{
			saveEmployee(empList.getEmployee(i));
		}
	}
	
	@Override
	public synchronized void savePaymentList(PaymentList paymList)
	{
		for(int i = 0; i < paymList.getNumberOfPayments(); i++)
		{
			savePayment(paymList.getPayment(i));
		}
	}
	
	@Override
	public synchronized void saveProjectList(ProjectList projList)
	{
		for(int i = 0; i < projList.getNumberOfProject(); i++)
		{
			saveProject(projList.getProject(i));
		}
	}
	
	public ArrayList getAllEmployees()
	{
		ArrayList all = new ArrayList<Employee>();
		Connection con = null;
		try {
			con = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
			java.sql.Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT EmployeeID, FirstName, LastName, Adress, CPRnumber, Email, PhoneNumber, DefaultTaxCard, DOB  FROM risetheorydb.employee");
		
		while(rs.next())
		{
			Employee emp = new Employee(rs.getString("EmployeeID"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Adress"), rs.getString("CPRnumber"), rs.getString("Email"), rs.getString("PhoneNumber"), rs.getString("DefaultTaxCard"), (Date) rs.getObject("DOB"));
			all.add(emp);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return all;
	}



	

 
}