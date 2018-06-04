package Mediator;

import java.util.ArrayList;

import Model.Employee;
import Model.Milestone;
import Model.Payment;
import Model.Project;

public interface SysModel {

public ArrayList<Employee> getAllEmployees();
public ArrayList<Project> getAllProjects();
public ArrayList<Payment> getAllPayments();
public ArrayList<Milestone> getAllMilestones();

public Employee getEmployeeById(int id);
public Project getProjectById(int id);
public Payment getPaymentById(int id);
public Milestone getMilestoneById(int id);

public void removeEmployee(int id);
public void removeProject(int id);
public void removePayment(int id);
public void removeMilestone(int id);

public void addEmployee(Employee emp);
public void addProject(Project proj);
public void addPayment(Payment paym);
public void addMilestone(Milestone mil);

}
