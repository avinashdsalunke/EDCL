package com.qa.opencart.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.opencart.constants.Constant;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private By mobileno1 = By.xpath("//*[@id=\"kt_body\"]/div/div/div[2]/div[1]/div/form/div[2]/input");
	private By checkbox=By.xpath("//input[@formcontrolname=\"terms_condition\"]");
	private By sendotpbutton = By.xpath("//button[@id=\"kt_sign_in_submit\"]");
	private By Otpfield = By.xpath("//input[@onkeypress=\"if(this.value.length==4) return false;\"]");
	private By alertmessagerequirefield = By.xpath("//div[@class=\"ng-star-inserted\"]");
	private By verifyOTP = By.xpath("//button[@id=\"kt_sign_in_submit\"]");
	private By registermob = By.xpath("(//span[@class=\"link-primary\"])[1]");
	private By updatemob = By.xpath("(//span[@class=\"link-primary\"])[2]");
	private By resendOTP = By.linkText("Resend OTP");
	private By firstuser = By.xpath("(//div[@class=\"col-md-6 fv-row ng-star-inserted\"])[1]");

//after enter date Next page
	private By AfterverifyOTP = By.xpath("//h1[@class=\"d-flex text-white fw-bolder my-1 fs-3\"]");
	private By closepopup = By.xpath("//*[@id=\"kt_modal_select_users\"]/div/div/div[1]/div/span/svg");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	@Step("....getting the login page title.....")
	public String getLoginPageTitle() throws InterruptedException {
		String title = eleUtil.waitForTitleIsAndFetch(Constant.DEFAULT_SHORT_TIME_OUT, Constant.LOGIN_PAGE_TITLE_VALUE);
		// String title=driver.getTitle();
		System.out.println("Login Page Title is:" + title);
		return title;
	}

	@Step("....getting the login page url.....")
	public String getLoginPageURL() {
		String url = eleUtil.waitForURLContainsAndFetch(Constant.DEFAULT_SHORT_TIME_OUT,
				Constant.LOGIN_PAGE_URL_FRACTION_VALUE);
		// String url=driver.getCurrentUrl();
		System.out.println("Login Page Title is:" + url);
		return url;
	}

	// POSSITIVE USE CASE

	@Step("login with mobileno : {0} and otp: {1}")
	public void doLogin1(String mobileno, String otp) throws InterruptedException {
		System.out.println("App credentials are: " + mobileno + ":" + otp);
		eleUtil.waitForElementVisible(mobileno1, Constant.DEFAULT_SHORT_TIME_OUT).sendKeys(Constant.DEFAULT_MOBILE_NO);
		eleUtil.doClick(checkbox);
		eleUtil.doClick(sendotpbutton);
		Thread.sleep(3000);
		eleUtil.doClick(Otpfield);

		eleUtil.doSendKeys(Otpfield, Constant.DEFAULT_OTP);
		eleUtil.doClick(verifyOTP);
		Thread.sleep(3000);
		eleUtil.doClick(firstuser);
	

	}

	public WebElement isAfterverifyOTP() {

		return eleUtil.waitForElementVisible(AfterverifyOTP, 20);

	}

	public String isregistermob() {

		return eleUtil.doElementGetText(registermob);

	}

	public String isupdatemob() {

		return eleUtil.doElementGetText(updatemob);

	}

	public String isresendotp() {

		return eleUtil.doElementGetText(resendOTP);

	}

	public String isalertmessage() {
		return eleUtil.doElementGetText(alertmessagerequirefield);

	}

	public String isclosebutton() {
		return eleUtil.doElementGetText(closepopup);

	}

}
