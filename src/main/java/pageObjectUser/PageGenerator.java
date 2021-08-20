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
}
