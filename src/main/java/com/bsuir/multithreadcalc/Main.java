package com.bsuir.multithreadcalc;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		MainController.getInstance().setStage(primaryStage);
		MainController.getInstance().start();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
