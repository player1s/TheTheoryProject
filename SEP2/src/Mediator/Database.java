package Mediator;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import com.mysql.jdbc.Connection;

import Model.Date;
import Model.Employee;
import Model.Payment;
import Model.Project;
import Model.Milestone;
import utility.persistence.MyDatabase;

public class Database implements Persistence {

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

	// save methods

	public synchronized void saveEmployee(Employee emp) throws Exception {

		int counter;
		int id = 1;
		ArrayList<Integer> allempid = new ArrayList<Integer>();
		java.sql.Connection con = null;
		con = getConnection();
		// getting data to check if id is unique start
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT EmployeeID FROM risetheorydb.employee");

			while (rs.next()) {

				Integer tempemp = rs.getInt("EmployeeID");
				allempid.add(tempemp);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// getting data to check if id is unique end
		// check if id is unique start
		while (true) {
			emp.setEmployeeID(id);
			counter = 0;
			for (int i = 0; i < allempid.size(); i++) {
				if (allempid.get(i) == emp.getEmployeeID()) {
					counter++;
				}
			}

			if (counter == 0)
				break;

			id++;

		}
		// check if id is unique end
		// check for key data start
		if (emp.getEmployeeID() == null || emp.getFirstName().equals("") || emp.getLastName().equals("")
				|| emp.getCPRnumber().equals("") || emp.getEmail().equals("")) {
			throw new Exception("Give at least firstname, lastname, cpr, email of the Employee ");
		}

		// check for key data end
		// insert data start
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
		// insert data end
	}

	@Override
	public synchronized void savePayment(Payment paym) throws Exception {

		int counter;
		int id = 1;
		ArrayList<Integer> allpaymid = new ArrayList<Integer>();
		java.sql.Connection con = null;
		con = getConnection();
		// getting data to check if id is unique start
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT PaymentID FROM risetheorydb.payment");

			while (rs.next()) {

				Integer temppaym = rs.getInt("PaymentID");
				allpaymid.add(temppaym);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// getting data to check if id is unique end
		// check if id is unique start
		while (true) {
			paym.setPaymentID(id);
			counter = 0;
			for (int i = 0; i < allpaymid.size(); i++) {
				if (allpaymid.get(i) == paym.getPaymentID()) {
					counter++;
				}
			}

			if (counter == 0)
				break;

			id++;

		}
		// check if id is unique end
		// check for key data start
		if (paym.getGrossSalary() == null) {
			throw new Exception("Give at least grossalary of the payment");
		}

		// check for key data end

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

	@Override
	public synchronized void saveProject(Project proj) throws Exception {

		int counter;
		int id = 1;
		ArrayList<Integer> allprojid = new ArrayList<Integer>();
		java.sql.Connection con = null;
		con = getConnection();
		// getting data to check if id is unique start
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT ProjectID FROM risetheorydb.project");

			while (rs.next()) {

				Integer tempproj = rs.getInt("ProjectID");
				allprojid.add(tempproj);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// getting data to check if id is unique end
		// check if id is unique start
		while (true) {
			proj.setProjectID(id);
			counter = 0;
			for (int i = 0; i < allprojid.size(); i++) {
				if (allprojid.get(i) == proj.getProjectID()) {
					counter++;
				}
			}

			if (counter == 0)
				break;

			id++;

		}
		// check if id is unique end
		// check for key data start
		if (proj.getName().equals("") || proj.getDeadLine().equals("") || proj.getNameOfContractor().equals("")
				|| proj.getWinningProposal().equals("")) {
			throw new Exception("Give at least name, deadline, name of contractor, winning proposal of the Employee ");
		}

		// check for key data end

		String sql = "insert into" + " risetheorydb.project" + " values('" + proj.getIsCompleted() + "'," + "'"
				+ proj.getIsSomeoneWorkingOn() + "'," + "'" + proj.getCaseType() + "'," + "'" + proj.getDeadLine()
				+ "'," + "'" + proj.getPaymentOfProject() + "'," + "'" + proj.getNameOfContractor() + "'," + "'"
				+ proj.getWinningProposal() + "'," + "'" + proj.getStartDate() + "'," + "'" + proj.getEndDate() + "',"
				+ "'" + proj.getName() + "'," + "'" + proj.getWebsite() + "'," + "'" + proj.getEmployeeID() + "'," + "'" +  proj.getProjectID() + "');";
		try {
			db.update(sql);
			System.out.println("added: " + proj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void saveMilestone(Milestone mil) throws Exception {

		int counter;
		int id = 1;
		ArrayList<Integer> allmilid = new ArrayList<Integer>();
		java.sql.Connection con = null;
		con = getConnection();
		// getting data to check if id is unique start
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT MilestoneID FROM risetheorydb.milestone");

			while (rs.next()) {

				Integer tempmil = rs.getInt("MilestoneID");
				allmilid.add(tempmil);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// getting data to check if id is unique end
		// check if id is unique start
		while (true) {
			mil.setMilestoneID(id);
			counter = 0;
			for (int i = 0; i < allmilid.size(); i++) {
				if (allmilid.get(i) == mil.getMilestoneID()) {
					counter++;
				}
			}

			if (counter == 0)
				break;

			id++;

		}
		// check if id is unique end
		// check for key data start
		if (mil.getEmployeeID() == null || mil.getProjectID() == null || mil.getPrice() == null
				|| mil.getDescription().equals("") || mil.getDeadline().equals("")) {
			throw new Exception("Give at least employeeid, projectid, price, description, daedline of the milestone ");
		}

		// check for key data end

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