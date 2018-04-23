package Model;

public class Employee {
	private String memberID;
	private String firstName;
	private String lastName;
	private String adress;
	private String CPRnumber;
	private String Email;
	private String phoneNr;
	private String DefoultTaxCard;
	private Date DOB;
	
	public Employee(String memberID, String firstName, String lastName, String adress, String CPRnumber, String Email, String phoneNR, String DefoultTaxCard, Date dob)
	{
		this.memberID = memberID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.adress = adress;
		this.CPRnumber = CPRnumber;
		this.Email = Email;
		this.phoneNr = phoneNR;
		this.DefoultTaxCard = DefoultTaxCard;
		this.DOB = dob;
	}
	
	public void setMemberId(String memberID)
	{
		this.memberID = memberID;
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
		this.DefoultTaxCard = DefoultTaxCard;
	}
	
	public void setDOB(Date dob)
	{
		this.DOB = dob;
	}
	
	public String getMemberID()
	{
		return memberID;
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
		return DefoultTaxCard;
	}
	
	public Date getDOB()
	{
		return DOB;
	}
	
}
