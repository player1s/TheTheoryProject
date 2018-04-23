package Model;
import java.util.ArrayList;

public class EmployeeList {
	private ArrayList<Employee> list;
	
	public EmployeeList()
	{
		this.list = new ArrayList<>();
	}
	
	public void addEmployee(Employee emp)
	{
		list.add(emp);
	}
}
