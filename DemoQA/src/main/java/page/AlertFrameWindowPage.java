package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertFrameWindowPage extends Page{

    By lblBrowserWindows = By.xpath("//span[text()='Browser Windows']");
    public BrowserWindowsPage clickBrowserWindowMenu() {
        driverWeb.findElement(lblBrowserWindows).click();
        return new BrowserWindowsPage(driverWeb);
    }
    public AlertFrameWindowPage(WebDriver dr) {
        super(dr);
    }
}
