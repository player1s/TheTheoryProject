package Model;
import java.util.ArrayList;

public class EmployeeList {
	private ArrayList<Employee> list;
	private Employee employee;
	
	public EmployeeList()
	{
		this.list = new ArrayList<>();
	}
	
	public void addEmployee(Employee emp)
	{
		list.add(emp);
	}
	
	public int getNumberOfEmployees()
	{
		return list.size();
	}
	
	public Employee getEmployee(int index)
	{
		return list.get(index);
	}
	
	public String toString() {
		String all="";
		for (int i = 0; i < list.size(); i++) {
			all+= employee.toString() + "/n";
		}
		return all;
	}
}
