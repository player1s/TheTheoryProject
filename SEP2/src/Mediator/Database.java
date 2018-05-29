package Mediator;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import com.mysql.jdbc.Connection;

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

public class Database implements Persistence {

	private MyDatabase db;
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
	private static final String USER = "postgres";
	private static final String PASSWORD = "h";

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

	// save methods

	public synchronized void saveEmployee(Employee emp) {
		String sql = "insert into" + " risetheorydb.employee" + " values('" + emp.getEmployeeID() + "'," + "'"
				+ emp.getFirstName() + "'," + "'" + emp.getLastName() + "'," + "'" + emp.getAdress() + "'," + "'"
				+ emp.getCPRnumber() + "'," + "'" + emp.getEmail() + "'," + "'" + emp.getPhoneNr() + "'," + "'"
				+ emp.getDefoultTaxCard() + "'," + "'" + emp.getDOB() + "');";
		try {
			db.update(sql);
			System.out.println("added: " + emp.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public synchronized void savePayment(Payment paym) {
		String sql = "insert into" + " risetheorydb.payment" + " values('" + paym.getPaymentID() + "'," + "'"
				+ paym.getGrossSalary() + "'," + "'" + paym.getHoursWorked() + "'," + "'" + paym.getNetSalary() + "',"
				+ "'" + paym.getHolidayPay() + "'," + "'" + paym.getCompanyGain() + "',"+ "'" + paym.getEmployeeID() + "',"+ "'" + paym.getProjectID() + "'"+");";
		try {
			db.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public synchronized void saveProject(Project proj) {
		String sql = "insert into" + " risetheorydb.project" + " values('" + proj.getProjectID() + "',"  + "'" + proj.getIsCompleted() + "'," + "'" + proj.getIsSomeoneWorkingOn() + "',"
				+ "'" + proj.getCaseType() + "'," + "'" + proj.getDeadLine() + "'," + "'" + proj.getPaymentOfProject()
				+ "'," + "'" + proj.getNameOfContractor() + "'," + "'"
				+ proj.getWinningProposal() + "'," + "'" + proj.getStartDate() + "'," + "'" + proj.getEndDate() + "'," + "'"
						+ proj.getName() + "'," + "'" + proj.getWebsite() + "'," 
				+ "'" + proj.getEmployeeID() + "');";
		try {
			db.update(sql);
			System.out.println("added: "+ proj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void saveMilestone(Milestone mil) {
		String sql = "insert into" + " risetheorydb.milestone" + " values('" + mil.getMilestoneID() + "'," + "'"
				+ mil.getDescription() + "'," + "'" + mil.getPrice() + "'," + "'" + mil.getDeadline() + "');";
		try {
			db.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// saveLists methods

	@Override
	public synchronized void saveEmployeeList(EmployeeList empList) {
		for (int i = 0; i < empList.getNumberOfEmployees(); i++) {
			saveEmployee(empList.getEmployee(i));
		}
	}

	@Override
	public synchronized void savePaymentList(PaymentList paymList) {
		for (int i = 0; i < paymList.getNumberOfPayments(); i++) {
			savePayment(paymList.getPayment(i));
		}
	}

	@Override
	public synchronized void saveProjectList(ProjectList projList) {
		for (int i = 0; i < projList.getNumberOfProject(); i++) {
			saveProject(projList.getProject(i));
		}
	}

	@Override
	public synchronized void saveMilestoneList(MilestoneList milList) {
		for (int i = 0; i < milList.getNumberOfMilestones(); i++) {
			saveMilestone(milList.getMilestone(i));
		}
	}

	// getall -- everything

	public ArrayList<Employee> getAllEmployees() {
		ArrayList<Employee> all = new ArrayList<Employee>();
		java.sql.Connection con = getConnection();
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

	public ArrayList<Project> getAllProjects() {
		ArrayList<Project> all = new ArrayList<Project>();
		java.sql.Connection con = getConnection();
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT ProjectID, name, IsCompleted, IsSomeoneWorkingOn, caseType, deadline, paymentOfProject, nameOfContractor, website, winningProposal, startDate, endDate, EmployeeID FROM risetheorydb.project");

			while (rs.next()) {

				ArrayList<Employee> employees = new ArrayList<Employee>();
				employees = getAllEmployees();

				for (int i = 0; i < employees.size(); i++) {
					if (employees.get(i).getEmployeeID() == rs.getInt("EmployeeID")) {

						Project proj = new Project(rs.getInt("ProjectID"),
								rs.getBoolean("IsCompleted"), rs.getBoolean("IsSomeoneWorkingOn"),
								rs.getInt("caseType"), rs.getDate("deadline"), rs.getInt("paymentOfProject"),
								rs.getString("nameOfContractor"), 
								rs.getString("winningProposal"), rs.getDate("startDate"), rs.getDate("endDate"), rs.getString("name"), rs.getString("website"),
								rs.getInt("employeeID"));
						all.add(proj);
					}

				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return all;

	}

	public ArrayList<Payment> getAllPayments() {
		ArrayList<Payment> all = new ArrayList<Payment>();
		java.sql.Connection con = getConnection();
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT PaymentID, GrossSalary, HoursWorked, NetSalary, HolidayPay, CompanyGain  FROM risetheorydb.payment");

			while (rs.next()) {
				Payment paym = new Payment(rs.getInt("PaymentID"), rs.getInt("GrossSalary"), rs.getInt("HoursWorked"),
						rs.getInt("NetSalary"), rs.getInt("HolidayPay"), rs.getInt("CompanyGain"),
						rs.getInt("employeeid"), rs.getInt("projectid"));
				all.add(paym);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return all;
	}

	public ArrayList<Milestone> getAllMilestones() {
		ArrayList<Milestone> all = new ArrayList<Milestone>();
		java.sql.Connection con = getConnection();
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT MilestoneID, Description , Price , MilestoneDeadline FROM risetheorydb.milestone");

			while (rs.next()) {
				Date date = new Date(12, 1, 1995);// DEAL WITH THIS ONE
				Milestone mil = new Milestone(rs.getString("MilestoneID"), rs.getString("Description"),
						rs.getInt("Price"), date);
				all.add(mil);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return all;
	}

	// getStuffByID

	public Employee getEmployeeById(int id) {

		Employee emp = null;

		java.sql.Connection con = getConnection();

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

	public Project getProjectById(int id) {

		Project proj = null;

		java.sql.Connection con = getConnection();

		String sql = "SELECT ProjectID, name, IsCompleted, IsSomeoneWorkingOn, caseType, deadline, paymentOfProject, nameOfContractor, website, winningProposal, startDate, endDate, EmployeeID FROM risetheorydb.project WHERE ProjectID ="
				+ id;
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			proj = new Project(rs.getInt("ProjectID"),  rs.getBoolean("IsCompleted"),
					rs.getBoolean("IsSomeoneWorkingOn"), rs.getInt("caseType"), rs.getDate("deadline"),
					rs.getInt("paymentOfProject"), rs.getString("nameOfContractor"), 
					rs.getString("winningProposal"), rs.getDate("startDate"), rs.getDate("endDate"), rs.getString("name"), rs.getString("website"),
					rs.getInt("EmployeeID"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return proj;
	}

	public Payment getPaymentById(int id) {

		Payment paym = null;

		java.sql.Connection con = getConnection();

		String sql = "SELECT PaymentID, GrossSalary, HoursWorked, NetSalary, HolidayPay, CompanyGain, employeeid, projectid  FROM risetheorydb.payment WHERE PaymentID ="
				+ id;
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			paym = new Payment(rs.getInt("PaymentID"), rs.getInt("GrossSalary"), rs.getInt("HoursWorked"),
					rs.getInt("NetSalary"), rs.getInt("HolidayPay"), rs.getInt("CompanyGain"), rs.getInt("employeeid"),
					rs.getInt("projectid"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return paym;
	}

	// getAllToString
	// -----------------------------------------------------------------------------------------------------------------
	public void getAllEmployeesToString() throws Exception {
		String inString = "";
		ArrayList<Employee> all = new ArrayList<Employee>();
		java.sql.Connection con = getConnection();
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

		for (int i = 0; i < all.size(); i++) {
			inString += all.get(i).toString() + "\n";
		}
		
		if (inString == "")
			throw new Exception("There is no employee in the database");

		System.out.println(inString);
	}

	public void getAllProjectsToString() throws Exception {
		String inString = "";
		ArrayList<Project> all = new ArrayList<Project>();
		java.sql.Connection con = getConnection();
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT ProjectID, name, IsCompleted, IsSomeoneWorkingOn, caseType, deadline, paymentOfProject, nameOfContractor, website, winningProposal, startDate, endDate, EmployeeID FROM risetheorydb.project");

			while (rs.next()) {

				ArrayList<Employee> employees = new ArrayList<Employee>();
				employees = getAllEmployees();

				

						Project proj = new Project(rs.getInt("ProjectID"), 
								rs.getBoolean("IsCompleted"), rs.getBoolean("IsSomeoneWorkingOn"),
								rs.getInt("caseType"), rs.getDate("deadline"), rs.getInt("paymentOfProject"),
								rs.getString("nameOfContractor"), 
								rs.getString("winningProposal"), rs.getDate("startDate"), rs.getDate("endDate"), rs.getString("name"), rs.getString("website"),
								rs.getInt("employeeID"));
						all.add(proj);
					

				

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < all.size(); i++) {
			inString += all.get(i).toString() + "\n";
		}
		
		if (inString == "")
			throw new Exception("There is no Project in the database");

		System.out.println(inString);
	}

	public void getAllPaymentsToString() throws Exception {
		String inString = "";
		ArrayList<Payment> all = new ArrayList<Payment>();
		java.sql.Connection con = getConnection();
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT PaymentID, GrossSalary, HoursWorked, NetSalary, HolidayPay, CompanyGain, employeeid, projectid  FROM risetheorydb.payment");

			while (rs.next()) {
				Payment paym = new Payment(rs.getInt("PaymentID"), rs.getInt("GrossSalary"), rs.getInt("HoursWorked"),
						rs.getInt("NetSalary"), rs.getInt("HolidayPay"), rs.getInt("CompanyGain"),
						rs.getInt("employeeid"), rs.getInt("projectid"));
				all.add(paym);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < all.size(); i++) {
			inString += all.get(i).toString() + "\n";
		}
		
		if (inString == "")
			throw new Exception("There is no payment in the database");

		System.out.println(inString);
	}

	public void getAllMilestonesToString() {
		String inString = "";
		ArrayList<Milestone> all = new ArrayList<Milestone>();
		java.sql.Connection con = getConnection();
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT MilestoneID, Description , Price , MilestoneDeadline FROM risetheorydb.milestone");

			while (rs.next()) {
				Date date = new Date(12, 1, 1995);// DEAL WITH THIS ONE
				Milestone mil = new Milestone(rs.getString("MilestoneID"), rs.getString("Description"),
						rs.getInt("Price"), date);
				all.add(mil);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < all.size(); i++) {
			inString += all.get(i).toString() + "\n";
		}

		System.out.println(inString);
	}

	// getByIDToString-----------------------------------------------------------------------------------------------------------------------------------------------------

	public void getEmployeeByIdToString(int id) throws Exception {

		Employee emp = null;

		java.sql.Connection con = getConnection();

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
		if (emp == null)
			throw new Exception("Employee is not in the database");
		
		System.out.println(emp);
	}

	public void getProjectByIdToString(int id) throws Exception {

		Project proj = null;

		java.sql.Connection con = getConnection();

		String sql = "SELECT ProjectID, name, IsCompleted, IsSomeoneWorkingOn, caseType, deadline, paymentOfProject, nameOfContractor, website, winningProposal, startDate, endDate, EmployeeID FROM risetheorydb.project";
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				if (id == rs.getInt("ProjectID")) {
					proj = new Project(rs.getInt("ProjectID"),  rs.getBoolean("IsCompleted"),
							rs.getBoolean("IsSomeoneWorkingOn"), rs.getInt("caseType"), rs.getDate("deadline"),
							rs.getInt("paymentOfProject"), rs.getString("nameOfContractor"), 
							rs.getString("winningProposal"), rs.getDate("startDate"), rs.getDate("endDate"), rs.getString("name"), rs.getString("website"),
							rs.getInt("EmployeeID"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (proj == null)
			throw new Exception("Project is not in the database");
		
		System.out.println(proj);
	}

	public void getPaymentByIdToString(int id) throws Exception {

		Payment paym = null;

		java.sql.Connection con = getConnection();

		String sql = "SELECT PaymentID, GrossSalary, HoursWorked, NetSalary, HolidayPay, CompanyGain, employeeid, projectid  FROM risetheorydb.payment";
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				if (id == rs.getInt("PaymentID")) {
					paym = new Payment(rs.getInt("PaymentID"), rs.getInt("GrossSalary"), rs.getInt("HoursWorked"),
							rs.getInt("NetSalary"), rs.getInt("HolidayPay"), rs.getInt("CompanyGain"),
							rs.getInt("employeeid"), rs.getInt("projectid"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (paym == null)
			throw new Exception("Payment is not in the database");
		
		System.out.println(paym);
	}

	// RemoveStuffAfByID------------------------------------------------------------------------------------------
	public void removeEmployeeById(int id) {

		Employee emp = null;

		java.sql.Connection con = getConnection();

		String sql = "SELECT EmployeeID, FirstName, LastName, Address, CPRnumber, Email, PhoneNumber, DefaultTaxCard, DOB  FROM risetheorydb.employee";
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				if (id == rs.getInt("EmployeeID")) {
					emp = new Employee(rs.getInt("EmployeeID"), rs.getString("FirstName"), rs.getString("LastName"),
							rs.getString("Address"), rs.getString("CPRnumber"), rs.getString("Email"),
							rs.getString("PhoneNumber"), rs.getString("DefaultTaxCard"), rs.getDate("DOB"));
					
					String sql2 = "Delete FROM risetheorydb.employee WHERE EmployeeID= "+ id;
					rs = stmt.executeQuery(sql2);
				
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Removed: "+emp);
	}
	
	public void removeProjectById(int id) {

		Project proj = null;

		java.sql.Connection con = getConnection();

		String sql = "SELECT ProjectID, name, IsCompleted, IsSomeoneWorkingOn, caseType, deadline, paymentOfProject, nameOfContractor, website, winningProposal, startDate, endDate, EmployeeID FROM risetheorydb.project";
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				if (id == rs.getInt("ProjectID")) {
					proj = new Project(rs.getInt("ProjectID"),  rs.getBoolean("IsCompleted"),
							rs.getBoolean("IsSomeoneWorkingOn"), rs.getInt("caseType"), rs.getDate("deadline"),
							rs.getInt("paymentOfProject"), rs.getString("nameOfContractor"), 
							rs.getString("winningProposal"), rs.getDate("startDate"), rs.getDate("endDate"), rs.getString("name"), rs.getString("website"),
							rs.getInt("EmployeeID"));
					
					String sql2 = "Delete FROM risetheorydb.project WHERE ProjectID= '"+ id+"'";
					rs = stmt.executeQuery(sql2);
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Removed: "+proj);
	}

	public void removePaymentById(int id) {

		Payment paym = null;

		java.sql.Connection con = getConnection();

		String sql = "SELECT PaymentID, GrossSalary, HoursWorked, NetSalary, HolidayPay, CompanyGain, employeeid, projectid  FROM risetheorydb.payment";
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				if (id == rs.getInt("PaymentID")) {
					paym = new Payment(rs.getInt("PaymentID"), rs.getInt("GrossSalary"), rs.getInt("HoursWorked"),
							rs.getInt("NetSalary"), rs.getInt("HolidayPay"), rs.getInt("CompanyGain"),
							rs.getInt("employeeid"), rs.getInt("projectid"));
					
					String sql2 = "Delete FROM risetheorydb.payment WHERE PaymentID= "+ id;
					rs = stmt.executeQuery(sql2);
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Removed: "+paym);
	}
	
}