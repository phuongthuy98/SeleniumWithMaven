package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowserWindowsPage extends Page{
    public By btnTab = By.id("tabButton");
    public By btnNewWindow = By.id("windowButton");
    public By btnNewWindowMessage = By.id("messageWindowButton");
    public BrowserWindowsPage(WebDriver dr) {
        super(dr);
    }
    public DemoSamplePage clickNewTab() {
        testBase.switchNewWindowByClick(btnTab,timeout_Short);
        return new DemoSamplePage(driverWeb);
    }

    public DemoSamplePage clickNewWindow() {
        testBase.switchNewWindowByClick(btnNewWindow,timeout_Short);
        return new DemoSamplePage(driverWeb);
    }


    public DemoWindowsAlertPage clickNewWindowMessage() {
        System.out.println("Start click");
        testBase.switchNewWindowByClick(btnNewWindowMessage,timeout_Short);
        return new DemoWindowsAlertPage(driverWeb);
    }

}
