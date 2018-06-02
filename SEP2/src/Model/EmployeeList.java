package Model;

import java.util.ArrayList;

import Mediator.ModelManager;

public class EmployeeList {
	private ArrayList<Employee> list;
	private ModelManager modelManager = new ModelManager();

	public EmployeeList() {
		this.list = new ArrayList<Employee>();
		

	}

	public void setEmployeeList(ArrayList<Employee> list) {
		this.list = list;
	}

	public void addEmployee(Employee emp) throws Exception {
		int ID = 1;
		loop: while (true) {

			int counter = 0;
			for (int i = 0; i < list.size(); i++) {
				if (ID == (int) list.get(i).getEmployeeID()) {
					counter++;
					ID++;
					System.out.println("id incremented");
				}
			}
			
			System.out.println("thats all");

			if (counter == 0) {

				emp.setEmployeeID(ID);

				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getCPRnumber().equals(emp.getCPRnumber())) {
						throw new Exception("Employee is already in");
					}
				}
				if (emp.getEmployeeID() == null || emp.getFirstName().equals("") || emp.getLastName().equals("")
						|| emp.getCPRnumber().equals("") || emp.getEmail().equals("")) {
					throw new Exception("Give at least firstname, lastname, cpr, email of the Employee ");
				} else

					list.add(emp);

				break loop;
			}

		}

	}

	public int getNumberOfEmployees() {
		return list.size();
	}

	public Employee getEmployee(int index) {
		return list.get(index);
	}

	public int size() {
		return list.size();
	}

	public Employee getEmployeeByID(int ID) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getEmployeeID() == ID) {
				return list.get(i);
			}
		}
		return null;
	}

}

