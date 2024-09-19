package com.qa.opencart.test;



import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.Constant;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class Dashboardheadertest extends BaseTest {
	

	@Severity(SeverityLevel.TRIVIAL)
	@Description("....checking the title of the page.... tester: avinash")
	@Test(priority=1)
	public void DBpageTitletest() throws InterruptedException {
		String actual_title=DH.gethomepageTitle();
		Assert.assertEquals(actual_title,"WBSEDCL");
	}
	
	
	@Severity(SeverityLevel.NORMAL)
	@Description("....checking the url of the page.... tester: avinash")
	@Test(priority=2)
	public void DBPageUrlTest()
	{
		System.out.println("url");
		String URL=DH.GetHomePageUrl();
		System.out.println(URL);
	Assert.assertTrue(URL.contains("4202"));	
	}
	
	@Test
	public void actualcount() throws InterruptedException {
		Logpage.doLogin1(prop.getProperty("mobileno").trim(), prop.getProperty("otp").trim());

		List<String>actcn=DH.getheaderList();
		
		System.out.println("am"+ actcn);
		System.out.println("mgmg");
		Assert.assertEquals(actcn.size(),Constant.ACCOUNTS_PAGE_HEADERS_COUNT1);
		Assert.assertEquals(actcn, Constant.EXPECTED_ACCOUNTS_PAGE_HEADERS_LIST1);
	}
	
@Test
	public void logo() {
		boolean LG = DH.isLOGO();
		Assert.assertTrue(LG);
	}



	@Test
	public void tab() throws InterruptedException {
		System.out.println("------home---------");
		String exp = "Home";
		String M = DH.DBH();
		System.out.println("avinash");
		Assert.assertEquals(M, exp);
		
		System.out.println("------billing---------");

		String expB = "Billing & Payment History";
		String M1 = DH.DBB();
		Assert.assertEquals(M1, expB);
		
		
		System.out.println("------usage---------");

		String expD1 = "Daily";
		String ActD1 = DH.DBU1();

		String expW1 = "Weekly";
		String ActW1 = DH.DBU2();

		String expM1 = "Monthly";
		String ActM1 = DH.DBU3();

		String expS1 = "Seasonal";
		String ActS1 = DH.DBU4();
		Assert.assertEquals(ActD1, expD1);
		Assert.assertEquals(ActW1, expW1);
		Assert.assertEquals(ActM1, expM1);
		Assert.assertEquals(ActS1, expS1);
		
		System.out.println("------complaint---------");

		String actcom=DH.DBC();
		String ExpCom="Complaints";
		Assert.assertEquals(actcom, ExpCom);
		

		System.out.println("------contact us---------");

		String actcon = DH.DBCon();
		System.out.println(actcon);
		String ExpCon = "Contact Us";
		Assert.assertEquals(actcon, ExpCon);
	}
	
	

}
