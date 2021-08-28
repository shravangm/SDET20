package com.vtiger.comcast.createContact;

import org.testng.annotations.Test;

import com.vtiger.comcast.genericUtility.BaseClass;

public class CreateContactTest extends BaseClass {
	@Test
	public void CreateCont() {
		System.out.println("execute create contact");
	}
	
	@Test
	public void CreateContWithOrg() {
		System.out.println("execute create contact with org");
	}
	
	@Test
	public void CreateContWithAddress() {
		System.out.println("execute create contact with address");
	}
}
