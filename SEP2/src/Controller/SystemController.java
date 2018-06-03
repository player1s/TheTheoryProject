package Controller;

import java.util.ArrayList;

import Mediator.ModelManager;
import Model.Employee;
import Model.Payment;
import Model.Project;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import view.MainScene;

import java.awt.*;

public class SystemController {
	
	private ModelManager model;
	private MainScene gui;
	
	public SystemController(ModelManager model, MainScene gui) {
		this.model = model;
		this.gui = gui;
		this.gui.assignController(this);
	}

	
	public ObservableList<Employee> getEmployees(){
		ObservableList<Employee> list = FXCollections.observableArrayList();
		ArrayList<Employee> employees = new ArrayList<>();
		employees = getAllEmployees();
		for (int i = 0; i < employees.size(); i++) {
			list.add(employees.get(i));
		}
		return list;
	}
	
	public ArrayList<Employee> getAllEmployees(){
		return model.getAllEmployees();
	}
	
	public ObservableList<Project> getProjects(){
		ObservableList<Project> list = FXCollections.observableArrayList();
		ArrayList<Project> projects = new ArrayList<>();
		projects = getAllProjects();
		for (int i = 0; i < projects.size(); i++) {
			list.add(projects.get(i));
		}
		return list;
	}
	
	public ArrayList<Project> getAllProjects(){
		return model.getAllProjects();
	}
	
	public ObservableList<Payment> getPayments(){
		ObservableList<Payment> list = FXCollections.observableArrayList();
		ArrayList<Payment> payments = new ArrayList<>();
		payments = getAllPayments();
		for (int i = 0; i < payments.size(); i++) {
			list.add(payments.get(i));
		}
		return list;
	}
	
	public ArrayList<Payment> getAllPayments(){
		return model.getAllPayments();
	}
}
