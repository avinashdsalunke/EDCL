package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.opencart.constants.Constant;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class dashbordheader {

	public WebDriver driver;
	private ElementUtil eleUtil;
    
	private By logoimage = By.xpath("//img[@class=\"logo-default h-45px\"]");
	private By hometab = By.linkText("Home");
	private By hellotext = By.xpath("//*[@id=\"kt_toolbar_container\"]/div/ul/li[1]/a");
	
	private By Complaint=By.linkText("Complaint");
	private By Complaints=By.xpath("//h1[@class=\"d-flex text-white fw-bolder my-1 fs-3\"]");
	
	private By Safety=By.linkText("Safety");
	private By Safety1=By.linkText("Safety");
	
	private By Service=By.linkText("Service");
	private By Service1=By.linkText("Service");

	private By Billing = By.xpath("(//span[contains(text(),'Billing')])[1]");
	private By billinglist = By.xpath("(//span[@class=\"menu-title\"])[3]");

	private By usage = By.linkText("Usage");
	private By dailytab = By.xpath("//a[@id=\"kt_activity_today_tab\"]");
	private By Weekly = By.xpath("//a[@id=\"kt_activity_week_tab\"]");
	private By Monthly = By.xpath("//a[@id=\"kt_activity_month_tab\"]");
	private By Seasonal = By.xpath("//a[@id=\"kt_activity_year_tab\"]");

	private By complainthistory = By.linkText("Complaint History");
	private By complaintbutton = By.xpath("//a[@data-bs-toggle=\"modal\"]");

	private By cotnactus = By.linkText("Contact Us");
	private By contactusN = By.xpath("//*[@id=\"kt_content\"]/div/div/div[1]/div/h3");
	
	
	
	//header
	private By headers=By.xpath("//div[@class=\"menu-item menu-lg-down-accordion me-lg-1\"]");

	public dashbordheader(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	@Step(".....getting the homepage title........")
public String gethomepageTitle() throws InterruptedException  {
		String title=eleUtil.waitForTitleIsAndFetch(Constant.DEFAULT_SHORT_TIME_OUT, Constant.LOGIN_PAGE_TITLE_VALUE);
	return title;
	}
	
	@Step("......getting the HOMEPAGE URL.........")
	public String GetHomePageUrl() {
		String url=eleUtil.waitForURLContainsAndFetch(Constant.DEFAULT_MEDIUM_TIME_OUT, Constant.LOGIN_PAGE_URL_FRACTION_VALUE);
		
		return url;
		
	}
	
@Step("-------header----------")	
public  List<String> getheaderList() throws InterruptedException {
	List<WebElement>HLIST=eleUtil.waitForElementsVisible(headers, Constant.DEFAULT_LONG_TIME_OUT);
	Thread.sleep(3000);
	 List<String> HValueList=new ArrayList<String>();
for (WebElement m1 : HLIST) {
	String text=m1.getText();
	Thread.sleep(3000);
	HValueList.add(text);
	System.out.println(text);
}
return HValueList;
	}
	
	
	@Step
	public boolean isLOGO() {
		
		return eleUtil.doElementIsDisplayed(logoimage);
		}

	@Step
	public String DBH() throws InterruptedException {
		eleUtil.doClick(hometab);
		String M1=eleUtil.getElement(hellotext).getText();
		return M1;
	}
		public String DBB() {

		eleUtil.doClick(Billing);
		String M2=eleUtil.getElement(billinglist).getText();
          return M2;
		}
		
		public String DBU1() {

		eleUtil.doClick(usage);
		String M3=eleUtil.getElement(dailytab).getText();
        return M3;
		}
		
		public String DBU2() {
		eleUtil.doClick(usage);
		String M4=eleUtil.getElement(Weekly).getText();
        return M4;
		}
		public String DBU3() {
         eleUtil.doClick(usage);
 		String M5=eleUtil.getElement(Monthly).getText();
         return M5;

	}
		public String DBU4() {
	         eleUtil.doClick(usage);
	 		String M6=eleUtil.getElement(Seasonal).getText();
	         return M6;

}
		public String DBC() {
	         eleUtil.doClick(Complaint);
	 		String M7=eleUtil.getElement(Complaints).getText();
	         return M7;
		}

		public String DBCon() {
	         eleUtil.doClick(cotnactus);
	 		String M8=eleUtil.getElement(contactusN).getText();
	         return M8;
		}
		
		
		
		
			
	
		
		
		
		
		
		
		
		
		

}