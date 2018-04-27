package Model;

public class Project {
	private Employee employee; // ??
	private int projectID;
	private boolean isCompleted;
	private boolean isSomeoneWorkingOn;
	private int caseType; // are you sure??
	private Date deadline;
	private int paymentOfProject;
	private int milestone; //??
	private String nameOfContractor;
	private String site; //??
	private String winnigProposal; //??
	private Date startDate;
	private Date endDate;
	
	public Project(int projectID, boolean isCompleted, boolean isSomeoneWorkingOn, int caseType, Date deadline, int paymentOfProject, int milestone, String nameOfContractor, String site, String winningProposal, Date startDate, Date endDate) {
		this.projectID = projectID;
		this.isCompleted = isCompleted;
		this.isSomeoneWorkingOn = isSomeoneWorkingOn;
		this.caseType = caseType;
		this.deadline = deadline;
		this.paymentOfProject = paymentOfProject;
		this.milestone = milestone;
		this.nameOfContractor = nameOfContractor;
		this.site = site;
		this.winnigProposal = winningProposal;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	


	public int getProjectID(){
		return projectID;
	}
	
	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}
	
	public boolean getIsCompleted() {
		return isCompleted;
	}
	
	public void setIsCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	
	public boolean getIsSomeoneWorkingOn() {
		return isSomeoneWorkingOn;
	}
	
	public void setIsSomeoneWorkingOn(boolean isSomeoneWorkingOn) {
		this.isSomeoneWorkingOn = isSomeoneWorkingOn;
	}
	
	public int getCaseType() {
		return caseType;
	}
	
	public void setCaseType(int caseType) {
		this.caseType = caseType;
	}
	
	public Date getDeadLine() {
		return deadline;
	}
	
	public void setDeadLine(Date deadline) {
		this.deadline = deadline;
	}
	
	public int getPaymentOfProject() {
		return paymentOfProject;
	}
	
	public void setPaymentOfProject(int paymentOfProject) {
		this.paymentOfProject = paymentOfProject;
	}
	
	public int getMilestone() {
		return milestone;
	}
	
	public void setMilestone(int milestone) {
		this.milestone = milestone;
	}
	
	public String getNameOfContractor() {
		return nameOfContractor;
	}
	
	public void setNameOfContractor(String nameOfContractor) {
		this.nameOfContractor = nameOfContractor;
	}
	
	public String getSite() {
		return site;
	}
	
	public void setSite(String site) {
		this.site = site;
	}
	
	public String getWinningProposal() {
		return winnigProposal;
	}
	
	public void setWinningProposal(String winningProposal) {
		this.winnigProposal = winningProposal;
	}
	
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public String toString() {
		String all = projectID + " " + isCompleted + " " + isSomeoneWorkingOn + " " + caseType + " " + deadline + " " + paymentOfProject + " " + milestone + " " + nameOfContractor + " " + site + " " + winnigProposal + " " + startDate + " " + endDate; 
	    return all;
	}
		
}