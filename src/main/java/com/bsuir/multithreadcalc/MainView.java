package com.bsuir.multithreadcalc;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.HashMap;
import java.util.Map;

public class MainView {
	private Stage primaryStage;
	private GridPane gridPane; 
	private Map<String, Label> labels  = new HashMap<String, Label>();
	
	public Map<String, Label> getLabels(){
		return labels;
	}	

	public MainView(Stage viewStage) {
			primaryStage = viewStage;
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
	
	private void configureLabel(Label newLabel) {
        newLabel.setMaxWidth(Double.MAX_VALUE);
        newLabel.setMaxHeight(Double.MAX_VALUE);
        GridPane.setHgrow(newLabel, Priority.ALWAYS);
        GridPane.setVgrow(newLabel, Priority.ALWAYS);
        newLabel.setFont(new Font("Arial", 20));
	}
	
	private void addLabel(String title, String id, int positionX, int positionY) {
		Label newLabel = new Label(title);
        gridPane.add(newLabel, positionY, positionX);
        configureLabel(newLabel);
        labels.put(id, newLabel);
	}
	
	public void insertButtons() {
		addButton(Strings.BUTTON_CREATE, 1, 0).setOnMouseClicked( event -> {MainController.getInstance().calculateButtonPressed();} );	
	}
	

	private void insertLabels() {
		addLabel(Strings.LABEL, Strings.LABEL, 0, 0);		
	}
		
	public void insertElements() {
		insertButtons();
		insertLabels();
	}


	public void create() {
		insertElements();
		Scene scene = new Scene(gridPane,200,100);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
	}
	
	public void show() {
		primaryStage.show();
	}
}
