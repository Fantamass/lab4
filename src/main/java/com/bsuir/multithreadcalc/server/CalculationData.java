package com.bsuir.multithreadcalc.server;

import java.util.concurrent.Semaphore;

public class CalculationData {
	private static String expression;
	private static Semaphore access = new Semaphore(1);
	private static Semaphore calculateStart = new Semaphore(1);
	private static Semaphore calculateComplete = new Semaphore(1);

	public static String getExpression() {
		return expression;
	}
	
	public static void getAcess() {
		try {
			access.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void realizeAcess() {
		access.release();
	}
	
	public static void releaseCacalculateStart() {
		calculateStart.release();
	}
	
	public static void releaseCalculateComplete() {
		calculateComplete.release();
	}
		
	public static void getCalculateStart() {
		try {
			calculateStart.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void getCalculateComplete() {
		try {
			calculateComplete.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void setExpression(String expression) {
		CalculationData.expression = expression;
	}
}
