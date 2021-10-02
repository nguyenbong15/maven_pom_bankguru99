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

public class User_02_New_Customer_01_Verify extends AbtractTest {
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
	public void TC_01_Customer_Name_With_Empty_Data() {
		log.info("Step-01: open new customer page");
		newCustomer=managerPage.openNewCustomerPage(driver);
		
		log.info("Step-02: input to Customer Name with empty data");
		newCustomer.inputToCustomerName("");
		
		log.info("Step-03: press key tab");
		newCustomer.pressTabKey();
		
		log.info("Step-04: verify error message 'Customer name must not be blank' displayed");
		verifyEquals(newCustomer.getErrorMessageOfCustomerName(), "Customer name must not be blank");
	}
	@Test
	public void TC_02_Customer_Name_With_Number_Character_Data() {
		
		log.info("Step-01: input to Customer Name with number character data");
		newCustomer.inputToCustomerName("name12");
		
		log.info("Step-02: verify error message 'Numbers are not allowed' displayed");
		verifyEquals(newCustomer.getErrorMessageOfCustomerName(), "Numbers are not allowed");
	}
	@Test
	public void TC_03_Customer_Name_With_Special_Character_Data() {
		
		log.info("Step-01: input to Customer Name with special character data");
		newCustomer.inputToCustomerName("name!");
		
		log.info("Step-02: verify error message 'Special characters are not allowed' displayed");
		verifyEquals(newCustomer.getErrorMessageOfCustomerName(), "Special characters are not allowed");
	}
	@Test
	public void TC_04_Customer_Name_With_First_Space_Character_Data() {
	
		log.info("Step-01: input to Customer Name with First space character data");
		newCustomer.inputToCustomerName(" ");
	
		log.info("Step-02: verify error message 'First character can not have space' displayed");
		verifyEquals(newCustomer.getErrorMessageOfCustomerName(), "First character can not have space");
	}
	
	@Test
	public void TC_05_Address_With_Empty_Data() {
		
		log.info("Step-01: input to Address textbox with empty data");
		newCustomer.inputToAddressTextbox("");
		
		log.info("Step-02: press key tab");
		newCustomer.pressTabKey();
		
		log.info("Step-03: verify error message 'Address Field must not be blank' displayed");
		verifyEquals(newCustomer.getErrorMessageOfAddress(), "Address Field must not be blank");
	}
	@Test
	public void TC_06_Address_With_First_Characeter_IS_Space() {
		
		log.info("Step-01: input to Address textbox first character is space");
		newCustomer.inputToAddressTextbox(" ");

		log.info("Step-02: verify error message 'First character can not have space' displayed");
		verifyEquals(newCustomer.getErrorMessageOfAddress(), "First character can not have space");
	}
	@Test
	public void TC_07_Address_With_Special_Characeter() {
		
		log.info("Step-01: input to Address textbox special character");
		newCustomer.inputToAddressTextbox("12! QuangTrung");
	
		log.info("Step-02: verify error message 'Special characters are not allowed");
		verifyEquals(newCustomer.getErrorMessageOfAddress(), "Special characters are not allowed");
	}
	@Test
	public void TC_08_City_With_Empty_Data() {
		
		log.info("Step-01: input to city textbox with empty data");
		newCustomer.inputToCityTextbox("");
		
		log.info("Step-02: press key tab");
		newCustomer.pressTabKey();
		
		log.info("Step-03: verify error message 'City Field must not be blank' displayed");
		verifyEquals(newCustomer.getErrorMessageOfCity(), "City Field must not be blank");
	}
	@Test
	public void TC_09_City_With_First_Characeter_IS_Space() {
		
		log.info("Step-01: input to city textbox first character is space");
		newCustomer.inputToCityTextbox(" ");
		
		log.info("Step-02: verify error message 'First character can not have space");
		verifyEquals(newCustomer.getErrorMessageOfCity(), "First character can not have space");
	}
	@Test
	public void TC_10_City_With_Special_Characeter() {
		
		log.info("Step-01: input to city textbox special character");
		newCustomer.inputToCityTextbox("12!QuangTrung");
		
		log.info("Step-02: verify error message 'Special characters are not allowed");
		verifyEquals(newCustomer.getErrorMessageOfCity(), "Special characters are not allowed");
	}
	@Test
	public void TC_11_City_With_Have_Number_Characeter() {
		
		log.info("Step-01: input to city textbox with have number character");
		newCustomer.inputToCityTextbox("12VietNam");
		
		log.info("Step-02: verify error message 'Numbers are not allowed");
		verifyEquals(newCustomer.getErrorMessageOfCity(), "Numbers are not allowed");
	}
	@Test
	public void TC_12_State_With_Empty_Data() {
		
		log.info("Step-01: input to state textbox with empty data");
		newCustomer.inputToStateTextBox("");
		
		log.info("Step-02: press key Tab ");
		newCustomer.pressKeyTabStateFiled();
		
		log.info("Step-03: verify error message 'State must not be blank' displayed ");
		verifyEquals(newCustomer.getErrorMessageOfState(), "State must not be blank");
	}
	@Test
	public void TC_13_State_With_Number_Data() {
		
		log.info("Step-01: input to state textbox with number data");
		newCustomer.inputToStateTextBox("12a");
		
		log.info("Step-03: verify error message 'Numbers are not allowed' displayed ");
		verifyEquals(newCustomer.getErrorMessageOfState(), "Numbers are not allowed");
	}
	@Test
	public void TC_14_State_With_Special_Character() {
		
		log.info("Step-01: input to state textbox with special character");
		newCustomer.inputToStateTextBox("!aa");
		
		log.info("Step-03: verify error message 'Special characters are not allowed' displayed ");
		verifyEquals(newCustomer.getErrorMessageOfState(), "Special characters are not allowed");
	}
	@Test
	public void TC_15_State_With_First_Character_Space() {
		
		log.info("Step-01: input to state textbox with first character is space");
		newCustomer.inputToStateTextBox(" ");
		
		log.info("Step-03: verify error message 'First character can not have space' displayed ");
		verifyEquals(newCustomer.getErrorMessageOfState(), "First character can not have space");
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}




