package Model;

public class Project {
	private Employee employee;
	private int projectID;
	private String name;
	private boolean isCompleted;
	private boolean isSomeoneWorkingOn;
	private int caseType; // are you sure??
	private Date deadline;
	private int paymentOfProject;
	private String nameOfContractor;
	private String website; // ??
	private String winningProposal; // ??
	private Date startDate;
	private Date endDate;

	public Project(int projectID, String name, boolean isCompleted, boolean isSomeoneWorkingOn, int caseType,
			Date deadline, int paymentOfProject, String nameOfContractor, String website, String winningProposal,
			Date startDate, Date endDate, Employee employee) {
		this.projectID = projectID;
		this.name = name;
		this.isCompleted = isCompleted;
		this.isSomeoneWorkingOn = isSomeoneWorkingOn;
		this.caseType = caseType;
		this.deadline = deadline;
		this.paymentOfProject = paymentOfProject;
		this.nameOfContractor = nameOfContractor;
		this.website = website;
		this.winningProposal = winningProposal;
		this.startDate = startDate;
		this.endDate = endDate;
		this.employee = employee;
	}

	public int getProjectID() {
		return projectID;
	}

	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getNameOfContractor() {
		return nameOfContractor;
	}

	public void setNameOfContractor(String nameOfContractor) {
		this.nameOfContractor = nameOfContractor;
	}

	public String getWebsite() {
		return website;
	}

	public void setSite(String website) {
		this.website = website;
	}

	public String getWinningProposal() {
		return winningProposal;
	}

	public void setWinningProposal(String winningProposal) {
		this.winningProposal = winningProposal;
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

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}

	public Integer getEmployeeID() {
		return employee.getEmployeeID();
	}
	
	public void setEmployeeID(Integer employeeID) {
		this.employee.setEmployeeID(employeeID);
	}

	public String toString() {
		String all = projectID + " " + name + " " + isCompleted + " " + isSomeoneWorkingOn + " " + caseType + " "
				+ deadline + " " + paymentOfProject + " " + nameOfContractor + " " + website + " " + winningProposal
				+ " " + startDate + " " + endDate + " " + employee.getEmployeeID() ;
		return all;
	}

}