package Model;

public class Milestones {

	private String description;
	private int price;
	private Date deadline;
	
	public Milestones(String description, int price, Date deadline)
	{
		this.description=description;
		this.price = price;
		this.deadline = deadline;
				
		
	}
	
	
	public void setDescription(String description)
	{
		this.description=description;
	}
	
	public void setPrice(int price)
	{
		this.price=price;
	}
	
	public void setDeadline(Date deadline)
	{
		this.deadline=deadline;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	
	public int getPrice()
	{
		return this.price;
	}
	
	public Date getDeadline()
	{
		return this.deadline;
	}
}
