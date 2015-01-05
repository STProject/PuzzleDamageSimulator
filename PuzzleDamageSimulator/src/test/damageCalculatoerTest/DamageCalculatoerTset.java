/*
 * Created on 2015/01/05
 * Copyright (C) 2015 Koga Laboratory. All rights reserved.
 *
 */
package test.damageCalculatoerTest;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import jp.sodas.puzzledamagesimulator.DamageCalculatoer;

import org.junit.Before;
import org.junit.Test;


public class DamageCalculatoerTset {

  DamageCalculatoer calculater;

  /**
   * ドロップ数のダメージ倍率のテスト
   */
  @SuppressWarnings("boxing")
  @Test
  public void bonusOfDrops() {
    assertThat(this.calculater.BonusOfDrops(3, 0), is(1.00));
    assertThat(this.calculater.BonusOfDrops(3, 0), is(not(2.00)));

  }

  /**
   * コンボ数のダメージ倍率テスト
   */
  @SuppressWarnings("boxing")
  @Test
  public void bonusOfCombo() {
    assertThat(this.calculater.bonusOfCombo(1), is(1.00));
    assertThat(this.calculater.bonusOfCombo(1), is(not(2.00)));

  }

  @SuppressWarnings("boxing")
  @Test
  public void bonusOfAttributeEnhanced(){
    assertThat(this.calculater.bonusOfAttributeEnhanced(5, 2), is(2.00));
    assertThat(this.calculater.bonusOfAttributeEnhanced(5 ,1), is(not(1.00)));
    
  }
  /**
   * テストの前に行う処理
   */
  @Before
  public void beforeTest() {
    this.calculater = new DamageCalculatoer();

  }

}
