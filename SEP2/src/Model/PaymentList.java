package Model;

import java.util.ArrayList;

public class PaymentList {

	private ArrayList<Payment> list = new ArrayList<Payment>();

	public PaymentList(ArrayList<Payment> list) {
		this.list = list;
	}

	public void add(Payment paym) {
		list.add(paym);
	}

	public void remove(int id) {
		list.remove(id);
	}

	public Payment getByID(int id) {
		return list.get(id);
	}
	
	public int size()
	{
		return list.size();
	}

}
