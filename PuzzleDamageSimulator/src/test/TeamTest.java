package test;

import jp.sodas.puzzledamagesimulator.Monster;
import jp.sodas.puzzledamagesimulator.Team;

import org.junit.Before;
import org.junit.Test;
import org.hamcrest.core.*;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

/**
 * @author togo
 * @version $Revision$, 2015/01/09
 */
public class TeamTest {

	private Team team;

	/**
	 * test
	 */
	@Test
	public void AddMenber() {
		Monster monster = new Monster();
		monster.readMonsterByname("繝�繝ｼ繧ｯ繧ｴ繝ｼ繝ｬ繝�Mk-II"); //$NON-NLS-1$
		monster.setCurrentLv(37);
		monster.setHPPlus(1);
		monster.calculateCurrentStatus();
		
		this.team.setMenber(monster, 0);
		assertTrue(true);
	}

	/**
	 * 繝�繧ｹ繝医�ｮ蜑阪↓陦後≧蜃ｦ逅�
	 */
	@Before
	public void beforeTest() {
		this.team = new Team();
	}

}
