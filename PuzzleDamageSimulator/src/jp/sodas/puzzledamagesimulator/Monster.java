/*
 * Created on 2015/01/06
 * Copyright (C) 2015 Koga Laboratory. All rights reserved.
 *
 */
package jp.sodas.puzzledamagesimulator;

import java.util.ArrayList;


public class Monster {
private String mainType;
private String subType;
private int rarity;
private String name;
private String mainAtrribute;
private String subAtrribute;
private int InitialHP;
private int InitialAttack;
private int InitialResilience;
private int cost;
private String skillName;
private String leaderSkillName;
private int numbaerOfArousal;
private int MaxHP;
private int MaxAttack;
private int MaxResilience;
private double HPIndex;
private double AttackIndex;
private double ResilienceIndex;
private ArrayList<Arousal> arousals;

public int currentAttack(int currentLv){
  //現在のステ=Lv1のステ+(最大Lvのステ-Lv1のステ)*{(現在Lv-1)/(最大Lv-1)}^n
  return InitialAttack+(MaxAttack-InitialAttack)
}
}
