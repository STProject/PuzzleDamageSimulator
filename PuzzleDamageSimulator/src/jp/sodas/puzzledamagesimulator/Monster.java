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
	private ArrayList<Arousal> arousals;
	private int HP;
	private int Attack;
	private int Resilience;
	private int HPPlus;
	private int AttackPlus;
	private int ResiliencePlus;

	public void currentAttack(int currentLv) {
		// 現在のステ=Lv1のステ+(最大Lvのステ-Lv1のステ)*{(現在Lv-1)/(最大Lv-1)}^n
		this.Attack = (int) (InitialAttack + (MaxAttack - InitialAttack)
				* Math.pow((currentLv / MaxLv), AttackIndex))
				+ AttackPlus * 5;

	}

	public void currentHP(int currentLv) {
		// 現在のステ=Lv1のステ+(最大Lvのステ-Lv1のステ)*{(現在Lv-1)/(最大Lv-1)}^n
		this.HP = (int) (InitialHP + (MaxHP - InitialHP)
				* Math.pow((currentLv / MaxLv), HPIndex))
				+ HPPlus * 10;
	}

	public void currentResilience(int currentLv) {
		// 現在のステ=Lv1のステ+(最大Lvのステ-Lv1のステ)*{(現在Lv-1)/(最大Lv-1)}^n
		this.Resilience = (int) (InitialResilience + (MaxResilience - InitialResilience)
				* Math.pow((currentLv / MaxLv), ResilienceIndex))
				+ ResiliencePlus * 3;
	}

	public void setStaus(int currentLv, int attackPlus, int HPPlus,
			int ResilinecePlus) {
		this.HPPlus = HPPlus;
		this.AttackPlus = attackPlus;
		this.ResiliencePlus = ResilinecePlus;

		currentAttack(currentLv);
		currentHP(currentLv);
		currentResilience(currentLv);

	}
	
	public void setMonsterName(String name){
		this.name=name;
		
	}
	public void setMonsterData(String[] data){
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
		this.MaxLv = Integer.parseInt(data[15]);
		this.MaxHP = Integer.parseInt(data[16]);
		this.MaxAttack = Integer.parseInt(data[17]);
		this.MaxResilience = Integer.parseInt(data[18]);
		this.HPIndex = Integer.parseInt(data[19]);
		this.AttackIndex = Integer.parseInt(data[20]);
		this.ResilienceIndex = Integer.parseInt(data[21]);
		
		
	}
	public void readMonsterByname(String name){
		 String dir = System.getProperty("user.dir");
		    System.out.println("Projectのトップレベルのパス： " + dir);
		  try {
	            //ファイルを読み込む
	            FileReader fr = new FileReader(dir+"\\res\\raw\\pazudora.csv");
	            BufferedReader br = new BufferedReader(fr);

	            //読み込んだファイルを１行ずつ処理する
	            String line;
	            StringTokenizer token;
	            while ((line = br.readLine()) != null) {
	            	   //(2)文字列をsplitメソッドで分割
	                String[] strAry = line.split(",");
	                //System.out.println(strAry[1]);
	                if(strAry.length>1 && strAry[1].equals(name)){
	                	System.out.println(strAry);
	                }
	               
	            }

	            //終了処理
	            br.close();

	        } catch (IOException ex) {
	            //例外発生時処理
	            ex.printStackTrace();
	        }
	}
}
