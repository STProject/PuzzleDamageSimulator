/*
 * Created on 2015/01/05
 * Copyright (C) 2015 Koga Laboratory. All rights reserved.
 *
 */
package test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import jp.sodas.puzzledamagesimulator.DamageCalculatoer;
import jp.sodas.puzzledamagesimulator.Monster;

import org.junit.Before;
import org.junit.Test;

/**
 * @author togo
 * @version $Revision$, 2015/01/06
 */
public class MonsterTset {

	Monster monster;

	@Test
	public void readMonsterByNameTest() {
		monster.readMonsterByname("ティラノス");

	}

	/**
	 * テストの前に行う処理
	 */
	@Before
	public void beforeTest() {
		this.monster = new Monster();

	}

}
