package Model;

import java.util.ArrayList;

public class ProjectList {
	private ArrayList<Project>list;
	
	public ProjectList() {
		this.list = new ArrayList<>();
	}
	
	public void addProjet(Project project) {
		list.add(project);
	}
	
	public int getNumberOfProject() {
		return list.size();
	}
	
	public Project getProjet(int index) {
		return list.get(index);
	}
}