package jp.sodas.puzzledamagesimulator;

import java.util.ArrayList;
import java.util.List;


public class LeaderSkill {

	private ArrayList<Conditions> conditions;

	public double whetherLeaderSkill(Monster targetMonster) {
		double magnification = 1.0;
		for (int i = 0; i < conditions.size(); i++) {

			magnification = conditions.get(i).whetherMagnification(
					targetMonster);
			if (magnification != 1.0)
				return magnification;
		}
		return magnification;
	}

	public void addConditions(String target, double magnification) {
		conditions.add(new Conditions(target, magnification));
	}

}
