package com.qa.opencart.test;


import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;


public class lgt extends BaseTest {

	   @DataProvider
	    public Object[][] getlogdata() throws IOException, InterruptedException, InvalidFormatException {
	        Object logdata[][] =com.qa.opencart.utils.ExcelUtil.getTestData("Sheet1");
	        return logdata;
	    }

	    @Test(dataProvider = "getlogdata")
	    public void userrlogt(String username, String password) throws InterruptedException {
	    	
	    	LP.doLogin1(username, password);
	    	System.out.println("mfactor");
}}