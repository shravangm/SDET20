package com.vtiger.comcast.genericUtility;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * class used to read data from commonData file
 * @author pc
 *
 */

public class FileUtility {
	
	/**
	 * used to read the data from properties file
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws Throwable {
   	FileInputStream fis = new FileInputStream("./data/comData.properties");
   	Properties pobj = new Properties();
   	pobj.load(fis);
   	String value = pobj.getProperty(key);
	return value;
   	
   }


}
