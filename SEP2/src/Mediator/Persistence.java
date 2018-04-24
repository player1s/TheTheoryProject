package Mediator;

import Model.Employee;
import Model.EmployeeList;
import Model.Payment;
import Model.PaymentList;

public interface Persistence {
public void saveEmployee(Employee emp);
public void savePayment(Payment paym);
public void saveEmployeeList(EmployeeList eList);
public void savePaymentList(PaymentList pList);


}
