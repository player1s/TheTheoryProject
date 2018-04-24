package Model;

import Mediator.Database;

public class Payment {
	private int PaymentID;
	// private Job JobID;
	//private Employee MemberID;
	private int GrossSalary;
	private int HoursWorked;
	private int NetSalary;
	private int HolidayPay;
	
	public Payment(int PaymentID, int GrossSalary, int HoursWorked, int NetSalary, int HolidayPay) {
		PaymentID= this.PaymentID;
		GrossSalary = this.GrossSalary;
		HoursWorked=this.HoursWorked;
		NetSalary = this.NetSalary;
		HolidayPay = this.HolidayPay;
	}
	
	public void setPaymentID(int PaymentID) {
		this.PaymentID=PaymentID;
	}

	//public void setJobID(Job JobID){
	// this.JobID = JobID
    //}
	
	//public void set MemberID(Employee MemberID){
	//this.MemberID = MemberID;
	//}
	
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
	
	public int getPaymentID() {
		return this.PaymentID;
	}
	
	// public Job getJobID(){
	//return this.JobID;}
	
	//public Employee getMemberID(){
	//return this.MemberID;}
	
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
	}


