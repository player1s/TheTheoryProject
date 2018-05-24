package Model;



public class Employee {
	private Integer employeeID;
	private String firstName;
	private String lastName;
	private String adress;
	private String CPRnumber;
	private String Email;
	private String phoneNr;
	private String DefaultTaxCard;
	private Date DOB;
	
	public Employee(String firstName, String lastName, String adress, String CPRnumber, String Email, String phoneNR, String DefoultTaxCard, Date dob)
	{
		this.employeeID = 0;
		this.firstName = firstName;
		this.lastName = lastName;
		this.adress = adress;
		this.CPRnumber = CPRnumber;
		this.Email = Email;
		this.phoneNr = phoneNR;
		this.DefaultTaxCard = DefoultTaxCard;
		this.DOB = dob;
	}
	
	public void setEmployeeID(Integer employeeID)
	{
		this.employeeID = employeeID;
	}
	
	public void setFirstName(String name)
	{
		this.firstName = name;
	}
	
	public void setLasttName(String name)
	{
		this.lastName = name;
	}
	
	public void setAdress(String adress)
	{
		this.adress = adress;
	}
	
	public void setCPRnumber(String CPRnumber)
	{
		this.CPRnumber = CPRnumber;
	}
	
	public void setEmail(String Email)
	{
		this.Email = Email;
	}
	
	public void setPhoneNr(String phoneNr)
	{
		this.phoneNr = phoneNr;
	}
	
	public void setDefoultTaxCard(String DefoultTaxCard)
	{
		this.DefaultTaxCard = DefoultTaxCard;
	}
	
	public void setDOB(Date dob)
	{
		this.DOB = dob;
	}
	
	public Integer getEmployeeID()
	{
		return employeeID;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public String getAdress()
	{
		return adress;
	}
	
	public String getCPRnumber()
	{
		return CPRnumber;
	}
	
	public String getEmail()
	{
		return Email;
	}
	
	public String getPhoneNr()
	{
		return phoneNr;
	}
	
	public String getDefoultTaxCard()
	{
		return DefaultTaxCard;
	}
	
	public Date getDOB()
	{
		return DOB;
	}
	
	public String toString() {
		String all= employeeID + " " + firstName + " " +  lastName + " " +  adress + " " +  CPRnumber + " " +  Email + " " +  phoneNr+ " " +  DefaultTaxCard+ " " +  DOB;
		return all;
		
		
	}
	
}
