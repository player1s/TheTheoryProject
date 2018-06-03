package Mediator;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Date;
import Model.Employee;
import Model.Milestone;
import Model.Payment;
import Model.Project;
import utility.persistence.MyDatabase;

public class ModelManager implements SysModel {
	private ArrayList<Employee> empList;
	private ArrayList<Payment> paymList;
	private ArrayList<Project> projList;
	private ArrayList<Milestone> milList;

	public ModelManager() {
		empList = new ArrayList<Employee>();
		paymList = new ArrayList<Payment>();
		projList = new ArrayList<Project>();
		milList = new ArrayList<Milestone>();
	}
	
	private MyDatabase db;
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
	private static final String USER = "postgres";
	private static final String PASSWORD = "lukaso";

	
		
	
	
	public java.sql.Connection getConnection() throws ClassNotFoundException {
		db = new MyDatabase(DRIVER, URL, USER, PASSWORD);
		java.sql.Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	

	// ------------------------------------------------------------------------------------
	// GET ALL
	@Override
	public ArrayList<Employee> getAllEmployees() {
		ArrayList<Employee> all = new ArrayList<Employee>();
		java.sql.Connection con = null;
		try {
			con = getConnection();

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT EmployeeID, FirstName, LastName, Address, CPRnumber, Email, PhoneNumber, DefaultTaxCard, DOB  FROM risetheorydb.employee");

			while (rs.next()) {

				Employee emp = new Employee(rs.getInt("EmployeeID"), rs.getString("FirstName"),
						rs.getString("LastName"), rs.getString("Address"), rs.getString("CPRnumber"),
						rs.getString("Email"), rs.getString("PhoneNumber"), rs.getString("DefaultTaxCard"),
						rs.getDate("DOB"));
				all.add(emp);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return all;
	}
	// ------------------------------------------------------------------------------------
	@Override
	public ArrayList<Project> getAllProjects() {
		ArrayList<Project> all = new ArrayList<Project>();
		java.sql.Connection con = null;
		try {
			con = getConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT ProjectID, name, IsCompleted, IsSomeoneWorkingOn, caseType, deadline, paymentOfProject, nameOfContractor, website, winningProposal, startDate, endDate, EmployeeID FROM risetheorydb.project");

			while (rs.next()) {

				ArrayList<Employee> employees = new ArrayList<Employee>();
				employees = getAllEmployees();

				for (int i = 0; i < employees.size(); i++) {
					if (employees.get(i).getEmployeeID() == rs.getInt("EmployeeID")) {

						Project proj = new Project(rs.getBoolean("IsCompleted"),
								rs.getBoolean("IsSomeoneWorkingOn"), rs.getInt("caseType"), rs.getDate("deadline"),
								rs.getInt("paymentOfProject"), rs.getString("nameOfContractor"),
								rs.getString("winningProposal"), rs.getDate("startDate"), rs.getDate("endDate"),
								rs.getString("name"), rs.getString("website"), rs.getInt("employeeID"), rs.getInt("ProjectID"));
						all.add(proj);
						System.out.println("returned these: "+proj.getProjectID());
					}

				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return all;

	}
	// ------------------------------------------------------------------------------------
	@Override
	public ArrayList<Payment> getAllPayments() {
		ArrayList<Payment> all = new ArrayList<Payment>();
		java.sql.Connection con = null;
		try {
			con = getConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT * FROM risetheorydb.payment");

			while (rs.next()) {
				Payment paym = new Payment(rs.getInt("MilestoneID"), rs.getInt("PaymentID"), rs.getInt("GrossSalary"), rs.getInt("HoursWorked"),
						rs.getInt("NetSalary"), rs.getInt("HolidayPay"), rs.getInt("CompanyGain"),
						 rs.getInt("employeeid"), rs.getInt("projectid"));
				all.add(paym);
				System.out.println("returned: "+paym.getPaymentID());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return all;
	}
	// ------------------------------------------------------------------------------------
	@Override
	public ArrayList<Milestone> getAllMilestones() {
		ArrayList<Milestone> all = new ArrayList<Milestone>();
		java.sql.Connection con = null;
		try {
			con = getConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT Description , Price , MilestoneDeadline, MilestoneID, employeeID, projectID FROM risetheorydb.milestone");

			while (rs.next()) {

				Milestone mil = new Milestone(rs.getString("Description"), rs.getInt("Price"),
						rs.getDate("MilestoneDeadline"), rs.getInt("MilestoneID"),
						rs.getInt("employeeid"),  rs.getInt("projectid"));
				all.add(mil);
				System.out.println("returned: "+mil.getMilestoneID());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return all;
	}

	// getStuffByID------------------------------------------------------------------------------------------
	@Override
	public Employee getEmployeeById(int id) {

		Employee emp = null;

		java.sql.Connection con = null;
		try {
			con = getConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String sql = "SELECT EmployeeID, FirstName, LastName, Address, CPRnumber, Email, PhoneNumber, DefaultTaxCard, DOB  FROM risetheorydb.employee";
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				if (id == rs.getInt("EmployeeID")) {
					emp = new Employee(rs.getInt("EmployeeID"), rs.getString("FirstName"), rs.getString("LastName"),
							rs.getString("Address"), rs.getString("CPRnumber"), rs.getString("Email"),
							rs.getString("PhoneNumber"), rs.getString("DefaultTaxCard"), rs.getDate("DOB"));
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}
	// ------------------------------------------------------------------------------------
	@Override
	public Project getProjectById(int id) {

		Project proj = null;

		java.sql.Connection con = null;
		try {
			con = getConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String sql = "SELECT IsCompleted, IsSomeoneWorkingOn, caseType, deadline, paymentOfProject, nameOfContractor, winningProposal, startDate, endDate, name, website, EmployeeID, ProjectID FROM risetheorydb.project WHERE ProjectID ="
				+ id;
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
			if (id == rs.getInt("ProjectID")) {
			proj = new Project(rs.getBoolean("IsCompleted"),
					rs.getBoolean("IsSomeoneWorkingOn"), rs.getInt("caseType"), rs.getDate("deadline"),
					rs.getInt("paymentOfProject"), rs.getString("nameOfContractor"), rs.getString("winningProposal"),
					rs.getDate("startDate"), rs.getDate("endDate"), rs.getString("name"), rs.getString("website"),
					rs.getInt("EmployeeID"), rs.getInt("ProjectID"));
			}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return proj;
	}
	// ------------------------------------------------------------------------------------
	@Override
	public Payment getPaymentById(int id) {

		Payment paym = null;

		java.sql.Connection con = null;
		try {
			con = getConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String sql = "SELECT *  FROM risetheorydb.payment WHERE PaymentID ="
				+ id;
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
			if (id == rs.getInt("PaymentID")) {
			paym = new Payment(rs.getInt("MilestoneID"), rs.getInt("PaymentID"), rs.getInt("GrossSalary"), rs.getInt("HoursWorked"),
					rs.getInt("NetSalary"), rs.getInt("HolidayPay"), rs.getInt("CompanyGain"),
					rs.getInt("EmployeeID"), rs.getInt("ProjectID"));
			}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("returned "+ paym.getPaymentID());
		return paym;
	}
	// ------------------------------------------------------------------------------------
	@Override
	public Milestone getMilestoneById(int id) {
		java.sql.Connection con = null;
		try {
			con = getConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Milestone mil = null;
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT  Description , Price , MilestoneDeadline, MilestoneID, employeeid, projectid FROM risetheorydb.milestone");

			while (rs.next()) {
				if (id == rs.getInt("MilestoneID")) {
				 mil = new Milestone(rs.getString("Description"), rs.getInt("Price"),
						rs.getDate("MilestoneDeadline"), rs.getInt("MilestoneID"),
						 rs.getInt("employeeid"), rs.getInt("projectid"));
				
			}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("got: "+mil.getMilestoneID());
		return mil;
	}

	// RemoveStuffAfByID------------------------------------------------------------------------------------------
	@Override
	public void removeEmployeeById(int id) {

		Employee emp = null;

		java.sql.Connection con = null;
		try {
			con = getConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String sql = "SELECT EmployeeID, FirstName, LastName, Address, CPRnumber, Email, PhoneNumber, DefaultTaxCard, DOB  FROM risetheorydb.employee";
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				if (id == rs.getInt("EmployeeID")) {
					emp = new Employee(rs.getInt("EmployeeID"), rs.getString("FirstName"), rs.getString("LastName"),
							rs.getString("Address"), rs.getString("CPRnumber"), rs.getString("Email"),
							rs.getString("PhoneNumber"), rs.getString("DefaultTaxCard"), rs.getDate("DOB"));

					String sql2 = "Delete FROM risetheorydb.employee WHERE EmployeeID= " + id;
					rs = stmt.executeQuery(sql2);

				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Removed: " + emp);
	}
	// ------------------------------------------------------------------------------------
	@Override
	public void removeProjectById(int id) {

		Project proj = null;

		java.sql.Connection con = null;
		try {
			con = getConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String sql = "SELECT ProjectID, name, IsCompleted, IsSomeoneWorkingOn, caseType, deadline, paymentOfProject, nameOfContractor, website, winningProposal, startDate, endDate, EmployeeID FROM risetheorydb.project";
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				if (id == rs.getInt("ProjectID")) {
					proj = new Project(rs.getBoolean("IsCompleted"),
							rs.getBoolean("IsSomeoneWorkingOn"), rs.getInt("caseType"), rs.getDate("deadline"),
							rs.getInt("paymentOfProject"), rs.getString("nameOfContractor"),
							rs.getString("winningProposal"), rs.getDate("startDate"), rs.getDate("endDate"),
							rs.getString("name"), rs.getString("website"), rs.getInt("EmployeeID"), rs.getInt("ProjectID"));

					String sql2 = "Delete FROM risetheorydb.project WHERE ProjectID= '" + id + "'";
					rs = stmt.executeQuery(sql2);

				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Removed: " + proj);
	}
	// ------------------------------------------------------------------------------------
	@Override
	public void removePaymentById(int id) {

		Payment paym = null;

		java.sql.Connection con = null;
		try {
			con = getConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String sql = "SELECT * FROM risetheorydb.payment";
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				if (id == rs.getInt("PaymentID")) {
					paym = new Payment(rs.getInt("MilestoneID"), rs.getInt("PaymentID"), rs.getInt("GrossSalary"), rs.getInt("HoursWorked"),
							rs.getInt("NetSalary"), rs.getInt("HolidayPay"), rs.getInt("CompanyGain"),
							rs.getInt("EmployeeID"), rs.getInt("ProjectID"));

					String sql2 = "Delete FROM risetheorydb.payment WHERE PaymentID= " + id;
					rs = stmt.executeQuery(sql2);

				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Removed: " + paym);
	}
	// ------------------------------------------------------------------------------------
	@Override
	public void removeMilestoneById(int id) {
		java.sql.Connection con = null;
		try {
			con = getConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Milestone mil = null;
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT MilestoneID, Description , Price , MilestoneDeadline, employeeid, projectid FROM risetheorydb.milestone");

			while (rs.next()) {
				if (id == rs.getInt("MilestoneID")) {
				 mil = new Milestone(rs.getString("Description"), rs.getInt("Price"),
						rs.getDate("MilestoneDeadline"), rs.getInt("MilestoneID"),
						 rs.getInt("employeeid"), rs.getInt("projectid"));
				 
				 String sql2 = "Delete FROM risetheorydb.milestone WHERE milestoneID= " + id;
					rs = stmt.executeQuery(sql2);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Removed: " + mil);

	}

}
