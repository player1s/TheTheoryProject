package Mediator;

import java.sql.Connection;
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
public void saveEmployeeListToDatabase(EmployeeList emplist) throws Exception;
public void savePaymentListToDatabase(PaymentList paymlist)throws Exception;
public void saveProjectListToDatabase(ProjectList projlist)throws Exception;
public void saveMilestoneListToDatabase(MilestoneList millist)throws Exception;

public EmployeeList getAllEmployeesFromDatabase();
public PaymentList getAllPaymentsFromDatabase();
public ProjectList getAllProjectsFromDatabase();
public MilestoneList getAllMilestonesFromDatabase();
}
