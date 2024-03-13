package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoAlertPage extends Page{
    public By lbBody = By.xpath("//body");

    public DemoAlertPage(WebDriver dr) {
        super(dr);
    }
}
