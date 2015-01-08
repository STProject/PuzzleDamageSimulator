/*
 * Created on 2015/01/06
 * Copyright (C) 2015 Koga Laboratory. All rights reserved.
 *
 */
package jp.sodas.puzzledamagesimulator;

import com.sun.java.swing.plaf.motif.resources.motif;

public class Team {
	private Monster[] teamMenber;
	private final int MAX_MENBER =6;

	public Team() {
		teamMenber = new Monster[MAX_MENBER];
		for (int i = 0; i < teamMenber.length; i++) {
			teamMenber[i] = new Monster();

		}
	}
	
	public void setMenber(Monster monster, int position){
		teamMenber[position] = monster;
	}
	
	
}
