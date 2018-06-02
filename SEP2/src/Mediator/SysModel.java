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

public void removeEmployeeById(int id);
public void removeProjectById(int id);
public void removePaymentById(int id);
public void removeMilestoneById(int id);
//test
}
