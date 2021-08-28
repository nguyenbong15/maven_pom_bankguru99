package com.bankguru.users;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbtractTest;
import pageObjectUser.CommonLoginPagePO;
import pageObjectUser.PageGenerator;
import pageObjectUser.UserEditAccountPagePO;
import pageObjectUser.UserEditCustomerPagePO;
import pageObjectUser.UserManagerPagePO;
import pageObjectUser.UserNewAccountPagePO;
import pageObjectUser.UserNewCustomerPagePO;

public class User_12_Payment_01_Create_And_Edit_Customer_And_Account extends AbtractTest{
    WebDriver driver;
    CommonLoginPagePO loginPage;
    UserManagerPagePO managerPage;
	UserNewCustomerPagePO newCustomer;
	UserEditCustomerPagePO editCustomer;
	UserNewAccountPagePO newAccount;
	UserEditAccountPagePO editAccount;
	String dateOfBirth,customername,address,city,state,pin,phoneNumber,password,email,customerid;
	String editdateOfBirth,editcustomername,editaddress,editcity,editstate,editpin,editphoneNumber
	,editpassword,editemail;
	String initialDeposit,accountId;
	@Parameters(value= {"browser","url"})
	@BeforeClass
	public void beforeClass(String brower,String url) {
		driver = getBrowserName(brower, url);
		loginPage=PageGenerator.getCommonLoginPage(driver);
//		managerPage=loginPage.loginToSystem(Common_01_Login_Page.userid,Common_01_Login_Page.password);
		managerPage=loginPage.loginToSystem("mngr348463","nUsajEh");
		customername="Petter";
	    dateOfBirth="01/01/2000";
	    address="12HoangTrung";
	    city="New York";
	    state="England";
	    pin="123456";
	    phoneNumber="09876543";
	    email="petter"+getRandomNumber()+"@gmail.com";
	    password="123456";
	    
	    editdateOfBirth="02/02/2000";
	    editcustomername="Nam";
	    editaddress="12 Cau Giay";
	    editcity="Ha Noi";
	    editstate="Viet Nam";
	    editpin="234567";
	    editphoneNumber="09865234";
	    editpassword="234567";
	    editemail="Nam@gmail.com";
	    
	    initialDeposit="50000";
	    customerid="69888";
	    accountId="96313";
	}

	@Test
	public void TC_01_Create_New_Customer_And_Verify() {
		log.info("Step-01: open new customer page");
		newCustomer=managerPage.openNewCustomerPage(driver);
		
		log.info("Step-02: input to customer name textbox");
		newCustomer.inputToCustomerName(customername);
		
		log.info("Step-03: click to  gender male radio button");
		newCustomer.clickToGenderMaleRadio();
		
		log.info("Step-04: input to day of birth textbox");
		newCustomer.inputToDateOfBirth(dateOfBirth);
		
		log.info("Step-05: input to address textbox");
		newCustomer.inputToAddressTextbox(address);
		
		log.info("Step-06: input to city textbox");
		newCustomer.inputToCityTextbox(city);
		
		log.info("Step-07: input to state textbox");
		newCustomer.inputToStateTextBox(state);
		
		log.info("Step-08: input to pin textbox");
		newCustomer.inputToPinTextbox(pin);
		
		log.info("Step-09: input to mobile number textbox");
		newCustomer.inputToMobilePhoneTextbox(phoneNumber);
		
		log.info("Step-10: input to password textbox");
		newCustomer.inputToEmailTextbox(email);
		
		log.info("Step-11: input to password textbox");
		newCustomer.inputToPasswordTextbox(password);
		
		log.info("Step-12: click to submit button");
		newCustomer.clickToSubmitbutton();
		
		log.info("Step-13: get Text customer id");
		customerid=newCustomer.getCustomerId();
		System.out.println(customerid);
		
		log.info("Step-14: verify text 'Customer Registered Successfully!!!' displayed");
		verifyEquals(newCustomer.getTextMeassageSuccess(), "Customer Registered Successfully!!!");
		
		log.info("Step-15: verify customer name");
		verifyEquals(newCustomer.getTextCustomerName(), customername);
		
		log.info("Step-16: verify gender male");
		verifyEquals(newCustomer.getTextGender(),"male");
		
		log.info("Step-17: verify address");
		verifyEquals(newCustomer.getTextAddress(), address);
		
		log.info("Step-18: verify city");
		verifyEquals(newCustomer.getTextCity(), city);
		
		log.info("Step-19: verify state");
		verifyEquals(newCustomer.getTextState(), state);
		
		log.info("Step-20: verify pin");
		verifyEquals(newCustomer.getTextPin(), pin);
		
		log.info("Step-21: verify mobile number");
		verifyEquals(newCustomer.getTextPhoneNumber(), phoneNumber);
		
		log.info("Step-22: verify mobile number");
		verifyEquals(newCustomer.getTextEmail(), email);
		
		
	}
	
	@Test(dependsOnMethods = "TC_01_Create_New_Customer_And_Verify")
    public void TC_02_Edit_Customer_And_Verify() {
		log.info("Step-01: open edit customer page");
		editCustomer=newCustomer.openEditCustomerPage(driver);
		
		log.info("Step-02: input to customer id textbox");
		editCustomer.inputToCustomerID(customerid);
		
		log.info("Step-03: click to submit button");
		editCustomer.clickToSubmitButton();
		
		log.info("Step-04: edit custommer name textbox");
		editCustomer.inputToCustomerName(editcustomername);
		
		log.info("Step-05: edit date of birth textbox");
		editCustomer.inputToDateOfBirth(dateOfBirth);
		
		log.info("Step-06: edit address textbox");
		editCustomer.inputToAddressTextbox(address);
		
		log.info("Step-07: edit city textbox");
		editCustomer.inputToCityTextbox(city);
		
		log.info("Step-08: edit state textbox");
		editCustomer.inputToStateTextBox(editstate);
		
		log.info("Step-09: edit pin textbox");
		editCustomer.inputToPinTextbox(editpin);
		
		log.info("Step-10: edit mobile phone textbox");
		editCustomer.inputToMobilePhoneTextbox(editphoneNumber);
		
		log.info("Step-11: edit email textbox");
		editCustomer.inputToEmailTextbox(editemail);
		
		log.info("Step-12: click to submit button");
		editCustomer.clickToSubmitbutton();
		
		log.info("Step-13: verify customer name");
		verifyEquals(editCustomer.getTextCustomerName(), editcustomername);
		
		log.info("Step-14: verify gender male");
		verifyEquals(editCustomer.getTextGender(),"Male");
		
		log.info("Step-15: verify address");
		verifyEquals(editCustomer.getTextAddress(), editaddress);
		
		log.info("Step-16: verify city");
		verifyEquals(editCustomer.getTextCity(), editcity);
		
		log.info("Step-17: verify state");
		verifyEquals(editCustomer.getTextState(), editstate);
		
		log.info("Step-18: verify pin");
		verifyEquals(editCustomer.getTextPin(), editpin);
		
		log.info("Step-19: verify mobile number");
		verifyEquals(editCustomer.getTextPhoneNumber(), editphoneNumber);
		
		log.info("Step-20: verify email");
		verifyEquals(editCustomer.getTextEmail(), editemail);
	}
	
	@Test
    public void TC_03_New_Account_And_Verify() {
		
	  log.info("Step-01: open new account page");
	  newAccount=editCustomer.openNewAccountPage(driver);
	  
	  log.info("Step-02: input to Customer id texbox");
	  newAccount.inputToCustomerIdTextbox(customerid);
	  
	  log.info("Step-03: select item in Account type dropdown");
	  newAccount.selecItemInAccountTypeDropDown("Savings");
	  
	  log.info("Step-04: input to Initial deposit text box");
	  newAccount.inputToInitialDepositTextbox(initialDeposit);
	  
	  log.info("Step-05: click to submit button");
	  newAccount.clickToSubmitButton();
	
	  log.info("Step-06: verify message success 'Account Generated Successfully!!!' displayed");
	  verifyEquals(newAccount.getMessageSuccess(), "Account Generated Successfully!!!");
	  
	  log.info("Step-07: verify text  Current Amount equal initial Deposit");
	  verifyEquals(newAccount.getAmountDeposit(), initialDeposit);
	  
	  log.info("Step-08: get text account id");
	  accountId=newAccount.getTextAccountID();
	  System.out.println(accountId);
	}
	
	@Test
	public void TC_04_Edit_Account_And_Verify() {
		log.info("Step-01: open edit account page");
		editAccount=newAccount.openEditAccountPage(driver);
		
		log.info("Step-02: input to account no textbox");
		editAccount.inputToAccountNoTextbox(accountId);
		
		log.info("Step-03: click to submit button ");
		editAccount.clickToSubmitButton();
		
		log.info("Step-04: edit choose diffrent item in account type dropdown ");
		editAccount.selectItemInAccountTypeDropdown("Current");
		
		log.info("Step-05: click to submit button");
		editAccount.clickToSubmitButton();
		
		log.info("Step-06: verify account type is 'Current'");
		verifyEquals(editAccount.getTextAccountType(), "Current");
	}
	
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
