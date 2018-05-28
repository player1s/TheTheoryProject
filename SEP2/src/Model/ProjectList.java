package Model;

import java.util.ArrayList;

public class ProjectList {
	private ArrayList<Project>list;
	
	public ProjectList() {
		this.list = new ArrayList<Project>();
	}
	
	public void setProjectList(ArrayList list) {
		this.list = list;
	}
	
	public void addProjet(Project proj) throws Exception
	{
		loop: while (true) {
			int ID = (int) ((Math.random() * 1000)) + 1;
			int counter = 0;

			for (int i = 0; i < list.size(); i++) {
				if (ID == (int) list.get(i).getProjectID())
					counter++;
			}

			if (counter == 0) {
				
				proj.setProjectID(ID);
				
		 for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getDeadLine().equals(proj.getDeadLine()) && list.get(i).getWinningProposal().equals(proj.getWinningProposal()) && list.get(i).getPaymentOfProject() == proj.getPaymentOfProject())  {
					throw new Exception("Project is already in");
				}
			}
		if (proj.getName().equals("") || proj.getDeadLine().equals("") || proj.getNameOfContractor().equals("") || proj.getWinningProposal().equals("")) {
			throw new Exception("Project can't be added");
		}
		else list.add(proj);
		break loop;
			}
		}
	}
	
	
	public int getNumberOfProject() {
		return list.size();
	}
	
	public Project getProject(int index) {
		return list.get(index);
	}
	
	
	public Project getProjectByID(int ID){
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getProjectID() == ID) {
				return list.get(i);
			}
		}
		return null;
	}
	
}