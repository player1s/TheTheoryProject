package Model;

import java.util.ArrayList;

public class ProjectList {
	private ArrayList<Project>list;
	
	public ProjectList() {
		this.list = new ArrayList<>();
	}
	
	public void addProjet(Project proj) {
		list.add(proj);
	}
	
	public int getNumberOfProject() {
		return list.size();
	}
	
	public Project getProject(int index) {
		return list.get(index);
	}
}