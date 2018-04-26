package Mediator;

import java.util.ArrayList;

import Model.Employee;
import Model.EmployeeList;
import Model.Payment;
import Model.PaymentList;
import Model.Project;
import Model.ProjectList;

public interface Persistence {
public void saveEmployee(Employee emp);
public void savePayment(Payment paym);
public void saveProject(Project proj);
public void saveEmployeeList(EmployeeList empList);
public void savePaymentList(PaymentList paymList);
public void saveProjectList(ProjectList projList);

public  ArrayList load();



}
