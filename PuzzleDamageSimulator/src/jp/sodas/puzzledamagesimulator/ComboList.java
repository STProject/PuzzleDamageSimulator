/*
 * Created on 2015/01/06
 * Copyright (C) 2015 Koga Laboratory. All rights reserved.
 *
 */
package jp.sodas.puzzledamagesimulator;

import java.util.ArrayList;

public class ComboList {

	private static ArrayList<Combo> comboList;

	/**
	 * コンボをリストに加えます
	 * 
	 * @param combo
	 *            コンボ
	 */
	public void addCombo(Combo combo) {
		comboList.add(combo);

	}

	/**
	 * コンボリストをクリアーします ダメージ計算が終わるたびに実行させます
	 * */
	public void clearComboList() {
		comboList.clear();
	}

	/**
	 * 合計のコンボ数を返します
	 * 
	 * @return コンボ数
	 */
	public int numberOfCombo() {
		return comboList.size();

	}

	public void addComboList(Combo combo) {
		comboList.add(combo);
	}

	public Combo getCombo(int i) {
		return comboList.get(i);

	}

}
