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
}


