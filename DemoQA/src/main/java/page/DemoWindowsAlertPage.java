package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoWindowsAlertPage extends Page{
    public By lbBody = By.xpath("//body");

    public DemoWindowsAlertPage(WebDriver dr) {
        super(dr);
    }
}
