package common;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class AbtractPage {
///
	public void openUrl(WebDriver driver, String url) {
		driver.get(url);
	}
	public String getTitlePage(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getSoucrePage(WebDriver driver) {
		return driver.getPageSource();
	}
	
	public String getCurrentUrlPage(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	public void backToPage(WebDriver driver){
		driver.navigate().back();
	}
	public void fowardToPage(WebDriver driver){
		driver.navigate().forward();;
	}
	public void refreshCurrentPage(WebDriver driver){
		driver.navigate().refresh();
	}
	
	public void accepAlert(WebDriver driver){
		driver.switchTo().alert().accept();
	}
	public void cancelccepAlert(WebDriver driver){
		driver.switchTo().alert().dismiss();
	}
	public String getTextAlert(WebDriver driver){
		return driver.switchTo().alert().getText();
	}
	public void setTextAlert(WebDriver driver,String value){
		driver.switchTo().alert().sendKeys(value);
	}
	
	public void waitAlertPresence(WebDriver driver){
		explicit= new WebDriverWait(driver, GlobalConsarts.LONG_TIMEOUT);
		explicit.until(ExpectedConditions.alertIsPresent());	
	}
	public void switchToWindownByID(WebDriver driver,String parentID){
		Set<String> allWindown=driver.getWindowHandles();
		for (String runWidown : allWindown) {
			if(!runWidown.equals(parentID)) {
				driver.switchTo().window(runWidown);
				break;
			}
		}
	}
	public void switchToWindownByTitle(WebDriver driver,String title){
		Set<String> allWindown=driver.getWindowHandles();
		for (String runWidown : allWindown) {
			driver.switchTo().window(runWidown);
			String titleCurrentWindown=driver.getTitle();
			if(!titleCurrentWindown.equals(title)) {			
				break;
			}
		}
	}
	
	public boolean closeAllWindownWithoutParentWin(WebDriver driver,String parentPage){
		Set<String> allWindown=driver.getWindowHandles();
		for (String runWidown : allWindown) {		
			if(!runWidown.equals(parentPage)) {	
				driver.switchTo().window(runWidown);		
				driver.close();
			}		
		}
		driver.switchTo().window(parentPage);
		if(driver.getWindowHandles().size()==1)
			return true;
		else
			return false;
	}
	public By getXpath(String locator) {
		return By.xpath(locator);
	}
	public WebElement getElement(WebDriver driver,String locator) {
		return driver.findElement(getXpath(locator));
	}
	public List<WebElement> getElements(WebDriver driver,String locator) {
		return  driver.findElements(getXpath(locator));
	}
	public void clickToElement(WebDriver driver,String locator) {
		highlightElement(driver, locator);	
		getElement(driver, locator).click();
	}
	public void senkeyToElement(WebDriver driver,String locator,String values) {
		highlightElement(driver, locator);	
		element=getElement(driver, locator);
		element.clear();
		sleepMiliSecond(500);
		element.sendKeys(values);
	}
	public String getTextElement(WebDriver driver,String locator) {
		highlightElement(driver, locator);
		element=getElement(driver, locator);
		return element.getText();
	}
	
	public void selectItemInDropdown(WebDriver driver,String locator,String value) {
		highlightElement(driver, locator);
		element=getElement(driver, locator);
		select=new Select(element);
		select.selectByVisibleText(value);		
	}
	public String getFirstSelectedTextInDropdown(WebDriver driver,String locator) {
		highlightElement(driver, locator);
		element=getElement(driver, locator);
		select=new Select(element);
	    return select.getFirstSelectedOption().getText();		
	}
	public boolean isDropdownMutiple(WebDriver driver,String locator) {
		highlightElement(driver, locator);
		element=getElement(driver, locator);
		select=new Select(element);
	    return select.isMultiple();
	}
	public void selectItemInCustomDropdown(WebDriver driver,String parentlocator,String chilLocator,String vlaueExpected) {
		highlightElement(driver, parentlocator);
		explicit=new WebDriverWait(driver, GlobalConsarts.LONG_TIMEOUT);
		element=getElement(driver, parentlocator);
		element.click();
		explicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getXpath(chilLocator)));
		elements=getElements(driver, parentlocator);
		for (WebElement x : elements) {
			if(x.getText().equals(vlaueExpected)) {
				js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", x);
				sleepSecond(1);
				x.click();
				sleepMiliSecond(500);
				break;
			}
		}	
	}
	public String getAttributeElement(WebDriver driver, String locator,String nameAttribute) {
		highlightElement(driver, locator);
		return getElement(driver, locator).getAttribute(nameAttribute);
	}
	public int countElementSize(WebDriver driver, String locator) {
		highlightElement(driver, locator);
		return getElements(driver, locator).size();
	}
	public void checkToCheckbox(WebDriver driver,String locator) {
		highlightElement(driver, locator);
		element=getElement(driver, locator);
		if(!element.isSelected()) {
			element.click();
		}
	}
	public void uncheckToCheckbox(WebDriver driver,String locator) {
		highlightElement(driver, locator);
		element=getElement(driver, locator);
		if(element.isSelected()) {
			element.click();
		}
	}
	///
	public boolean isElementDisplayed(WebDriver driver,String locator) {
		highlightElement(driver, locator);
		return getElement(driver, locator).isDisplayed();
	}
	public boolean isElementEnable(WebDriver driver,String locator) {
		highlightElement(driver, locator);
		return getElement(driver, locator).isEnabled();
	}
	public boolean isElementSelected(WebDriver driver,String locator) {
		highlightElement(driver, locator);
		return getElement(driver, locator).isSelected();
	}
	
	public void switchToFrame(WebDriver driver,String locator) {
		driver.switchTo().frame(getElement(driver, locator));
	}
	
	public void switchToDefaulContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void doubleClickToElement(WebDriver driver,String locator) {
		actions=new Actions(driver);
		actions.doubleClick(getElement(driver, locator)).perform();
	}
	
	public void rightClickToElement(WebDriver driver,String locator) {
		actions=new Actions(driver);
		actions.contextClick(getElement(driver, locator)).perform();
	}
	public void hoverMouseToElement(WebDriver driver,String locator) {
		actions=new Actions(driver);
		actions.moveToElement(getElement(driver, locator)).perform();
	}
	public void clickAndHoverToElement(WebDriver driver,String locator) {
		actions=new Actions(driver);
		actions.clickAndHold(getElement(driver, locator)).perform();
	}
	public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
		actions = new Actions(driver);
		actions.dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();

	}
	
	

	public Object excecutorForBrower(String javaScript, WebDriver driver) {
		js = (JavascriptExecutor) driver;
		return js.executeScript(javaScript);
	}

	public void scrollToElement( WebDriver driver,String locator) {
		js = (JavascriptExecutor) driver;
		element = getElement(driver, locator);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public boolean verifyTextInInnerText(String textExpected, WebDriver driver) {
		js = (JavascriptExecutor) driver;
		String textActual = (String) js.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		System.out.println("Text actual =" + textActual);
		return textActual.equals(textExpected);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		js = (JavascriptExecutor) driver;
		element = getElement(driver, locator);
		js.executeScript("arguments[0].click();", element);
	}

	public void sendkeyToElementByJS(String locator, String value, WebDriver driver) {
		js = (JavascriptExecutor) driver;
		element = getElement(driver, locator);
		js.executeScript("arguments[0].setAttribute('value','" + value + "')", element);
	}

	public void scrollToBottomPage(WebDriver driver) {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void removeAttributeInDom(String attributeRemove, WebDriver driver, String locator) {
		js = (JavascriptExecutor) driver;
		element = getElement(driver, locator);
		js.executeScript("arguments[0].removeAttribute('" + attributeRemove + "'", element);
	}

	public void navigateToUrlByJS(String url, WebDriver driver) {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.location='" + url + "'");
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {

		js = (JavascriptExecutor) driver;
		element = getElement(driver, locator);
		element = getElement(driver, locator);
		boolean status = (boolean) js.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				element);
		if (status) {
			return true;
		}
		return false;
	}
	public void highlightElement(WebDriver driver, String locator) {
		js = (JavascriptExecutor) driver;
		element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");

		js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element, "style",
				"border: 4px solid red; border-style: dashed;");
		sleepMiliSecond(500);
		js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element, "style", originalStyle);

	}
	public void waitToElementClickable(WebDriver driver,String locator) {
		explicit= new WebDriverWait(driver, GlobalConsarts.LONG_TIMEOUT);
		explicit.until(ExpectedConditions.elementToBeClickable(getXpath(locator)));
	}
	public void waitToElementVisible(WebDriver driver,String locator) {
		explicit= new WebDriverWait(driver, GlobalConsarts.LONG_TIMEOUT);
		explicit.until(ExpectedConditions.visibilityOfElementLocated(getXpath(locator)));
	}
	public void waitToAllElementVisible(WebDriver driver, String locator) {
		explicit = new WebDriverWait(driver, GlobalConsarts.LONG_TIMEOUT);
		explicit.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getXpath(locator)));
		
	}

	public void waitToElementInVisible(WebDriver driver,String locator) {
		explicit= new WebDriverWait(driver, GlobalConsarts.LONG_TIMEOUT);
		explicit.until(ExpectedConditions.invisibilityOfElementLocated(getXpath(locator)));
	}	public void waitToElementInvisible(WebDriver driver, String locator) {
		explicit = new WebDriverWait(driver, GlobalConsarts.SHORT_TIMEOUT);
		overideImplicitWait(driver, GlobalConsarts.SHORT_TIMEOUT);
		explicit.until(ExpectedConditions.invisibilityOfElementLocated(getXpath(locator)));
		overideImplicitWait(driver, GlobalConsarts.LONG_TIMEOUT);
	}
	public void waitToElementPresent(WebDriver driver, String locator,int number) {
		explicit = new WebDriverWait(driver, GlobalConsarts.LONG_TIMEOUT);
		explicit.until(ExpectedConditions.numberOfElementsToBe(getXpath(locator),number));

	}
	public void overideImplicitWait(WebDriver driver,long timeSecond) {
		driver.manage().timeouts().implicitlyWait(timeSecond, TimeUnit.SECONDS);
	}
	public String getDynammicLocator(String locator,String... values) {
		locator = String.format(locator, (Object[]) values);
		return locator;
	}
	public void sleepSecond(long time) {
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void sleepMiliSecond(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private WebDriverWait explicit;
	private JavascriptExecutor js;
	private WebElement element;
	private List<WebElement> elements;
	private Select select;
	private Actions actions;
	

	
}
