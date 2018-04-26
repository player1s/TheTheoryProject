package Mediator;

import java.sql.SQLException;
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

	
	
	@Override
	public synchronized void saveEmployee(Employee emp) {
		String sql = "insert into" + " risetheorydb.employee" + " values('" + emp.getEmployeeID() + "'," + "'" + emp.getFirstName() + "'," + "'" + emp.getLastName() + "'," + "'" + emp.getAdress() + "'," + "'" + emp.getCPRnumber() + "'," + "'" + emp.getEmail() + "'," + "'" + emp.getPhoneNr() + "'," + "'" + emp.getDefoultTaxCard() + "'," + "'" + emp.getDOB() + "');"; 
		try {
			System.out.println(sql);
			db.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public synchronized void savePayment(Payment paym) {
		String sql = "insert into" + " risetheorydb.payment" + " values('" + paym.getPaymentID() + "'," + "'" + paym.getGrossSalary() + "'," + "'" + paym.getHoursWorked() + "'," + "'" + paym.getNetSalary() + "'," + "'" + paym.getHolidayPay() + "');"; 
		try {
			System.out.println(sql);
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
			System.out.println(sql);
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
	
	

 
}