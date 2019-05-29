package com.bsuir.multithreadcalc.client;

import com.bsuir.multithreadcalc.client.ClientController;
import com.bsuir.multithreadcalc.Strings;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ClientView {
	private ClientController controller;
	private Stage viewStage;
	private GridPane gridPane;
	private TextField expression;

	public ClientView(Stage stage, ClientController attachedControler) {
			controller = attachedControler;
			viewStage = stage;
			gridPane = new GridPane();
	        gridPane.setPadding(new Insets(5));
	        gridPane.setVgap(10); 
	        gridPane.setHgap(10); 	        
	        viewStage.setTitle(Strings.APP_TITLE);
	}
	
	private void configureButton(Button newButton) {
        newButton.setMaxWidth(Double.MAX_VALUE);
        newButton.setMaxHeight(Double.MAX_VALUE);
        GridPane.setHgrow(newButton, Priority.ALWAYS);
        GridPane.setVgrow(newButton, Priority.ALWAYS);
        newButton.setFont(new Font("Arial", 14));
	}
	
	private Button addButton(String title, int positionX, int positionY) {
		Button newButton = new Button(title);
        gridPane.add(newButton, positionY, positionX);
        configureButton(newButton);
        return newButton;
	}
	
	private void configureTextField(TextField newTextField) {
		newTextField.setMaxWidth(Double.MAX_VALUE);
		newTextField.setMaxHeight(Double.MAX_VALUE);
        GridPane.setHgrow(newTextField, Priority.ALWAYS);
        GridPane.setVgrow(newTextField, Priority.ALWAYS);
        newTextField.setFont(new Font("Arial", 20));
	}
	
	private TextField addTextField(int positionX, int positionY) {
		TextField newTextField = new TextField();
        gridPane.add(newTextField, positionY, positionX);
        configureTextField(newTextField);
        return newTextField;
	}
	
	public void insertButtons() {
		addButton(Strings.BUTTON_CALCULATE, 1, 0).setOnMouseClicked( event -> {controller.calculateButtonPressed();} );	
	}

	private void insertTextFields() {
		expression = addTextField(0, 0);	
	}
		
	public void insertElements() {
		insertButtons();
		insertTextFields();
	}


	public void create() {
		insertElements();
		Scene scene = new Scene(gridPane,200,100);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		viewStage.setScene(scene);
		viewStage.setResizable(false);
	}
	
	public void show() {
		viewStage.show();
	}
	
	public String getExpression() {
		return expression.getText();
	}
	
	public void setAnswer(String answer) {
		expression.setText(answer);
	}

}
