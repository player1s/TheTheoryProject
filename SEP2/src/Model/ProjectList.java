package Model;

import java.util.ArrayList;

public class ProjectList {
	private ArrayList<Project>list;
	
	public ProjectList() {
		this.list = new ArrayList<>();
	}
	
	public void addProjet(Project proj) throws Exception
	{
		 for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getProjectID() == proj.getProjectID()) {
					throw new Exception("Employee is already in");
				}
			}
		if (proj.getProjectID() == 0 || proj.getDeadLine().equals("") || proj.getNameOfContractor().equals("") || proj.getWinningProposal().equals("")) {
			throw new Exception("Employee can't be added");
		}
		else list.add(proj);
		
		
	}
	
	public int getNumberOfProject() {
		return list.size();
	}
	
	public Project getProject(int index) {
		return list.get(index);
	}
}