package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page {
    public By lblElement = By.xpath("//h5[text()='Elements']");
    public By lblForms = By.xpath("//h5[text()='Forms']");
    public By lblAlertFrameWindow = By.xpath("//h5[text()='Alerts, Frame & Windows']");
    public By lblWidgets = By.xpath("//h5[text()='Widgets']");

    public HomePage(WebDriver dr) {
        super(dr);
    }

    //click on Elements
    public ElementPage clickElement() {
        testBase.clickToElement(lblElement,timeout_Short);
        return new ElementPage(driverWeb);
    }

    public FormsPage clickForms() {
        testBase.clickToElement(lblForms,timeout_Short);
        return new FormsPage(driverWeb);
    }

    public AlertFrameWindowPage clickAlertFrameWindow() {
        testBase.scrollToEndPage();
        testBase.clickToElement(lblAlertFrameWindow,timeout_Short);
        return new AlertFrameWindowPage(driverWeb);
    }

    public WidgetsPage clickWidgets() {
        testBase.scrollToEndPage();
        testBase.clickToElement(lblWidgets,timeout_Short);
        return new WidgetsPage(driverWeb);
    }
}
