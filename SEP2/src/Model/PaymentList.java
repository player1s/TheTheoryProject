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
		loop: while (true) {
			int ID = (int) ((Math.random() * 1000)) + 1;
			int counter = 0;

			for (int i = 0; i < list.size(); i++) {
				if (ID == (int) list.get(i).getPaymentID())
					counter++;
			}

			if (counter == 0) {
				
				paym.setPaymentID(ID);
				
	if (paym.getGrossSalary() == null) {
		throw new Exception("Payment can't be added");
		//TODO finish this with IDs ^^
	}
	else list.add(paym);
	break loop;
			}
		}
	}
	
	public int getNumberOfPayments() {
		return list.size();
	}
	
	public Payment getPayment(int index) {
		return list.get(index);
	}
}


