package com.bankguru.validate;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbtractTest;
import pageObjectUser.CommonLoginPagePO;
import pageObjectUser.PageGenerator;
import pageObjectUser.UserManagerPagePO;
import pageObjectUser.UserNewCustomerPagePO;

public class User_03_New_Customer_02_Verify extends AbtractTest {
	WebDriver driver;
    CommonLoginPagePO loginPage;
    UserNewCustomerPagePO newCustomer;
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
	public void TC_01_Pin_With_Empty_Data() {
		log.info("Step-01: open new customer page");
		newCustomer=managerPage.openNewCustomerPage(driver);
		
		log.info("Step-02: input to pin texbox with empty data");
		newCustomer.inputToPinTextbox("");
		
		log.info("Step-03: press key tab");
		newCustomer.pressTabKey();
		
		log.info("Step-04: verify error message 'PIN Code must not be blank' displayed");
		verifyEquals(newCustomer.getErrorMessageOfPin(), "PIN Code must not be blank");
	}
	@Test
	public void TC_02_Pin_With_Have_Character() {
		
		log.info("Step-01: input to pin texbox with  number character data");
		newCustomer.inputToPinTextbox("name12");
		
		log.info("Step-02: verify error message 'Characters are not allowed' displayed");
		verifyEquals(newCustomer.getErrorMessageOfPin(), "Characters are not allowed");
	}
	@Test
	public void TC_03_Pin_Have_To_Six_Digital() {
		
		log.info("Step-01: input to pin texbox with  less 6 digital");
		newCustomer.inputToPinTextbox("123");
		
		log.info("Step-02: verify error message 'PIN Code must have 6 Digits' displayed");
		verifyEquals(newCustomer.getErrorMessageOfPin(), "PIN Code must have 6 Digits");

	}
	@Test
	public void TC_04_Pin_With_First_Space_Character() {
	
		log.info("Step-01: input to pin texbox with  First space character data");
		newCustomer.inputToPinTextbox(" ");
	
		log.info("Step-02: verify error message 'First character can not have space' displayed");
		verifyEquals(newCustomer.getErrorMessageOfPin(), "First character can not have space");
	}
	
	@Test
	public void TC_05_Pin_With_Special_Characeter() {
		
		log.info("Step-01: input to pin texbox with special character");
		newCustomer.inputToPinTextbox("12!");
	
		log.info("Step-02: verify error message 'Special characters are not allowed");
		verifyEquals(newCustomer.getErrorMessageOfPin(), "Special characters are not allowed");
	}

	@Test
	public void TC_06_Pin_With_Have_Blank_Space() {
		
		log.info("Step-01: input to city textbox with special character");
		newCustomer.inputToPinTextbox("123 1");
		
		log.info("Step-02: verify error message 'Characters are not allowed");
		verifyEquals(newCustomer.getErrorMessageOfPin(), "Characters are not allowed");
	}
	
	@Test
	public void TC_07_Mobile_Number_With_Empty_Data() {
		
		log.info("Step-01: input to mobile phone textbox with empty data");
		newCustomer.inputToMobilePhoneTextbox("");
		
		log.info("Step-02: press key tab");
		newCustomer.pressTabKey();
		
		log.info("Step-03: verify error message 'Mobile no must not be blank");
		verifyEquals(newCustomer.getErrorMessageOfMobilePhone(), "Mobile no must not be blank");
	}
	
	@Test
	public void TC_08_Mobile_Number_With_First_Character_As_Space() {
		
		log.info("Step-01: input to mobile phone textbox with first character as space");
		newCustomer.inputToMobilePhoneTextbox(" ");
		
		log.info("Step-02: verify error message 'First character can not have space");
		verifyEquals(newCustomer.getErrorMessageOfMobilePhone(), "First character can not have space");
	}
	
	@Test
	public void TC_09_Mobile_Number_With_Have_Space() {
		
		log.info("Step-01: input to mobile phone textbox with have space");
		newCustomer.inputToMobilePhoneTextbox("123 123");
		
		log.info("Step-02: verify error message 'Characters are not allowed");
		verifyEquals(newCustomer.getErrorMessageOfMobilePhone(), "Characters are not allowed");
	}
	
	@Test
	public void TC_10_Mobile_Number_With_Have_Special_Character() {
		
		log.info("Step-01: input to mobile phone textbox with special character");
		newCustomer.inputToMobilePhoneTextbox("123!");
		
		log.info("Step-02: verify error message 'Special characters are not allowed");
		verifyEquals(newCustomer.getErrorMessageOfMobilePhone(), "Special characters are not allowed");
	}
	
	
	@Test
	public void TC_11_Email_With_empty_Data() {
		
		log.info("Step-01: input to email textbox with empty data");
		newCustomer.inputToEmailTextbox("");
		
		log.info("Step-02: press key tab");
		newCustomer.pressTabKey();
		
		log.info("Step-03: verify error message 'Email-ID must not be blank");
		verifyEquals(newCustomer.getErrorMessageOfEmail(), "Email-ID must not be blank");
	}
	
	@Test
	public void TC_12_Email_With_First_Character_As_Space() {
		
		log.info("Step-01: input to email textbox with first character as space");
		newCustomer.inputToEmailTextbox(" ");
		
		log.info("Step-02: verify error message 'First character can not have space");
		verifyEquals(newCustomer.getErrorMessageOfEmail(), "First character can not have space");
	}
	
	@Test
	public void TC_13_Email_With_Have_Space() {
		
		log.info("Step-01: input to email textbox with have space");
		newCustomer.inputToEmailTextbox("hai hoang");
		
		log.info("Step-02: verify error message 'Email-ID is not valid");
		verifyEquals(newCustomer.getErrorMessageOfEmail(), "Email-ID is not valid");
	}
	@Test
	public void TC_14_Email_With_Invail_Email() {
		
		log.info("Step-01: input to email textbox with have space");
		newCustomer.inputToEmailTextbox("hai");
		
		log.info("Step-02: verify error message 'Email-ID is not valid");
		verifyEquals(newCustomer.getErrorMessageOfEmail(), "Email-ID is not valid");
		
		log.info("Step-03: input to email textbox with have space");
		newCustomer.inputToEmailTextbox("hai@");
		
		log.info("Step-04: verify error message 'Email-ID is not valid");
		verifyEquals(newCustomer.getErrorMessageOfEmail(), "Email-ID is not valid");
		
		log.info("Step-05: input to email textbox with have space");
		newCustomer.inputToEmailTextbox("hai@gmail");
		
		log.info("Step-06: verify error message 'Email-ID is not valid");
		verifyEquals(newCustomer.getErrorMessageOfEmail(), "Email-ID is not valid");
		
		log.info("Step-07: input to email textbox with have space");
		newCustomer.inputToEmailTextbox("hai@gmail.");
		
		log.info("Step-08: verify error message 'Email-ID is not valid");
		verifyEquals(newCustomer.getErrorMessageOfEmail(), "Email-ID is not valid");
		log.info("Step-09: input to email textbox with have space");
		newCustomer.inputToEmailTextbox("hai@gmail.com");
		
		log.info("Step-10: verify error message not displayed");
		verifyFalse(newCustomer.isErrorMessagedisplayed());
	}
	
	
	
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}




