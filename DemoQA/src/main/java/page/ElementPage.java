package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementPage extends Page {
    public ElementPage(WebDriver dr) {
        super(dr);
    }

    public TextBoxPage clickTextBox() {
        driverWeb.findElement(By.xpath("//span[text()='Text Box']")).click();
        return new TextBoxPage(driverWeb);
    }

    public CheckBoxPage clickCheckBox() {
        driverWeb.findElement( By.xpath("//span[text()='Check Box']")).click();
        return new CheckBoxPage(driverWeb);
    }

    public WebTablesPage clickWebTable() {
        driverWeb.findElement(By.xpath("//span[text()='Web Tables']")).click();
        return new WebTablesPage(driverWeb);
    }


}
