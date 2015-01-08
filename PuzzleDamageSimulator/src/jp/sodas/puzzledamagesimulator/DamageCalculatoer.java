/*
 * Created on 2015/01/06
 * Copyright (C) 2015 Koga Laboratory. All rights reserved.
 *
 */
package jp.sodas.puzzledamagesimulator;

/**
 * @author togo
 * @version $Revision$, 2015/01/06
 */
public class DamageCalculatoer {
	
	/**
	 * ドロップ数に応じたダメージ倍率を計算します
	 * 
	 * @param drops
	 *            同時に消したドロップ数（3－30）
	 * @param enhancedDrops
	 *            強化されたドロップの数(drops >= enhancedDrops)
	 * @param arousal
	 *            ドロップ強化の覚醒数
	 * @return ドロップ数によるダメージ倍率
	 */
	public double BonusOfDrops(int drops, int enhancedDrops, int arousal) {
		double bonusOfDrops = (drops + 1) * 0.25;// ドロップ数による倍率
		bonusOfDrops = bonusOfDrops * (enhancedDrops * 0.06 + 1.00);// 強化ドロップの倍率
		if (enhancedDrops > 0) {
			bonusOfDrops = bonusOfDrops
					* (arousal * Arousal.MAGNIFICATION_OF_ENHANCEDROP + 1.00);// ドロップ強化の覚醒による倍率
		}
		return bonusOfDrops;

	}

	/**
	 * コンボ数に応じたダメージ倍率を計算します
	 * 
	 * @param combo
	 *            コンボ数（combo >1)
	 * @return コンボ数によるダメージ倍率
	 */
	public double bonusOfCombo(int combo) {
		double bonusOfCombo = (combo - 1) * 0.25 + 1.00;
		return bonusOfCombo;
	}

	/**
	 * 属性強化覚醒（列強）に応じたダメージ倍率を計算します
	 * 
	 * @param arousal
	 *            属性強化覚醒（列強）の数
	 * @param column
	 *            消した列の数
	 * @return 属性強化覚醒（列強）によるダメージ倍率
	 */
	public double bonusOfAttributeEnhance(int arousal, int column) {
		double bonusOfArousal = arousal * 0.10 * column + 1.00;
		return bonusOfArousal;
	}

	public double bonusOf2way(int arousals) {
		return Math.pow(Arousal.MAGNIFICATION_OF_2WAY, arousals);
	}

	public double bonusOfLeaderSkill(LeaderSkill skill, Monster targetMonster) {
		return skill.whetherLeaderSkill(targetMonster);
	}

	public int mainAttributeDamage(Monster target, ComboList comboList) {
		double damage = 0;
		Combo combo;
		for (int i = 0; i < comboList.getSize(); i++) {
			combo = comboList.getCombo(i);
			if (combo.getAttribute().equals(target.getMainAtrribute())) {
				damage += target.getAttack() * bonusOf2way(arousals)
						* BonusOfDrops(drops, enhancedDrops, arousal);
			}
		}
		damage = damage*bonusOfCombo(comboList.getSize())*bonusOfAttributeEnhance(arousal, column)*bonusOfLeaderSkill(skill, targetMonster)*bonusOfLeaderSkill(skill, targetMonster);
	
	}

}
