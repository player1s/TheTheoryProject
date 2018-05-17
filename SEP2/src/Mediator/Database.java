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
import Model.Milestone;
import Model.MilestoneList;
import utility.persistence.MyDatabase;

public class Database implements Persistence{

	
	private MyDatabase db;
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
	private static final String USER = "postgres";
	private static final String PASSWORD = "lukaso";

	public Database() throws ClassNotFoundException {
		this.db = new MyDatabase(DRIVER, URL, USER, PASSWORD);
	}

	public java.sql.Connection getConnection() {
		java.sql.Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
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
		String sql = "insert into" + " risetheorydb.project" + " values('" + proj.getProjectID() + "'," + "'" + proj.getIsCompleted() + "'," + "'" + proj.getIsSomeoneWorkingOn() + "'," + "'" + proj.getCaseType() + "'," + "'" + proj.getDeadLine() + "'," + "'" + proj.getPaymentOfProject() + "'," + "'" + proj.getNameOfContractor() + "'," + "'" + proj.getSite() + "'," + "'" + proj.getWinningProposal() + "'," + "'" + proj.getStartDate() + "'," + "'" + proj.getEndDate()+ "');"; 
		try {
			db.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void saveMilestone(Milestone mil) {
		String sql = "insert into" + " risetheorydb.milestone" + " values('" + mil.getMilestoneID()+ "'," + "'" + mil.getDescription()+ "'," + "'" + mil.getPrice()+ "'," + "'" + mil.getDeadline() + "');"; 
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
	
	@Override
	public synchronized void saveMilestoneList(MilestoneList milList)
	{
		for(int i = 0; i < milList.getNumberOfMilestones(); i++)
		{
			saveMilestone(milList.getMilestone(i));
		}
	}
	
	public ArrayList getAllEmployees()
	{
		ArrayList all = new ArrayList<Employee>();
		java.sql.Connection con = getConnection();
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT EmployeeID, FirstName, LastName, Address, CPRnumber, Email, PhoneNumber, DefaultTaxCard, DOB  FROM risetheorydb.employee");
		
		while(rs.next())
		{
			Date date = new Date(12,1,1995);// DEAL WITH THIS ONE
			Employee emp = new Employee(rs.getString("EmployeeID"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Address"), rs.getString("CPRnumber"), rs.getString("Email"), rs.getString("PhoneNumber"), rs.getString("DefaultTaxCard"), date);
			all.add(emp);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return all;
	}
	
	public ArrayList getAllProjects() {
		ArrayList all = new ArrayList<Project>();
		java.sql.Connection con = getConnection();
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT ProjectID, IsCompleted, IsSomeoneWorkingOn, caseType, deadline, paymentOfProject, nameOfContractor, site, winningProposal, startDate, endDate FROM risetheorydb.project");
			
			while(rs.next()) {
				Date date1 = new Date(1,1,2000); // deadline
				Date date2 = new Date(2,1,2000); // startDate
				Date date3 = new Date(3,1,2000); // endDate
				Project proj = new Project(rs.getInt("ProjectID"), rs.getBoolean("IsCompleted"), rs.getBoolean("IsSomeoneWorkingOn"), rs.getInt("caseType"), date1, rs.getInt("paymentOfProject"), rs.getString("nameOfContractor"), rs.getString("site"),rs.getString("winningProposal"), date2, date3);
				all.add(proj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return all;

		
	}
	
	public ArrayList getAllPayments()
	{
		ArrayList all = new ArrayList<Payment>();
		java.sql.Connection con = getConnection();
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT PaymentID, GrossSalary, HoursWorked, NetSalary, HolidayPay, CompanyGain  FROM risetheorydb.payment");
		
		while(rs.next())
		{
			Payment paym = new Payment(rs.getString("PaymentID"), rs.getInt("GrossSalary"), rs.getInt("HoursWorked"), rs.getInt("NetSalary"), rs.getInt("HolidayPay"), rs.getInt("CompanyGain"));
			all.add(paym);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return all;
	}
	
	public ArrayList getAllMilestones()
	{
		ArrayList all = new ArrayList<Milestone>();
		java.sql.Connection con = getConnection();
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT MilestoneID, Description , Price , MilestoneDeadline FROM risetheorydb.milestone");
		
		while(rs.next())
		{
			Date date = new Date(12,1,1995);// DEAL WITH THIS ONE
			Milestone mil = new Milestone(rs.getString("MilestoneID"), rs.getString("Description"), rs.getInt("Price"), date);
			all.add(mil);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return all;
	}



	

 
}