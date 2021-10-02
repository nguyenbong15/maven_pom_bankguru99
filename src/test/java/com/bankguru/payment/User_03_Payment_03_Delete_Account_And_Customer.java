package com.bankguru.payment;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbtractTest;
import pageObjectUser.CommonLoginPagePO;
import pageObjectUser.PageGenerator;
import pageObjectUser.UserDeleteAccountPagePO;
import pageObjectUser.UserDeleteCustomerPagePO;
import pageObjectUser.UserEditAccountPagePO;
import pageObjectUser.UserEditCustomerPagePO;
import pageObjectUser.UserManagerPagePO;

public class User_03_Payment_03_Delete_Account_And_Customer extends AbtractTest {
	WebDriver driver;
	CommonLoginPagePO loginPage;
	UserManagerPagePO managerPage;
	UserDeleteAccountPagePO deletepage;
	UserDeleteCustomerPagePO deleteCustomerPage;
	UserEditAccountPagePO editpage;
	UserEditCustomerPagePO editCustomerPage;
	String customerid, accountId, accountPayees;
	

	@Parameters(value = { "browser", "url" })
	@BeforeClass
	public void beforeClass(String brower, String url) {
		driver = getBrowserName(brower, url);
		loginPage = PageGenerator.getCommonLoginPage(driver);
//		managerPage=loginPage.loginToSystem(Common_01_Login_Page.userid,Common_01_Login_Page.password);
		managerPage = loginPage.loginToSystem("mngr354393", "ubynuqy");

		customerid = User_01_Payment_01_Create_And_Edit_Customer_And_Account.customerid;
		accountId = User_01_Payment_01_Create_And_Edit_Customer_And_Account.accountId;
		accountPayees=User_02_Payment_02_Transfer_Money.accountPayees;
	}

	@Test
	public void TC_01_Delete_All_Account_Of_This_Customer() {
		log.info("Step-01: open delete account page");
		deletepage = managerPage.openDeleteAccountPage(driver);

		log.info("Step-02: input to account id textbox");
		deletepage.inputToAccountNoTextbox(accountId);

		log.info("Step-03: click to submit button");
		deletepage.clickToSubmitButton();

		log.info("Step-04: accept alert ");
		deletepage.accepAlert(driver);

		log.info("Step-05: verify text alert 'Account Deleted Sucessfully'");
		verifyEquals(deletepage.getTextAlert(driver), "Account Deleted Sucessfully");

		log.info("Step-06: accept alert ");
		deletepage.accepAlert(driver);
        deletepage.openDeleteAccountPage(driver);
		
		log.info("Step-07: input to account id textbox");
		deletepage.inputToAccountNoTextbox(accountPayees);

		log.info("Step-08: click to submit button");
		deletepage.clickToSubmitButton();

		log.info("Step-09: accept alert ");
		deletepage.accepAlert(driver);

		log.info("Step-10: verify text alert 'Account Deleted Sucessfully'");
		verifyEquals(deletepage.getTextAlert(driver), "Account Deleted Sucessfully");

		log.info("Step-11: accept alert ");
		deletepage.accepAlert(driver);

		log.info("Step-12: open edit account page");
		editpage = deletepage.openEditAccountPage(driver);

		log.info("Step-13: input to account id textbox");
		editpage.inputToAccountNoTextbox(accountId);
		
		log.info("Step-14: click to submit button");
		editpage.clickToSubmitButton();
		
		log.info("Step-15: verify text alter 'Account does not exist'");
		verifyEquals(editpage.getTextAlert(driver), "Account does not exist");
		
		log.info("Step-16: accept alert ");
		editpage.accepAlert(driver);
		
		log.info("Step-17: input to account id textbox");
		editpage.inputToAccountNoTextbox(accountPayees);

		log.info("Step-18: click to submit button");
		editpage.clickToSubmitButton();
		
		log.info("Step-19: verify text alter 'Account does not exist'");
		verifyEquals(editpage.getTextAlert(driver), "Account does not exist");
		
		log.info("Step-20: accept alert ");
		editpage.accepAlert(driver);

	}

	@Test
	public void TC_02_Delete_Account_Customer() {
		log.info("Step-01: open delete customer page");
		deleteCustomerPage = editpage.openDeleteCustomerPage(driver);

		log.info("Step-02: input to customer id textbox");
		deleteCustomerPage.inputToCustomerID(customerid);

		log.info("Step-03: click to submit button");
		deleteCustomerPage.clickToSubmitButton();

		log.info("Step-04: accept alert ");
		deleteCustomerPage.accepAlert(driver);

		log.info("Step-05: verify text alert 'Customer deleted Successfully'");
		verifyEquals(deleteCustomerPage.getTextAlert(driver), "Customer deleted Successfully");

		log.info("Step-06: accept alert ");
		deleteCustomerPage.accepAlert(driver);

		log.info("Step-07: open edit customer page");
		editCustomerPage = deleteCustomerPage.openEditCustomerPage(driver);

		log.info("Step-08: input to customer id textbox");
		editCustomerPage.inputToCustomerID(customerid);
		
		log.info("Step-09: click to submit button");
		editCustomerPage.clickToSubmitbutton();

		log.info("Step-10: verify text alter 'Customer does not exist!'");
		verifyEquals(editCustomerPage.getTextAlert(driver), "Customer does not exist!!");
		
		log.info("Step-11: accept alert ");
		editCustomerPage.accepAlert(driver);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
