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
		empList.addEmployee(emp);
		
	}

	@Override
	public void addProject(Project proj) {
		projList.addProjet(proj);
	}

	@Override
	public void addPayment(Payment paym) {
		paymList.addPayment(paym);
	}
	
	@Override
	public void addMilestone(Milestone mil) {
		milList.addMilestone(mil);
	}
}
