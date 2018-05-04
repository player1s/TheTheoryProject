package Model;

import java.util.ArrayList;

public class MilestoneList {
	private ArrayList<Milestone> list;
	private Milestone milestone;
	
	public MilestoneList() {
		this.list = new ArrayList<>();
	}
	
	public void addMilestone(Milestone mil) {
		list.add(mil);
	}
	
	public int getNumberOfMilestones() {
		return list.size();
	}
	
	public Milestone getMilestone(int index) {
		return list.get(index);
	}
	
	public String toString() {
		String all="";
		for (int i = 0; i < list.size(); i++) {
			all+= milestone.toString() + "/n";
		}
		return all;
	}
}
