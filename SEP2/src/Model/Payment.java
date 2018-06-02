
package Model;

public class Payment {
	private Integer PaymentID;
	private Integer MilestoneID;
	private Integer ProjectID;
	private Integer EmployeeID;
	private Integer GrossSalary;
	private Integer HoursWorked;
	private Integer NetSalary;
	private Integer HolidayPay;
	private Integer CompanyGain;


	public Payment(Integer MilestoneID, Integer PaymentID, Integer GrossSalary, Integer HoursWorked, Integer NetSalary, Integer HolidayPay, Integer CompanyGain,
			Integer EmployeeID, Integer ProjectID) {
		this.PaymentID = PaymentID;
		this.GrossSalary = GrossSalary;
		this.HoursWorked = HoursWorked;
		this.NetSalary = NetSalary;
		this.HolidayPay = HolidayPay;
		this.CompanyGain = CompanyGain;
		this.ProjectID = ProjectID;
		this.EmployeeID = EmployeeID;
		this.MilestoneID = MilestoneID;
	}

	public void setPaymentID(Integer PaymentID) {
		this.PaymentID = PaymentID;
	}

	public void setGrossSalary(Integer GrossSalary) {
		this.GrossSalary = GrossSalary;
	}

	public void setHoursWorked(Integer HoursWorked) {
		this.HoursWorked = HoursWorked;
	}

	public void setNetSalary(Integer NetSalary) {
		this.NetSalary = NetSalary;
	}

	public void setHolidayPay(Integer HolidayPay) {
		this.HolidayPay = HolidayPay;
	}

	public void setCompanyGain(Integer CompanyGain) {
		this.CompanyGain = CompanyGain;
	}
	
	public void setEmployeeID(Integer EmployeeID) {
		 this.EmployeeID=EmployeeID;
	}
	
	public void setProjectID(Integer ProjectID) {
		 this.ProjectID=ProjectID;
	}
	
	public void setMilestoneID(Integer MilestoneID) {
		 this.MilestoneID=MilestoneID;
	}

	public Integer getPaymentID() {
		return this.PaymentID;
	}


	public Integer getGrossSalary() {
		return this.GrossSalary;
	}

	public Integer getHoursWorked() {
		return this.HoursWorked;
	}

	public Integer getNetSalary() {
		return this.NetSalary;
	}

	public Integer getHolidayPay() {
		return this.HolidayPay;
	}

	public Integer getCompanyGain() {
		return this.CompanyGain;
	}
	
	public Integer getEmployeeID() {
		return this.EmployeeID;
	}
	
	public Integer getProjectID() {
		return this.ProjectID;
	}
	
	public Integer getMilestoneID() {
		return this.MilestoneID;
	}

	public String toString() {
		String all = PaymentID + " " + GrossSalary + " " + HoursWorked + " " + NetSalary + " " + HolidayPay + " "
				+ EmployeeID + " " + ProjectID;
		return all;
	}
}
