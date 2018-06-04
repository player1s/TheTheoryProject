package Model;

import java.util.ArrayList;

public class ProjectList {

	private ArrayList<Project> list = new ArrayList<Project>();

	public ProjectList(ArrayList<Project> list) {
		this.list = list;
	}

	public void add(Project proj) {
		list.add(proj);
	}

	public void remove(int id) {
		list.remove(id);
	}

	public Project getByID(int id) {
		return list.get(id);
	}
	
	public int size()
	{
		return list.size();
	}

}
