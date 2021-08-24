package pageObjectUser;

import org.openqa.selenium.WebDriver;

public class PageGenerator {
	
	public static CommonLoginPagePO getCommonLoginPage(WebDriver driver) {
		return new CommonLoginPagePO(driver);
	}
	public static UserManagerPagePO getManagerPage(WebDriver driver) {
		return new UserManagerPagePO(driver);
	}
	public static UserNewAccountPagePO getNewAccountPage(WebDriver driver) {
		return new UserNewAccountPagePO(driver);
	}
	public static UserNewCustomerPagePO getNewCustomerPage(WebDriver driver) {
		return new UserNewCustomerPagePO(driver);
	}
	public static UserEditCustomerPagePO getEditCustomerPage(WebDriver driver) {
		return new UserEditCustomerPagePO(driver);
	}
	public static UserDeleteCustomerPagePO getDeleteCustomerPage(WebDriver driver) {
		return new UserDeleteCustomerPagePO(driver);
	}
	public static UserDeleteAccountPagePO getDeleteAccountPage(WebDriver driver) {
		return new UserDeleteAccountPagePO(driver);
	}
	public static UserEditAccountPagePO getEditAccountPage(WebDriver driver) {
		return new UserEditAccountPagePO(driver);
	}
	public static UserMiniStatementPagePO getMiniStatementPage(WebDriver driver) {
		return new UserMiniStatementPagePO(driver) ;
	}
	public static UserChangePasswordPagePO getChangePasswordPage(WebDriver driver) {
		return new UserChangePasswordPagePO(driver);
	}
	public static UserFundTransferPagePO getFundTransferPage(WebDriver driver) {
		return new UserFundTransferPagePO(driver);
	}
	public static UserCustomisedStatementPagePO getCustomisedStatmentPage(WebDriver driver) {
		return new UserCustomisedStatementPagePO(driver);
	}
}
