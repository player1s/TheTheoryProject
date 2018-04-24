package Mediator;

import Model.Employee;
import Model.EmployeeList;

public interface Persistence {
public void saveEmployee(Employee emp);
public void saveEmployeeList(EmployeeList eList);
}
