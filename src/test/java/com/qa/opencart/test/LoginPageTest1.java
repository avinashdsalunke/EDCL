package com.qa.opencart.test;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.Constant;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class LoginPageTest1 {

	@Epic("EPIC - 100: design login for open cart app")
	@Story("US-Login: 101: design login page features for open cart")
	public class LoginPageTest extends BaseTest {
		
		@Severity(SeverityLevel.TRIVIAL)
		@Description("....checking the title of the page.... tester: avinash")
		@Test(priority=1)
		public void loginPageTitleTest() throws InterruptedException
		{
			String actual_title= Logpage.getLoginPageTitle();
			Assert.assertEquals(actual_title, "WBSEDCL");		
		}
		
		@Severity(SeverityLevel.NORMAL)
		@Description("....checking the url of the page.... tester: avinash")
		@Test(priority=2)
		public void loginPageUrlTest()
		{
			String ACT_URL= Logpage.getLoginPageURL();
			System.out.println("ACT_URL");
			Assert.assertTrue(ACT_URL.contains("4202"));
		}
		@Severity(SeverityLevel.BLOCKER)
		@Description("....checking user is able to login to app with correct username and password....")
		@Test(priority=4)
		public void loginTest() throws InterruptedException
		{
			Logpage.doLogin1(prop.getProperty("mobileno").trim(), prop.getProperty("otp").trim());
			Thread.sleep(2000);
	        Assert.assertTrue(Logpage.isAfterverifyOTP().isDisplayed());
		}
		
		
		
		
		
		
		
		
		
		
		
	}
}