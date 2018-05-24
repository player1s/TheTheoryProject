package Mediator;

import Model.Employee;
import Model.EmployeeList;
import Model.Milestone;
import Model.MilestoneList;
import Model.Payment;
import Model.PaymentList;
import Model.Project;
import Model.ProjectList;

public class ModelManager implements SysModel{
	private EmployeeList empList;
	private PaymentList paymList;
	private ProjectList projList;
	private MilestoneList milList;
	
	public ModelManager()
	{
		empList = new EmployeeList();
		paymList = new PaymentList();
		projList = new ProjectList();
		milList = new MilestoneList();
	}

	@Override
	public void addEmployee(Employee emp) {
		try {
			empList.addEmployee(emp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void addProject(Project proj) {
		try {
			projList.addProjet(proj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addPayment(Payment paym) {
		try {
			paymList.addPayment(paym);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void addMilestone(Milestone mil) {
		milList.addMilestone(mil);
	}
}
