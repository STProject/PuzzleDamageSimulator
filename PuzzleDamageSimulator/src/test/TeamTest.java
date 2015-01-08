package test;

import jp.sodas.puzzledamagesimulator.Monster;
import jp.sodas.puzzledamagesimulator.Team;

import org.junit.Before;
import org.junit.Test;
import org.hamcrest.core.*;

import sun.awt.geom.AreaOp.AddOp;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

public class TeamTest {

	private Team team;

	@Test
	public void AddMenber() {
		Monster monster = new Monster();
		monster.readMonsterByname("ダークゴーレムMk-II");
		monster.setCurrentLv(37);
		monster.setHPPlus(1);
		monster.calculateCurrentStatus();
		
		team.setMenber(monster, 0);
		assertTrue(true);
	}

	/**
	 * テストの前に行う処理
	 */
	@Before
	public void beforeTest() {
		this.team = new Team();
	}

}
