package view;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;


import java.beans.EventHandler;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import Model.Project;



public class ProjectGUI {


    public ProjectGUI() {
    }


    public static Scene ProjectInit()  {
        TableView<Project> table;

        GridPane root = new GridPane();
        root.setAlignment(Pos.TOP_CENTER);
        root.setHgap(30);

        TableColumn<Project, String> projectIDColumn = new TableColumn<>("Project ID");
        projectIDColumn.setMinWidth(200);
        projectIDColumn.setCellValueFactory(new PropertyValueFactory<>("projectID"));

        TableColumn<Project, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Project, String> isCompletedColumn = new TableColumn<>("Is Completed");
        isCompletedColumn.setMinWidth(200);
        isCompletedColumn.setCellValueFactory(new PropertyValueFactory<>("isCompleted"));

        TableColumn<Project, String> isSomeoneWorkingOnColumn = new TableColumn<>("Is Someone Working On");
        isSomeoneWorkingOnColumn.setMinWidth(200);
        isSomeoneWorkingOnColumn.setCellValueFactory(new PropertyValueFactory<>("isSomeoneWorkingOn"));

        TableColumn<Project, String> caseTypeColumn = new TableColumn<>("Case Type");
        caseTypeColumn.setMinWidth(200);
        caseTypeColumn.setCellValueFactory(new PropertyValueFactory<>("caseType"));

        TableColumn<Project, String> deadlineColumn = new TableColumn<>("Deadline");
        deadlineColumn.setMinWidth(200);
        deadlineColumn.setCellValueFactory(new PropertyValueFactory<>("deadline"));
        
        TableColumn<Project, String> paymentOfProjectColumn = new TableColumn<>("Payment Of Project");
        paymentOfProjectColumn.setMinWidth(200);
        paymentOfProjectColumn.setCellValueFactory(new PropertyValueFactory<>("paymentOfProject"));
        
        TableColumn<Project, String> nameOfContractorColumn = new TableColumn<>("Name Of Contractor");
        nameOfContractorColumn.setMinWidth(200);
        nameOfContractorColumn.setCellValueFactory(new PropertyValueFactory<>("nameOfContractor"));
        
        TableColumn<Project, String> websiteColumn = new TableColumn<>("Website");
        websiteColumn.setMinWidth(200);
        websiteColumn.setCellValueFactory(new PropertyValueFactory<>("website"));
        
        TableColumn<Project, String> winningProposalColumn = new TableColumn<>("Winning Proposal");
        winningProposalColumn.setMinWidth(200);
        winningProposalColumn.setCellValueFactory(new PropertyValueFactory<>("winningProposal"));
        
        TableColumn<Project, String> startDateColumn = new TableColumn<>("Start Date");
        startDateColumn.setMinWidth(200);
        startDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        
        TableColumn<Project, String> endDateColumn = new TableColumn<>("End Date");
        endDateColumn.setMinWidth(200);
        endDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        
        TableColumn<Project, String> employeeIDColumn = new TableColumn<>("Employee ID");
        employeeIDColumn.setMinWidth(200);
        employeeIDColumn.setCellValueFactory(new PropertyValueFactory<>("employeeID"));


        table = new TableView<>();
        table.setItems(MainScene.controller.getProjects());
        table.getColumns().addAll(projectIDColumn,nameColumn, isCompletedColumn, isSomeoneWorkingOnColumn, caseTypeColumn,deadlineColumn, paymentOfProjectColumn, nameOfContractorColumn, websiteColumn, winningProposalColumn, startDateColumn, endDateColumn, employeeIDColumn);


        VBox vBox = new VBox();
        vBox.getChildren().addAll(table);



        Label Finalaized = new Label("Employee ");
        Finalaized.setPadding(new Insets(40, 0, 0, 0));




        VBox buttons = new VBox();



        buttons.setSpacing(15);

        Button paid = new Button("Paid");
        paid.setPadding(new Insets(0, 10, 0, 10));

        Button unpaid = new Button("Unpaid");
        unpaid.setPadding(new Insets(0, 10, 0, 10));


        Button Modify = new Button("Modify");
        Modify.setPadding(new Insets(0, 10, 0, 10));

        Button Remove = new Button("Remove");
        Remove.setPadding(new Insets(0, 10, 0, 10));


        Button Add = new Button("Add");
        Add.setPadding(new Insets(0, 10, 0, 10));

        Button AddEvent = new Button("Add Event");
        Add.setPadding(new Insets(0, 10, 0, 10));

        Button back = new Button("Back");
        back.setPadding(new Insets(0, 10, 0, 10));

        Label Events = new Label("Events: ");
        TextArea EventsTxt = new TextArea();
        EventsTxt.setMaxSize(200,20);
        Events.setPadding(new Insets(10,0,0,0));


        buttons.getChildren().addAll(Modify, Remove, paid, unpaid, back, EventsTxt, AddEvent);

        //add member
        Label Name = new Label("Name: ");
        TextArea NameTxt = new TextArea();
        NameTxt.setMaxSize(200,20);
        Name.setPadding(new Insets(10,0,0,0));

        Label StudentNumber = new Label("Student number: ");
        TextArea StudentNumberTxt = new TextArea();
        StudentNumberTxt.setMaxSize(200,20);
        StudentNumber .setPadding(new Insets(10,0,0,0));

        Label Email = new Label("Email: ");
        TextArea EmailTxt = new TextArea();
        EmailTxt.setMaxSize(200,20);
        Email.setPadding(new Insets(10,0,0,0));


        Label MembershipYear = new Label("Membership year: ");
        TextArea MembershipYearTxt = new TextArea();
        MembershipYearTxt.setMaxSize(200,20);
        MembershipYear.setPadding(new Insets(10,0,0,0));

        Label PaymentYear = new Label("Payment year: ");
        TextArea PaymentYearTxt = new TextArea();
        PaymentYearTxt.setMaxSize(200,20);
        PaymentYear.setPadding(new Insets(10,0,0,0));



        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(NameTxt, StudentNumberTxt, EmailTxt, MembershipYearTxt, PaymentYearTxt);

        HBox hBox1 = new HBox();
        hBox1.setPadding(new Insets(10,10,10,10));
        hBox1.setSpacing(30);
        hBox1.getChildren().addAll(Name, StudentNumber, Email, MembershipYear, PaymentYear);

        root.add(hBox1,1,2);
        root.add(hBox,1,3);
        root.add(Add,2,3);


        ArrayList<String> events = new ArrayList<>();





        // stop adding member

        root.add(buttons, 2, 1);


        root.add(vBox, 1, 1);



/*
        Add.setOnAction((ActionEvent event) -> {
            try{
                Member member = new Member(NameTxt.getText(),StudentNumberTxt.getText(),EmailTxt.getText(),MembershipYearTxt.getText(),PaymentYearTxt.getText(),events);
                events.add(EventsTxt.getText());
                table.getItems().add(member);
                Main.controller.addMember(member);
                NameTxt.clear();
                StudentNumberTxt.clear();
                EmailTxt.clear();
                MembershipYearTxt.clear();
                PaymentYearTxt.clear();

            }
            catch (Exception E) {
                E.printStackTrace();
            }
        });

        AddEvent.setOnAction((ActionEvent event) -> {
            try{
                Member member = table.getSelectionModel().getSelectedItem();
                Main.controller.addEventToMember(member, EventsTxt.getText());
                table.setItems(Main.controller.getMembers());

            }
            catch (Exception E) {
                E.printStackTrace();
            }
        });


        Modify.setOnAction((ActionEvent event) -> {
            try{
                Main.primaryStage.setScene(MembersModify.MemModInit());
            }
            catch (Exception E) {
                E.printStackTrace();
            }
        });

        back.setOnAction((ActionEvent event) -> {
            try{
                Main.primaryStage.setScene(Main.MainInit());
            }
            catch (Exception E) {
                E.printStackTrace();
            }
        });

        Remove.setOnAction((ActionEvent event) -> {
            try{

                Member member = table.getSelectionModel().getSelectedItem();
                Main.controller.removeMember(member);
                table.setItems(Main.controller.getMembers());
            }
            catch (Exception E) {
                E.printStackTrace();
            }
        });
*/


        return new Scene(root, 1400, 600);
    }
}
