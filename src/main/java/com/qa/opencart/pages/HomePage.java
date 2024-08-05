package com.qa.opencart.pages;

	import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.Constant;
	import com.qa.opencart.utils.ElementUtil;

	import io.qameta.allure.Step;

	public class HomePage {

		private WebDriver driver;
		private ElementUtil eleUtil;
		
		private By keyword=By.xpath("//h1[@class=\"fw-bolder fs-2qx pb-5 pb-md-10 text-white\"]");
		private By slogan=By.xpath("//p[@class=\"fw-bold fs-7 text-white\"]");
		private By signin=By.xpath("//h1[@class=\"text-dark mb-3\"]");
		private By registerlink=By.xpath("//a[@class=\"fs-6 fw-bolder text-dark\"]");
		private By footermenu=By.xpath("//a[@target=\"_blank\"]");
		private By WBlogo=By.xpath("//*[@id=\"kt_body\"]/div/div/div[1]/div/div/div/a/img");
		public HomePage(WebDriver driver) {
			this.driver=driver;
			eleUtil=new ElementUtil(driver);
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
		
		public String iskeywordexist() {
			
			return eleUtil.doElementGetText(keyword);
			
			}
		
		public String issloganexist() {
			return eleUtil.doElementGetText(slogan);

		}
		public String issignbuttonexist() {
			return eleUtil.doElementGetText(signin);

		}
		public String isregisterlinkexist() {
			return eleUtil.doElementGetText(registerlink);

		}
		
		public List<String> getfooterList(){
			
			List<WebElement>FooterList=eleUtil.waitForElementsVisible(footermenu, Constant.DEFAULT_MEDIUM_TIME_OUT);
			List<String> footervallist=new ArrayList<String>();
			for(WebElement R:FooterList) {
				String text=R.getText();
				footervallist.add(text);
			}
			return footervallist;
			
		}
		
		public boolean Islogodisplay() {
			return eleUtil.doElementIsDisplayed(WBlogo);
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}


