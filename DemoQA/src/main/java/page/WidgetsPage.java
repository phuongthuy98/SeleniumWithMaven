package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WidgetsPage extends Page{


    public AccordianPage clickAccordian() {
        driverWeb.findElement(By.xpath("//span[text()='Accordian']")).click();
        return new AccordianPage(driverWeb);
    }
    public WidgetsPage(WebDriver dr) {
        super(dr);
    }
}
