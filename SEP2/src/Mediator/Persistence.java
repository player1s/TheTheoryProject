package Mediator;

import java.util.ArrayList;

import Model.Employee;
import Model.EmployeeList;
import Model.Milestone;
import Model.MilestoneList;
import Model.Payment;
import Model.PaymentList;
import Model.Project;
import Model.ProjectList;

public interface Persistence {
public void saveEmployee(Employee emp);
public void savePayment(Payment paym);
public void saveProject(Project proj);
public void saveMilestone(Milestone mil);
public void saveEmployeeList(EmployeeList empList);
public void savePaymentList(PaymentList paymList);
public void saveProjectList(ProjectList projList);
public void saveMilestoneList(MilestoneList milList);
public ArrayList getAllEmployees();
public ArrayList getAllPayments();
public ArrayList getAllProjects();
public ArrayList getAllMilestones();


}
