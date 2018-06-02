 package Model;

import java.sql.Date;

public class Project {
	private Integer employeeID;
	private Integer projectID;
	private String name;
	private boolean isCompleted;
	private boolean isSomeoneWorkingOn;
	private Integer caseType;
	private Date deadline;
	private Integer paymentOfProject;
	private String nameOfContractor;
	private String website;
	private String winningProposal;
	private Date startDate;
	private Date endDate;

	public Project( boolean isCompleted, boolean isSomeoneWorkingOn, Integer caseType,
			Date deadline, Integer paymentOfProject, String nameOfContractor, String winningProposal,
			Date startDate, Date endDate, String name, String website, Integer emp, Integer projectID) {
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
		this.employeeID = emp;
	}

	public Integer getProjectID() {
		return projectID;
	}

	public void setProjectID(Integer projectID) {
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

	public Integer getCaseType() {
		return caseType;
	}

	public void setCaseType(Integer caseType) {
		this.caseType = caseType;
	}

	public Date getDeadLine() {
		return deadline;
	}

	public void setDeadLine(Date deadline) {
		this.deadline = deadline;
	}

	public Integer getPaymentOfProject() {
		return paymentOfProject;
	}

	public void setPaymentOfProject(Integer paymentOfProject) {
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

	public void setEmployee(Integer employee) {
		this.employeeID = employee;
	}

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String toString() {
		String all = projectID + " " + name + " " + isCompleted + " " + isSomeoneWorkingOn + " " + caseType + " "
				+ deadline + " " + paymentOfProject + " " + nameOfContractor + " " + website + " " + winningProposal
				+ " " + startDate + " " + endDate + " " + employeeID;
		return all;
	}

}