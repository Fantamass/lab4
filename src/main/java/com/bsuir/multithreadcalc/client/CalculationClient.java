package com.bsuir.multithreadcalc.client;

import com.bsuir.multithreadcalc.client.ClientController;

import javafx.stage.Stage;

public class CalculationClient {
		
	public CalculationClient() {	
		ClientController controller = new ClientController(new Stage());
		controller.start();
	}
}
