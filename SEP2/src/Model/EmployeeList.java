package Model;

import java.util.ArrayList;

public class EmployeeList {

	private ArrayList<Employee> list = new ArrayList<Employee>();

	public EmployeeList(ArrayList<Employee> list) {
		this.list = list;
	}

	public void add(Employee emp) {
		list.add(emp);
	}

	public void remove(int id) {
		list.remove(id);
	}

	public Employee getByID(int id) {
		return list.get(id);
	}
	
	public int size()
	{
		return list.size();
	}

}
