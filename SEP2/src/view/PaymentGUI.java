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


import Model.Payment;


public class PaymentGUI {


    public PaymentGUI() {
    }


    public static Scene PaymentInit()  {
        TableView<Payment> table;

        GridPane root = new GridPane();
        root.setAlignment(Pos.TOP_CENTER);
        root.setHgap(30);

        TableColumn<Payment, String> MilestoneIDColumn = new TableColumn<>("Milestone ID");
        MilestoneIDColumn.setMinWidth(200);
        MilestoneIDColumn.setCellValueFactory(new PropertyValueFactory<>("milestoneID"));

        TableColumn<Payment, String> PaymentIDColumn = new TableColumn<>("Payment ID");
        PaymentIDColumn.setMinWidth(200);
        PaymentIDColumn.setCellValueFactory(new PropertyValueFactory<>("PaymentID"));

        TableColumn<Payment, String> GrossSalaryColumn = new TableColumn<>("Gross Salary");
        GrossSalaryColumn.setMinWidth(200);
        GrossSalaryColumn.setCellValueFactory(new PropertyValueFactory<>("GrossSalary"));

        TableColumn<Payment, String> HoursWorkedColumn = new TableColumn<>("Hours Worked");
        HoursWorkedColumn.setMinWidth(200);
        HoursWorkedColumn.setCellValueFactory(new PropertyValueFactory<>("HoursWorked"));

        TableColumn<Payment, String> NetSalaryColumn = new TableColumn<>("Net Salary");
        NetSalaryColumn.setMinWidth(200);
        NetSalaryColumn.setCellValueFactory(new PropertyValueFactory<>("NetSalary"));

        TableColumn<Payment, String> HolidayPayColumn = new TableColumn<>("Holiday Pay");
        HolidayPayColumn.setMinWidth(200);
        HolidayPayColumn.setCellValueFactory(new PropertyValueFactory<>("HolidayPay"));
        
        TableColumn<Payment, String> CompanyGainColumn = new TableColumn<>("Company Gain");
        CompanyGainColumn.setMinWidth(200);
        CompanyGainColumn.setCellValueFactory(new PropertyValueFactory<>("CompanyGain"));
        
        TableColumn<Payment, String> DEmployeeIDColumn = new TableColumn<>("Employee ID");
        DEmployeeIDColumn.setMinWidth(200);
        DEmployeeIDColumn.setCellValueFactory(new PropertyValueFactory<>("EmployeeID"));
        
        TableColumn<Payment, String> ProjectIDColumn = new TableColumn<>("Project ID");
        ProjectIDColumn.setMinWidth(200);
        ProjectIDColumn.setCellValueFactory(new PropertyValueFactory<>("ProjectID"));


        table = new TableView<>();
        table.setItems(MainScene.controller.getPayments());
        table.getColumns().addAll(MilestoneIDColumn,PaymentIDColumn, GrossSalaryColumn, HoursWorkedColumn, NetSalaryColumn,HolidayPayColumn, CompanyGainColumn, DEmployeeIDColumn, ProjectIDColumn);


        VBox vBox = new VBox();
        vBox.getChildren().addAll(table);




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
