package com.bankguru.users;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.commons.Common_01_Login_Page;

import commons.AbtractTest;
import pageObjectUser.CommonLoginPagePO;
import pageObjectUser.PageGenerator;
import pageObjectUser.UserManagerPagePO;
import pageObjectUser.UserNewAccountPagePO;

public class User_01_New_Account_Verify extends AbtractTest {
	WebDriver driver;
    CommonLoginPagePO loginPage;
    UserNewAccountPagePO newAccountpage;
    UserManagerPagePO managerPage;
	@Parameters(value = { "browser", "url" })
	@BeforeClass
	public void beforeClass(String brower, String url) {
		driver = getBrowserName(brower, url);
		loginPage=PageGenerator.getCommonLoginPage(driver);
//		managerPage=loginPage.loginToSystem(Common_01_Login_Page.userid,Common_01_Login_Page.password);
		managerPage=loginPage.loginToSystem("mngr348463","nUsajEh");
	    
	}

	@Test
	public void TC_01_Customer_Id_With_Empty_Data() {
		log.info("Step-01: open new account page");
		newAccountpage=managerPage.openNewAccountPage(driver);
		
		log.info("Step-02: input to customer id with empty data");
		newAccountpage.inputToCustomerIdTextbox("");
		
		log.info("Step-03: press key tab");
		newAccountpage.pressTabKey();
		
		log.info("Step-04: verify error message 'Customer ID is required' displayed");
		verifyEquals(newAccountpage.getErrorMessageCustomerId(), "Customer ID is required");
	}
	@Test
	public void TC_02_Customer_Id_With_Character_Data() {
		
		log.info("Step-01: input to customer id with character data");
		newAccountpage.inputToCustomerIdTextbox("1234da");

		log.info("Step-02: verify error message'Characters are not allowed'displayed");
		verifyEquals(newAccountpage.getErrorMessageCustomerId(), "Characters are not allowed");
	}
	@Test
	public void TC_03_Customer_Id_With_Special_Character_Data() {
		
		log.info("Step-01: input to customer id with special character data");
		newAccountpage.inputToCustomerIdTextbox("13212c!");
		
		log.info("Step-03: verify error message 'Special characters are not allowed' displayed");
		verifyEquals(newAccountpage.getErrorMessageCustomerId(), "Special characters are not allowed");
	}
	@Test
	public void TC_04_Customer_Id_With_Have_Blank_Space_Data() {
		
		log.info("Step-01: input to customer id with have blank space data");
		newAccountpage.inputToCustomerIdTextbox("132 12");
		
		log.info("Step-02: verify error message 'Characters are not allowed' displayed");
		verifyEquals(newAccountpage.getErrorMessageCustomerId(), "Characters are not allowed");
	}
	@Test
	public void TC_05_Customer_Id_With_First_Character_Is_Space_Data() {
		
		log.info("Step-01: input to Initial deposit with first character space data");
		newAccountpage.inputToCustomerIdTextbox(" ");
		
		log.info("Step-02: verify error message 'First character can not have space");
		verifyEquals(newAccountpage.getErrorMessageCustomerId(), "First character can not have space");
	}
	@Test
	public void TC_06_Initial_deposit_With_Empty_Data() {
		
		log.info("Step-01: input to Initial deposit with empty data");
		newAccountpage.inputToInitialDepositTextbox("");
		
		log.info("Step-02: press key tab");
		newAccountpage.pressTabKey();
		
		log.info("Step-03: verify error message 'Initial Deposit must not be blank");
		verifyEquals(newAccountpage.getErrorMessageInitialDeposit(), "Initial Deposit must not be blank");
	}
	@Test
	public void TC_07_Initial_deposit_With_Character_Data() {
		
		log.info("Step-01: input to Initial deposit with character data");
		newAccountpage.inputToInitialDepositTextbox("123d");
		
		log.info("Step-02: verify error message 'Characters are not allowed");
		verifyEquals(newAccountpage.getErrorMessageInitialDeposit(), "Characters are not allowed");
	}
	@Test
	public void TC_08_Initial_deposit_With_Special_Character_Data() {
		
		log.info("Step-01: input to Initial deposit with special character data");
		newAccountpage.inputToInitialDepositTextbox("123!");
		
		log.info("Step-02: verify error message 'Special characters are not allowed");
		verifyEquals(newAccountpage.getErrorMessageInitialDeposit(), "Special characters are not allowed");
	}
	@Test
	public void TC_09_Initial_deposit_With_Have_Blank_Space_Data() {
		
		log.info("Step-01: input to Initial deposit with have blank space data");
		newAccountpage.inputToInitialDepositTextbox("123!");
		
		log.info("Step-02: verify error message 'Special characters are not allowed");
		verifyEquals(newAccountpage.getErrorMessageInitialDeposit(), "Special characters are not allowed");
	}
	@Test
	public void TC_10_Initial_deposit_With_First_Character_Is_Space_Data() {
		
		log.info("Step-01: input to Initial deposit with first character space data");
		newAccountpage.inputToInitialDepositTextbox(" ");
		
		log.info("Step-02: verify error message 'First character can not have space");
		verifyEquals(newAccountpage.getErrorMessageInitialDeposit(), "First character can not have space");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}




