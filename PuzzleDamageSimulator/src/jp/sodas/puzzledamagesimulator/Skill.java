package jp.sodas.puzzledamagesimulator;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class Skill {
	private String target;
	private double magnification;

	public Skill(String target2, double magnification2) {
		// TODO Auto-generated constructor stub
		target = target2;
		magnification = magnification2;
	}

	public void Skill() {
		target = "";
		magnification = 1.0;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public void setMagnification(double magnification) {
		this.magnification = magnification;
	}

	public double whetherMagnification(Monster targerMonster) {
		if(targerMonster.equals("ALL")) return magnification;
		if(targerMonster.getMainAtrribute().equals(target)) return magnification;
		if(targerMonster.getSubAtrribute().equals(target)) return magnification;
		if(targerMonster.getMainType().equals(targerMonster)) return magnification;
		if(targerMonster.getSubType().equals(target)) return magnification;
		return 1.0;
	}

}
