package com.vtiger.comcast.genericUtility;

import java.util.Random;
/**
 * this class is used to store java specific generic libraries
 * @author pc
 *
 */
public class JavaUtility {
		/**
		 * this method is used to generate integer numbers randoml in the range of 0 to 10000
		 * @return intData
		 */
		public int getRanDomNumber() {
		Random ranDom = new Random();
		int ranDomNum = ranDom.nextInt(10000);
		return ranDomNum;
		
		
		
	}
}
