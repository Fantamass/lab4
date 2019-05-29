package com.bsuir.multithreadcalc.server;

import com.bsuir.multithreadcalc.server.CalculationData;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class CalculationServer implements Runnable {
    private static CalculationServer instance;      
    public static CalculationServer getInstance() {
        if(instance == null) {
        	instance = new CalculationServer();
        } 
        return instance;
    }
    
	@Override
	public void run() {
		CalculationData.getCalculateStart();
		CalculationData.getCalculateComplete();
		
        while (true) {
        	
            if (Thread.currentThread().isInterrupted())
            	break;            
        	
			CalculationData.getCalculateStart();
			String expression = CalculationData.getExpression();
			String answer = "error";
			
			try{
				Expression e = new ExpressionBuilder(expression).build();
				answer = String.valueOf(e.evaluate());
			}catch (Exception err) {
			}
			
			CalculationData.setExpression(answer);
			CalculationData.releaseCalculateComplete();
		}
	}
	
	public void close(){
		Thread.currentThread().interrupt();
	}
}
