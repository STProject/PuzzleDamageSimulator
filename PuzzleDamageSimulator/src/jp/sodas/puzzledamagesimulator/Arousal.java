/*
 * Created on 2015/01/08
 * Copyright (C) 2015 Koga Laboratory. All rights reserved.
 *
 */
package jp.sodas.puzzledamagesimulator;

public class Arousal {
	private String name;
	/**
	 * ドロップ強化覚醒の倍率
	 * */
	final static double MAGNIFICATION_OF_ENHANCEDROP = 0.05;
	static double MAGNIFICATION_OF_2WAY = 1.5;

	public Arousal(String name) {
this.name = name;
	}

	public double getMAGNIFICATION_OF_ENHANCEDROP() {
		return MAGNIFICATION_OF_ENHANCEDROP;
	}

	public double getMAGNIFICATION_OF_2WAY() {
		return MAGNIFICATION_OF_2WAY;
	}

}
