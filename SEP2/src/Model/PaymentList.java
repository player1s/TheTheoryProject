package Model;

import java.util.ArrayList;

import Model.Payment;

public class PaymentList {
	private ArrayList<Payment> list;
	
	public PaymentList()
	{
		this.list = new ArrayList<>();
	}
	
	public void addPayment(Payment paym) throws Exception
	{
	if (paym.getGrossSalary() == null) {
		throw new Exception("Payment can't be added");
		//TODO finish this with IDs ^^
	}
	else list.add(paym);
	}
	
	public int getNumberOfPayments() {
		return list.size();
	}
	
	public Payment getPayment(int index) {
		return list.get(index);
	}
}


