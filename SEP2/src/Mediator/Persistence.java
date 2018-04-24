package Mediator;

import Model.Employee;
import Model.Payment;

public interface Persistence {
public void saveEmployee(Employee emp);
public void savePayment(Payment paym);
}
