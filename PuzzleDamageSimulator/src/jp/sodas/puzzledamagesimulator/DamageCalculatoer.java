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
   * @param drops 同時に消したドロップ数（3－30）
   * @param enhancedDrops 強化されたドロップの数(drops >= enhancedDrops)
   * @return ドロップ数によるダメージ倍率
   */
  public double BonusOfDrops(int drops, int enhancedDrops) {
    double bonusOfDrops = (drops + 1) * 0.25;
    bonusOfDrops = bonusOfDrops * (enhancedDrops * 0.06 + 1.00);
    return bonusOfDrops;

  }
  
  

}
