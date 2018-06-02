package Model;

import java.sql.Date;

public class Milestone {
	private Integer milestoneID;
	private String description;
	private Integer price;
	private Date deadline;
	private Integer EmployeeID;
	private Integer ProjectID;
	
	
	public Milestone( String description, Integer price, Date deadline, Integer milestoneID, Integer EmployeeID, Integer ProjectID)
	{
		this.milestoneID=milestoneID;
		this.description=description;
		this.price = price;
		this.deadline = deadline;
		this.EmployeeID=EmployeeID;
		this.ProjectID=ProjectID;
				
		
	}
	
	public void setMilestoneID(Integer milestoneID){
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
	
	public void setEmployeeID(Integer EmployeeID){
		this.EmployeeID = EmployeeID;
	}
	
	public void setProjectID(Integer ProjectID){
		this.ProjectID = ProjectID;
	}
	
	public Integer getMilestoneID() {
		return milestoneID;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	
	public Integer getPrice()
	{
		return this.price;
	}
	
	public Date getDeadline()
	{
		return this.deadline;
	}
	
	public Integer getEmployeeID() {
		return EmployeeID;
	}
	
	public Integer getProjectID() {
		return ProjectID;
	}
	
	public String toString() {
		String all = this.milestoneID +" "+ this.description + " " + this.price + " " + this.deadline;
		return all;
	}
}
