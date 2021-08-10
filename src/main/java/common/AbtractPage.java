package common;

import org.openqa.selenium.WebDriver;

public class AbtractPage {

	public void openUrl(WebDriver driver, String url) {
		driver.get("https://demo.nopcommerce.com");
	}

	
}
