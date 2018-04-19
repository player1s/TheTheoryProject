package Model;

public class Employee {
	private String firstName;
	private String lastName;
	private String adress;
	private String CPRnumber;
	private String Email;
	private String phoneNr;
	private String DefoultTaxCard;
	
	public Employee(String firstName, String lastName, String adress, String CPRnumber, String Email, String phoneNR, String DefoultTaxCard)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.adress = adress;
		this.CPRnumber = CPRnumber;
		this.Email = Email;
		this.phoneNr = phoneNR;
		this.DefoultTaxCard = DefoultTaxCard;
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
	
}
