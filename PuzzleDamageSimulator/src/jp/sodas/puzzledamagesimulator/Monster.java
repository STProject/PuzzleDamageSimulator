/*
 * Created on 2015/01/06
 * Copyright (C) 2015 Koga Laboratory. All rights reserved.
 *
 */
package jp.sodas.puzzledamagesimulator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.StringTokenizer;


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
  private int MaxLv;
  private double HPIndex;
  private double AttackIndex;
  private double ResilienceIndex;
  private Arousal[] arousals;
  private int HP;
  private int Attack;
  private int Resilience;
  private int HPPlus;
  private int AttackPlus;
  private int ResiliencePlus;
  private int currentLv;

  public void currentAttack(int currentLv) {
    // 現在のステ=Lv1のステ+(最大Lvのステ-Lv1のステ)*{(現在Lv-1)/(最大Lv-1)}^n
    this.Attack = (int)(InitialAttack + (MaxAttack - InitialAttack) * Math.pow((currentLv / MaxLv), AttackIndex)) + AttackPlus * 5;

  }

  public void currentHP(int currentLv) {
    // 現在のステ=Lv1のステ+(最大Lvのステ-Lv1のステ)*{(現在Lv-1)/(最大Lv-1)}^n
    this.HP = (int)(InitialHP + (MaxHP - InitialHP) * Math.pow((currentLv / MaxLv), HPIndex)) + HPPlus * 10;
  }

  public void currentResilience(int currentLv) {
    // 現在のステ=Lv1のステ+(最大Lvのステ-Lv1のステ)*{(現在Lv-1)/(最大Lv-1)}^n
    this.Resilience = (int)(InitialResilience + (MaxResilience - InitialResilience) * Math.pow((currentLv / MaxLv), ResilienceIndex)) + ResiliencePlus * 3;
  }
  
  public void calculateCurrentAttack() {
    // 現在のステ=Lv1のステ+(最大Lvのステ-Lv1のステ)*{(現在Lv-1)/(最大Lv-1)}^n
    this.Attack = (int)(InitialAttack + (MaxAttack - InitialAttack) * Math.pow((currentLv-1) / (double)(MaxLv-1), AttackIndex)+0.5) + AttackPlus * 10;
  }

  public void calculateCurrentHP() {
    // 現在のステ=Lv1のステ+(最大Lvのステ-Lv1のステ)*{(現在Lv-1)/(最大Lv-1)}^n
    this.HP = (int)(InitialHP + (MaxHP - InitialHP) * Math.pow((currentLv-1) / (double)(MaxLv-1), HPIndex)+0.5) + HPPlus * 10;
  }

  public void calculateCurrentResilience() {
    // 現在のステ=Lv1のステ+(最大Lvのステ-Lv1のステ)*{(現在Lv-1)/(最大Lv-1)}^n
    this.Resilience = (int)(InitialResilience + (MaxResilience - InitialResilience) * Math.pow((currentLv-1) / (double)(MaxLv-1), ResilienceIndex)+0.5) + ResiliencePlus * 10;
  }
  
  public void calculateCurrentStatus(){
    calculateCurrentAttack();
    calculateCurrentHP();
    calculateCurrentResilience();
  }

  public void setStaus(int currentLv, int attackPlus, int HPPlus, int ResilinecePlus) {
    this.HPPlus = HPPlus;
    this.AttackPlus = attackPlus;
    this.ResiliencePlus = ResilinecePlus;

    currentAttack(currentLv);
    currentHP(currentLv);
    currentResilience(currentLv);

  }

  public void setMonsterName(String name) {
    this.name = name;

  }

  public void showMonsterData() {
    System.out.println("名前   " + name);
    System.out.println("レア度  " + rarity);
    System.out.println("主属性  " + mainAtrribute);
    System.out.println("副属性 " + subAtrribute);
    System.out.println("主タイプ    " + mainType);
    System.out.println("副タイプ    " + subType);
    System.out.println("初期HP    " + InitialHP);
    System.out.println("初期攻撃力   " + InitialAttack);
    System.out.println("初期回復力   " + InitialResilience);
    System.out.println("コスト " + cost);
    System.out.println("スキル名    " + skillName);
    System.out.println("リーダースキル名    " + leaderSkillName);
    System.out.println("覚醒数  " + numbaerOfArousal);
    System.out.println("最大Lv       " + MaxLv);
    System.out.println("最大HP    " + MaxHP);
    System.out.println("最大攻撃力   " + MaxAttack);
    System.out.println("最大回復力   " + MaxResilience);
    System.out.println("HP指数    " + HPIndex);
    System.out.println("攻撃力指数   " + AttackIndex);
    System.out.println("回復力指数   " + ResilienceIndex);

  }

  public void setMonsterData(String[] data) {
    this.name = data[1];
    this.rarity = Integer.parseInt(data[2]);
    this.mainType = data[3];
    this.subType = data[4];
    this.mainAtrribute = data[5];
    this.subAtrribute = data[6];
    this.InitialHP = Integer.parseInt(data[7]);
    this.InitialAttack = Integer.parseInt(data[8]);
    this.InitialResilience = Integer.parseInt(data[9]);
    this.cost = Integer.parseInt(data[10]);
    this.skillName = data[11];
    this.leaderSkillName = data[12];
    this.numbaerOfArousal = Integer.parseInt(data[13]);
    this.MaxLv = Integer.parseInt(data[15].replaceAll(" ", ""));
    this.MaxHP = Integer.parseInt(data[17]);
    this.MaxAttack = Integer.parseInt(data[18]);
    this.MaxResilience = Integer.parseInt(data[19]);
    this.HPIndex = Double.parseDouble(data[20]);
    this.AttackIndex = Double.parseDouble(data[21]);
    this.ResilienceIndex = Double.parseDouble(data[22]);

  }

  public void readMonsterByname(String name) {
    String dir = System.getProperty("user.dir");
    System.out.println("Projectのトップレベルのパス： " + dir);
    try {
      //ファイルを読み込む
      FileReader fr = new FileReader(dir + "\\res\\raw\\pazudora.csv");
      BufferedReader br = new BufferedReader(fr);

      //読み込んだファイルを１行ずつ処理する
      String line;
      StringTokenizer token;
      while ((line = br.readLine()) != null) {
        //(2)文字列をsplitメソッドで分割
        String[] strAry = line.split(",");

        if (strAry.length > 1 && strAry[1].equals(name)) {
          System.out.println(strAry[1]);
          setMonsterData(strAry);
        }

      }

      //終了処理
      br.close();

    } catch (IOException ex) {
      //例外発生時処理
      ex.printStackTrace();
    }
  }

  
  public String getMainType() {
    return mainType;
  }

  
  public String getSubType() {
    return subType;
  }

  
  public int getRarity() {
    return rarity;
  }

  
  public String getName() {
    return name;
  }

  
  public String getMainAtrribute() {
    return mainAtrribute;
  }

  
  public String getSubAtrribute() {
    return subAtrribute;
  }

  
  public int getInitialHP() {
    return InitialHP;
  }

  
  public int getInitialAttack() {
    return InitialAttack;
  }

  
  public int getInitialResilience() {
    return InitialResilience;
  }

  
  public int getCost() {
    return cost;
  }

  
  public String getSkillName() {
    return skillName;
  }

  
  public String getLeaderSkillName() {
    return leaderSkillName;
  }

  
  public int getNumbaerOfArousal() {
    return numbaerOfArousal;
  }

  
  public int getMaxHP() {
    return MaxHP;
  }

  
  public int getMaxAttack() {
    return MaxAttack;
  }

  
  public int getMaxResilience() {
    return MaxResilience;
  }

  
  public int getMaxLv() {
    return MaxLv;
  }

  
  public double getHPIndex() {
    return HPIndex;
  }

  
  public double getAttackIndex() {
    return AttackIndex;
  }

  
  public double getResilienceIndex() {
    return ResilienceIndex;
  }

  
  public Arousal[] getArousals() {
    return arousals;
  }

  
  public int getHP() {
    return HP;
  }

  
  public int getAttack() {
    return Attack;
  }

  
  public int getResilience() {
    return Resilience;
  }

  
  public int getHPPlus() {
    return HPPlus;
  }

  
  public int getAttackPlus() {
    return AttackPlus;
  }

  
  public int getResiliencePlus() {
    return ResiliencePlus;
  }

  
  public void setHPPlus(int hPPlus) {
    HPPlus = hPPlus;
  }

  
  public void setAttackPlus(int attackPlus) {
    AttackPlus = attackPlus;
  }

  
  public void setResiliencePlus(int resiliencePlus) {
    ResiliencePlus = resiliencePlus;
  }

  
  public int getCurrentLv() {
    return currentLv;
  }

  
  public void setCurrentLv(int currentLv) {
    this.currentLv = currentLv;
  }
}
