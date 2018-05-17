package Model;
import java.util.ArrayList;

public class EmployeeList {
	private ArrayList<Employee> list;
	private Employee employee;
	
	public EmployeeList()
	{
		this.list = new ArrayList<>();
	}
	
	public void addEmployee(Employee emp) throws Exception
	{
		 for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getCPRnumber().equals(emp.getCPRnumber())) {
					throw new Exception("Employee is already in");
				}
			}
		if (emp.getEmployeeID().equals("") || emp.getFirstName().equals("") || emp.getLastName().equals("") || emp.getCPRnumber().equals("") || emp.getEmail().equals("")) {
			throw new Exception("Employee can't be added");
		}
		else list.add(emp);
		
		
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
