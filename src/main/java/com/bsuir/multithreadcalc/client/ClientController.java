package com.bsuir.multithreadcalc.client;

import com.bsuir.multithreadcalc.client.ClientView;
import com.bsuir.multithreadcalc.server.CalculationData;

import javafx.stage.Stage;

public class ClientController {   
    private ClientView view;
    
    public ClientController(Stage viewStage) {
    	view = new ClientView(viewStage, this);
    }
    
    public void start() {
    	view.create();
    	view.show();
    }
    
    public void calculateButtonPressed() {
    	CalculationData.getAcess();
    	CalculationData.setExpression(view.getExpression());

    	CalculationData.releaseCacalculateStart();
		CalculationData.getCalculateComplete();

		view.setAnswer(CalculationData.getExpression());
    	CalculationData.realizeAcess();
    }
}
