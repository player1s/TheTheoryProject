package Mediator;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import com.mysql.jdbc.Connection;

import Model.Date;
import Model.Employee;
import Model.EmployeeList;
import Model.Payment;
import Model.PaymentList;
import Model.Project;
import Model.ProjectList;
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

	@Override
	public void saveEmployeeListToDatabase(EmployeeList emplist) throws Exception {

		for (int i = 0; i < emplist.size(); i++) {

			Employee emp = emplist.getByID(i);

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

	}

	@Override
	public void savePaymentListToDatabase(PaymentList paymlist) throws Exception {
		for (int i = 0; i < paymlist.size(); i++) {

			Payment paym = paymlist.getByID(i);

			String sql = "insert into" + " risetheorydb.payment" + " values('" + paym.getPaymentID() + "'," + "'"
					+ paym.getGrossSalary() + "'," + "'" + paym.getHoursWorked() + "'," + "'" + paym.getNetSalary() + "',"
					+ "'" + paym.getHolidayPay() + "'," + "'" + paym.getCompanyGain() + "'," + "'" + paym.getEmployeeID()
					+ "'," + "'" + paym.getProjectID() + "'" + ");";
			try {
				db.update(sql);
				System.out.println("added: " + paym.toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}


	@Override
	public void saveProjectListToDatabase(ProjectList projlist) throws Exception {
		for (int i = 0; i < projlist.size(); i++) {

			Project proj = projlist.getByID(i);

			String sql = "insert into" + " risetheorydb.project" + " values('" + proj.getIsCompleted() + "'," + "'"
					+ proj.getIsSomeoneWorkingOn() + "'," + "'" + proj.getCaseType() + "'," + "'" + proj.getDeadLine()
					+ "'," + "'" + proj.getPaymentOfProject() + "'," + "'" + proj.getNameOfContractor() + "'," + "'"
					+ proj.getWinningProposal() + "'," + "'" + proj.getStartDate() + "'," + "'" + proj.getEndDate() + "',"
					+ "'" + proj.getName() + "'," + "'" + proj.getWebsite() + "'," + "'" + proj.getEmployeeID() + "'," + "'"
					+ proj.getProjectID() + "');";
			try {
				db.update(sql);
				System.out.println("added: " + proj);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	

	@Override
	public void saveMilestoneListToDatabase(MilestoneList millist) throws Exception {
		for (int i = 0; i < millist.size(); i++) {

			Milestone mil = millist.getByID(i);

			String sql = "insert into" + " risetheorydb.milestone" + " values('" + mil.getDescription() + "'," + "'"
					+ mil.getPrice() + "'," + "'" + mil.getDeadline() + "'," + "'" + mil.getMilestoneID() + "'," + "'"
					+ mil.getEmployeeID() + "'," + "'" + mil.getProjectID() + "');";
			try {
				db.update(sql);
				System.out.println("added: " + mil);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public EmployeeList getAllEmployeesFromDatabase() {
		ArrayList<Employee> all = new ArrayList<Employee>();
		java.sql.Connection con = null;
		con = getConnection();
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
		EmployeeList emplist = new EmployeeList(all);
		return emplist;
	}

	@Override
	public PaymentList getAllPaymentsFromDatabase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectList getAllProjectsFromDatabase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MilestoneList getAllMilestonesFromDatabase() {
		// TODO Auto-generated method stub
		return null;
	}

	

}