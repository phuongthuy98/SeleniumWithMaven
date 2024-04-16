package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertFrameWindowPage extends Page{

    By lblBrowserWindows = By.xpath("//span[text()='Browser Windows']");
    By lblAlerts = By.xpath("//span[text()='Alerts']");
    By lblFrames = By.xpath("//span[text()='Frames']");
    By lblModalDialogs = By.xpath("//span[text()='Modal Dialogs']");
    public BrowserWindowsPage clickBrowserWindowMenu() {
        driverWeb.findElement(lblBrowserWindows).click();
        return new BrowserWindowsPage(driverWeb);
    }

    /*public Page clickAlertsMenu() {
        driverWeb.findElement(lblAlerts).click();
        return new Page(driverWeb);
    }*/

    public AlertsPage clickAlertsMenu() {
        driverWeb.findElement(lblAlerts).click();
        return new AlertsPage(driverWeb);
    }

    public FramesPage clickFramesMenu() {
        driverWeb.findElement(lblFrames).click();
        return new FramesPage(driverWeb);
    }

    public ModalDialogsPage clickModalDialogsMenu() {
        driverWeb.findElement(lblModalDialogs).click();
        return new ModalDialogsPage(driverWeb);
    }

    public AlertFrameWindowPage(WebDriver dr) {
        super(dr);
    }
}
