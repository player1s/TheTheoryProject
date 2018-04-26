package Model;

import Mediator.Database;

public class Payment {
	private int PaymentID;
	// private Job job;
	//private Employee employee;
	private int GrossSalary;
	private int HoursWorked;
	private int NetSalary;
	private int HolidayPay;
	private int CompanyGain;
	
	

	public Payment(int PaymentID, int GrossSalary, int HoursWorked, int NetSalary, int HolidayPay, int CompanyGain) {
		this.PaymentID= PaymentID;
		this.GrossSalary = GrossSalary;
		this.HoursWorked=HoursWorked;
		this.NetSalary = NetSalary;
		this.HolidayPay = HolidayPay;
		this.CompanyGain = CompanyGain;
	}
	
	public void setPaymentID(int PaymentID) {
		this.PaymentID=PaymentID;
	}

	
	public void setGrossSalary(int GrossSalary) {
		this.GrossSalary=GrossSalary;
	}

	public void setHoursWorked(int HoursWorked) {
		this.HoursWorked= HoursWorked;
	}
	
	public void setNetSalary(int NetSalary) {
		this.NetSalary=NetSalary;
	}
	
	public void setHolidayPay(int HolidayPay) {
		this.HolidayPay = HolidayPay;
	}
	
	public void setCompanyGain(int CopmanyGain) {
		this.CompanyGain= CompanyGain;
	}
	
	public int getPaymentID() {
		return this.PaymentID;
	}
	
	// public Job getJobID(){
	//return job.getJobID;}
	
	//public Employee getEmployeeID(){
	//return employee.getEmployeeID;}
	
	public int getGrossSalary() {
		return this.GrossSalary;
	}
	
	public int getHoursWorked() {
		return this.HoursWorked;
	}
	
	public int getNetSalary() {
		return this.NetSalary;
	}
	
	public int getHolidayPay() {
		return this.HolidayPay;
	}
	
	public int getCompanyGain() {
		return this.CompanyGain;
	}
	}


