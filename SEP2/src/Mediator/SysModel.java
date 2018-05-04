package Mediator;

import Model.Employee;
import Model.Milestone;
import Model.Payment;
import Model.Project;

public interface SysModel {
public void addEmployee(Employee emp);
public void addProject(Project proj);
public void addPayment(Payment paym);
public void addMilestone(Milestone mil);
//test
}
