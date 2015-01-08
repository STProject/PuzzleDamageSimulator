/*
 * Created on 2015/01/06
 * Copyright (C) 2015 Koga Laboratory. All rights reserved.
 *
 */
package jp.sodas.puzzledamagesimulator;

import javax.lang.model.type.PrimitiveType;

import sun.security.mscapi.KeyStore.MY;

import com.sun.java.swing.plaf.motif.resources.motif;

public class Team {
	private Monster[] teamMenber;
	private final int MAX_MENBER =6;
	private LeaderSkill myLeaderSkill;
	private LeaderSkill friendLeaderSkill;

	public Team() {
		teamMenber = new Monster[MAX_MENBER];
		for (int i = 0; i < teamMenber.length; i++) {
			teamMenber[i] = new Monster();

		}
	}
	
	public void setMenber(Monster monster, int position){
		teamMenber[position] = monster;
	}

	public LeaderSkill getMyLeaderSkill() {
		return myLeaderSkill;
	}

	public void setMyLeaderSkill(LeaderSkill myLeaderSkill) {
		this.myLeaderSkill = myLeaderSkill;
	}

	public LeaderSkill getFriendLeaderSkill() {
		return friendLeaderSkill;
	}

	public void setFriendLeaderSkill(LeaderSkill friendLeaderSkill) {
		this.friendLeaderSkill = friendLeaderSkill;
	}
	
	
	
}
