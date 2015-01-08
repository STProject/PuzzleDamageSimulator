/*
 * Created on 2015/01/06
 * Copyright (C) 2015 Koga Laboratory. All rights reserved.
 *
 */
package jp.sodas.puzzledamagesimulator;

import java.util.ArrayList;


/**
 * @author togo
 * @version $Revision$, 2015/01/06
 */
public class Combo {

  private String attribute;
  private int numberOfDrop;
  private int numberOfEnhancedDrop;
  private boolean isColumn;

  /**
   * 新しく生成された<code>Combo</code>オブジェクトを初期化します。
   * 
   * @param attribute 属性
   * @param numberOfDrop 消したドロップの数
   * @param numberOfEnhancedDrop 強化ドロップの数
   * @param isColumn 列かどうか
   */
  public Combo(String attribute, int numberOfDrop, int numberOfEnhancedDrop, boolean isColumn) {
    this.attribute = attribute;
    this.numberOfDrop = numberOfDrop;
    this.numberOfEnhancedDrop = numberOfEnhancedDrop;
    this.isColumn = isColumn;

  }

public String getAttribute() {
	return attribute;
}

public boolean isColumn() {
	return isColumn;
}
  
  

}
