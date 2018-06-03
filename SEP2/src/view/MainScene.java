package view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

import Controller.SystemController;

public class MainScene extends Application {

	protected static SystemController controller;

	protected static Stage primaryStage;

	public static void launchGui(String[] args) {
		launch(args);
	}

	public void assignController(SystemController controller) {
		this.controller = controller;
	}

	public void start(Stage primaryStage) {

		this.primaryStage = primaryStage;

		VBox root = new VBox();
		root.setSpacing(60);
		root.setAlignment(Pos.TOP_CENTER);

		root.setPadding(new Insets(0, 25, 0, 25));

		Button employees = new Button("Employees");

		Button projects = new Button("Projects");

		Button payments = new Button("Payments");

		VBox buttons = new VBox();
		buttons.setPadding(new Insets(30, 0, 0, 135));
		Button Add = new Button("Add");
		buttons.getChildren().add(Add);
		Add.setAlignment(Pos.BOTTOM_RIGHT);
		Add.setPadding(new Insets(0, 20, 0, 20));

		root.getChildren().add(employees);
		root.getChildren().add(projects);
		root.getChildren().add(payments);

		Scene scene = new Scene(root, 600, 520);
		primaryStage.setScene(scene);
		primaryStage.show();

		employees.setOnAction((ActionEvent e) -> {
			try {
				primaryStage.setScene(EmployeeGUI.EmployeeInit());

			} catch (Exception E) {
				E.printStackTrace();
			}
		});

		projects.setOnAction((ActionEvent e) -> {
			try {
				primaryStage.setScene(ProjectGUI.ProjectInit());

			} catch (Exception E) {
				E.printStackTrace();
			}
		});

		payments.setOnAction((ActionEvent e) -> {
			try {
				primaryStage.setScene(PaymentGUI.PaymentInit());
			} catch (Exception E) {
				E.printStackTrace();
			}
		});
	}

	public static Scene MainInit() {
		VBox root = new VBox();
		root.setSpacing(60);
		root.setAlignment(Pos.TOP_CENTER);

		root.setPadding(new Insets(0, 25, 0, 25));

		Button employees = new Button("Employees");

		Button projects = new Button("Projects");

		Button payments = new Button("Payments");

		VBox buttons = new VBox();
		buttons.setPadding(new Insets(30, 0, 0, 135));
		Button Add = new Button("Add");
		buttons.getChildren().add(Add);
		Add.setAlignment(Pos.BOTTOM_RIGHT);
		Add.setPadding(new Insets(0, 20, 0, 20));

		root.getChildren().add(employees);
		root.getChildren().add(projects);
		root.getChildren().add(payments);

		employees.setOnAction((ActionEvent e) -> {
			try {
				primaryStage.setScene(EmployeeGUI.EmployeeInit());
			} catch (Exception E) {
				E.printStackTrace();
			}
		});

		projects.setOnAction((ActionEvent e) -> {
			try {
				primaryStage.setScene(ProjectGUI.ProjectInit());

			} catch (Exception E) {
				E.printStackTrace();
			}
		});

		payments.setOnAction((ActionEvent e) -> {
			try {
				primaryStage.setScene(PaymentGUI.PaymentInit());

			} catch (Exception E) {
				E.printStackTrace();
			}
		});

		return new Scene(root, 600, 520);

	}

}