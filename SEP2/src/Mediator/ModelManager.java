package Mediator;

import Model.Employee;
import Model.EmployeeList;
import Model.Payment;
import Model.PaymentList;
import Model.Project;
import Model.ProjectList;

public class ModelManager implements SysModel{
	private EmployeeList empList;
	private PaymentList paymList;
	private ProjectList projList;
	
	public ModelManager()
	{
		empList = new EmployeeList();
		paymList = new PaymentList();
		projList = new ProjectList();
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
}
