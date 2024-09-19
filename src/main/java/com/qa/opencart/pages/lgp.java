package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.Constant;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class lgp {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private By mobileno1 = By.xpath("//*[@id=\"kt_body\"]/div/div/div[2]/div[1]/div/form/div[2]/input");
	private By checkbox=By.xpath("//input[@formcontrolname=\"terms_condition\"]");
	private By sendotpbutton = By.xpath("//button[@id=\"kt_sign_in_submit\"]");
	private By Otpfield = By.xpath("//input[@onkeypress=\"if(this.value.length==4) return false;\"]");
	private By verifyOTP = By.xpath("//button[@id=\"kt_sign_in_submit\"]");
	

//after enter date Next page
   private By AfterverifyOTP=By.xpath("//h1[@class=\"d-flex justify-content-center align-items-center mb-3\"]");
   
   public lgp(WebDriver driver) {
	   this.driver=driver;
	   eleUtil=new ElementUtil(driver);
   }
 
	@Step("-------login--------")
	public  void doLogin1(String mobileno,String otp) throws InterruptedException {
		System.out.println("App credentials are: "+mobileno+":"+otp);
Thread.sleep(5000);
		eleUtil.waitForElementVisible(mobileno1, Constant.DEFAULT_MEDIUM_TIME_OUT).sendKeys(Constant.DEFAULT_MOBILE_NO);
		eleUtil.doClick(checkbox);
eleUtil.doClick(sendotpbutton);
Thread.sleep(3000);
eleUtil.doClick(Otpfield);

eleUtil.doSendKeys(Otpfield, Constant.DEFAULT_OTP);
eleUtil.doClick(verifyOTP);

		
		
	}
	public String isAfterverifyOTP() {
		
		return eleUtil.doElementGetText(AfterverifyOTP);
		
		}



		}
		
	

	
	
	
	
	
	
	
	
	
	
	
	
	
   
