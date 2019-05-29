package com.bsuir.multithreadcalc;

import com.bsuir.multithreadcalc.client.CalculationClient;
import com.bsuir.multithreadcalc.server.CalculationServer;

import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MainController {
    private static MainController instance;      
    public static MainController getInstance() {
        if(instance == null)
        	instance = new MainController();
        else if (view == null)
        	return null;        
        return instance;
    }
    
    private static MainView view;
    
    public void setStage(Stage viewStage) {
    	view = new MainView(viewStage);
    	
    	viewStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
    	    @Override
    	    public void handle(WindowEvent event) {
    	    	CalculationServer.getInstance().close();
    	    }
    	});
    }
    
    public void start() {
    	view.create();
    	view.show();
    	
		Thread myThready = new Thread(CalculationServer.getInstance());
		myThready.start();
    }

    public void calculateButtonPressed() {
    	new CalculationClient();
    }
}
