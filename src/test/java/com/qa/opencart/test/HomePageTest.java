package com.qa.opencart.test;


import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.Constant;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("EPIC - 100: design login for open cart app")
@Story("US-Login: 101: design login page features for open cart")
public class HomePageTest extends BaseTest {

	@Severity(SeverityLevel.TRIVIAL)
	@Description("....checking the title of the page.... tester: avinash")
	@Test(priority=1)
	public void homepageTitletest() throws InterruptedException {
		String actual_title=homepage.gethomepageTitle();
		Assert.assertEquals(actual_title,"WBSEDCL");
	}
	
	
	@Severity(SeverityLevel.NORMAL)
	@Description("....checking the url of the page.... tester: avinash")
	@Test(priority=2)
	public void homePageUrlTest()
	{
		System.out.println("url");
		String URL=homepage.GetHomePageUrl();
		System.out.println(URL);
	Assert.assertTrue(URL.contains("4202"));	
	}
	
	@Test
	public void Homepagecontainkeyword()
	{
	String keytext=homepage.iskeywordexist();
	System.out.println(keytext);
	Assert.assertEquals(keytext, "Fast, Efficient and Productive");
	}
	
	@Test
	public void Homepagecontainslogan()
	{
		String slogan=homepage.issloganexist();
		System.out.println(slogan);
	Assert.assertEquals(homepage.issloganexist(),Constant.HOME_PAGE_SLOGAN_WBSEDCL);	
	}
	
	@Test
	public void Homepagecontainsigniin()
	{
		
	Assert.assertEquals(homepage.issignbuttonexist(),"Sign In");	
	}
	
	@Test
	public void Homepagecontainsregisterlink()
	{
		String registertext=homepage.isregisterlinkexist();
		System.out.println(registertext);
	Assert.assertEquals(homepage.isregisterlinkexist(),"Want to register mobile no? Click Here");	
	}	
	
	
	@Test
	public void HomepagefooterCountTest()
	{
		List<String> homepagefooterlist=homepage.getfooterList();
		System.out.println("Account page header List:"+homepagefooterlist);
		Assert.assertEquals(homepagefooterlist.size(),Constant.ACCOUNTS_PAGE_HEADERS_COUNT);
	}
	
	@Test
	public void homepagefooterValueTest()
	{
		List<String> actualhomepagefooterList=homepage.getfooterList();
		System.out.println("ActualAccount page header List:"+actualhomepagefooterList);
		System.out.println("mi");
		System.out.println("Expected Account page headers list:"+Constant.EXPECTED_ACCOUNTS_PAGE_FOOTER_LIST1);
		Assert.assertEquals(actualhomepagefooterList, Constant.EXPECTED_ACCOUNTS_PAGE_FOOTER_LIST1);
	}
	
	@Test
	public void LogoisDisplay() {
		boolean text=homepage.Islogodisplay();
		if(text) {
			System.out.println("available");
		}
		else {
			System.out.println("not available");
		}
		Assert.assertTrue(homepage.Islogodisplay());
	}
	
	
	
	
	
	
	
	
	
	
}