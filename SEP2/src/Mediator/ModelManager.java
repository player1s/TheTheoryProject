package Mediator;

import Model.Employee;
import Model.EmployeeList;

public class ModelManager implements SysModel{
	private EmployeeList elist;
	
	public ModelManager()
	{
		elist = new EmployeeList();
	}

	@Override
	public void addEmployee(Employee emp) {
		elist.addEmployee(emp);
		
	}
}
