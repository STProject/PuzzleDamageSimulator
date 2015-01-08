/*
 * Created on 2015/01/05
 * Copyright (C) 2015 Koga Laboratory. All rights reserved.
 *
 */
package test;

import jp.sodas.puzzledamagesimulator.Monster;

import org.junit.Before;
import org.junit.Test;
import org.hamcrest.core.*;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;


/**
 * @author togo
 * @version $Revision$, 2015/01/06
 */
public class MonsterTset {

  Monster monster;

  /**
	 * 
	 */
  @Test
  public void readMonsterByNameTest() {
    this.monster.readMonsterByname("大花龍ブラキオス"); //$NON-NLS-1$
    this.monster.showMonsterData();

  }

  @SuppressWarnings("boxing")
  @Test
  public void readMonsterTest() {
    this.monster.readMonsterByname("ダークゴーレムMk-II");
    this.monster.setCurrentLv(37);
    this.monster.setHPPlus(1);
    this.monster.calculateCurrentStatus();
    
    assertThat(this.monster.getHP(), is(1292));
    assertThat(this.monster.getAttack(), is(656));
    assertThat(this.monster.getResilience(), is(49));
  }

  /**
   * テストの前に行う処理
   */
  @Before
  public void beforeTest() {
    this.monster = new Monster();

  }

}
