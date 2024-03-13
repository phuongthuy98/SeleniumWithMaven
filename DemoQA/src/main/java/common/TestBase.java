package common;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collection;

public class TestBase {
	public WebDriver driver;
	public void openBrowser(String url) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver");
		driver = new ChromeDriver();
		//G� URL
		//driver.get("https://demoqa.com/");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		//maximize man hinh
		driver.manage().window().maximize();
	}
	//Scroll to end page
	public void scrollToEndPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	/**
	 * Kiem tra element hien thi => click
	 * @param locator
	 * @param timeBySecond
	 */
	public void clickToElement(By locator, int timeBySecond){
		WebElement e = driver.findElement(locator);
		waitForElementDisplayed(e, timeBySecond);
		if(e.isDisplayed()){
			e.click();
		} else {
			System.out.println("Element not found after" + timeBySecond + "seconds.");
		}
	}
	/**
	 * wait for element displayed
	 *@param timeBySecond;
	 */
	public void waitForElementDisplayed(WebElement element, int timeBySecond){
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(d -> element.isDisplayed());
	}

	/**
	 * Input to textbox
	 * @param locator
	 * @param text
	 */

	public void inputText(By locator, String text, int timeBySecond) {
		WebElement e = driver.findElement(locator);
		waitForElementDisplayed(e, timeBySecond);
		if(e.isDisplayed()){
			e.sendKeys(text);
		} else {
			System.out.println("Element not found after" + timeBySecond + "seconds.");
		}
		// driver.findElement(locator).sendKeys(text);
	}

	public void keysEnter(By locator) {
		driver.findElement(locator).sendKeys(Keys.ENTER);
	}

	public void zoomOut() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom = '50%';");
	}

	public String getText(By locator, int timeBySecond) {
		String result="";
		WebElement e = driver.findElement(locator);
		waitForElementDisplayed(e, timeBySecond);
		if (e.isDisplayed()) {
			result = e.getText();
		} else {
			System.out.println("Element not found after" + timeBySecond + "seconds.");
		}
		return result;
	}

	public void switchNewWindowByClick(By locator, int timeBySecond){
		String originalWindow = driver.getWindowHandle();

		clickToElement(locator,timeBySecond);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeBySecond));

		for (String windowHandle : driver.getWindowHandles()) {
			if(!originalWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

	}

	public void quitBrowser() {
		driver.quit(); // đóng toàn bộ tab
	}

	public void closeBrowser() {
		driver.close();
	}

	//hàm lấy giá trị attribute
	public String getValueOfAttribute(By locator,String attributeName) {
		String result="";
		result= driver.findElement(locator).getAttribute(attributeName);
		return result;
	}

}
