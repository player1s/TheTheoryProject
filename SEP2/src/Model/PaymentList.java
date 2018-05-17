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
		//if(paym.getGrossSalary() == null)
		//list.add(paym);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getGrossSalary().equals(paym.getGrossSalary())) {
				throw new Exception("Payment is already in");
			}
		}
	if (paym.getGrossSalary() == null) {
		throw new Exception("Payment can't be added");
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


