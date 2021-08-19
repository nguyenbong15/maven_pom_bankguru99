package pageObjectUser;

import org.openqa.selenium.WebDriver;

public class PageGenerator {
	
	public static CommonLoginPagePO getCommonLoginPage(WebDriver driver) {
		return new CommonLoginPagePO(driver);
	}
}
