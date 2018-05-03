package Model;

public class Milestone {
	private String milestoneID;
	private String description;
	private int price;
	private Date deadline;
	
	public Milestone(String milestoneID, String description, int price, Date deadline)
	{
		this.milestoneID=milestoneID;
		this.description=description;
		this.price = price;
		this.deadline = deadline;
				
		
	}
	
	public void setMilestoneID(String milestoneID){
		this.milestoneID = milestoneID;
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
	
	public String getMilestoneID() {
		return milestoneID;
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
