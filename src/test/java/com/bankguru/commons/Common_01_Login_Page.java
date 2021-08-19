package com.bankguru.commons;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import commons.AbtractTest;
import pageObjectUser.CommonLoginPagePO;

public class Common_01_Login_Page extends AbtractTest {
	WebDriver driver;
    CommonLoginPagePO loginPage;
    String email="john"+getRandomNumber()+"@gmail.com";
    public static String userid,password;
	@Parameters(value = { "brower", "url" })
	@BeforeClass
	public void beforeClass(String brower, String url) {
		driver = getBrowerName(brower, url);
		
		log.info("Step-01: click to here visit link ");
		loginPage.clickToHereVisitLink();
		
		log.info("Step-02: input to email textbox ");
		loginPage.inputToEmailTextbox(email);
		
		log.info("Step-03: click to submit button ");
		loginPage.clickToSubmitButton();
		
		log.info("Step-04: get text userid  ");
		userid=loginPage.getTextUserId();
		
		log.info("Step-05: get text password ");
		password=loginPage.getTextPassword();
		
	}
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
