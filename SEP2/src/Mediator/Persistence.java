package Mediator;

import java.sql.Connection;
import java.util.ArrayList;

import Model.Employee;
import Model.Milestone;
import Model.Payment;
import Model.Project;

public interface Persistence {
public void saveEmployee(Employee emp) throws Exception;
public void savePayment(Payment paym)throws Exception;
public void saveProject(Project proj)throws Exception;
public void saveMilestone(Milestone mil)throws Exception;
}
