package Model;

import java.util.ArrayList;

public class PaymentList {
	private ArrayList<Payment> list;
	
	public PaymentList()
	{
		this.list = new ArrayList<>();
	}
	
	public void addPayment(Payment paym)
	{
		list.add(paym);
	}
	
	public int getNumberOfPayments() {
		return list.size();
	}
	
	public Payment getPayment(int index) {
		return list.get(index);
	}
}


