package Model;



public class Payment {
	private int PaymentID;
	private Project project;
	private Employee employee;
	private Integer GrossSalary;
	private int HoursWorked;
	private int NetSalary;
	private int HolidayPay;
	private int CompanyGain;
	
	

	public Payment(int PaymentID, Integer GrossSalary, int HoursWorked, int NetSalary, int HolidayPay, int CompanyGain, Project project, Employee employee) {
		this.PaymentID= PaymentID;
		this.GrossSalary = GrossSalary;
		this.HoursWorked=HoursWorked;
		this.NetSalary = NetSalary;
		this.HolidayPay = HolidayPay;
		this.CompanyGain = CompanyGain;
		this.project = project;
		this.employee = employee;
	}
	
	public void setPaymentID(int PaymentID) {
		this.PaymentID=PaymentID;
	}

	
	public void setGrossSalary(Integer GrossSalary) {
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
	
	public int getProjectID(){
		return project.getProjectID();
	}
	 
	public void setProjectID(int projectID) {
		this.project.setProjectID(projectID);
	}
	
	public int getEmployeeID(){
		return employee.getEmployeeID();
	}
	
	public void setEmployeeID(int employeeID) {
		this.employee.setEmployeeID(employeeID);
	}
	
	public Integer getGrossSalary() {
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
	
	public String toString() {
		String all = PaymentID + " " + GrossSalary + " " + HoursWorked + " " + NetSalary + " " + HolidayPay + " " + CompanyGain + " " + project.getProjectID() + " " + employee.getEmployeeID() ;
		return all;
	}
	}


