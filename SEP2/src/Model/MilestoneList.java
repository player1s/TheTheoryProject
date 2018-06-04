package Model;

import java.util.ArrayList;

public class MilestoneList {

	private ArrayList<Milestone> list = new ArrayList<Milestone>();

	public MilestoneList(ArrayList<Milestone> list) {
		this.list = list;
	}

	public void add(Milestone mil) {
		list.add(mil);
	}

	public void remove(int id) {
		list.remove(id);
	}

	public Milestone getByID(int id) {
		return list.get(id);
	}
	
	public int size()
	{
		return list.size();
	}

}
