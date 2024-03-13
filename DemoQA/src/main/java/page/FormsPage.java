package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormsPage extends Page{

    public PracticeFormPage clickPracticeForm() {
        driverWeb.findElement(By.xpath("//span[text()='Practice Form']")).click();
        //driverWeb.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']")).click();
        return new PracticeFormPage(driverWeb);
    }

    public FormsPage(WebDriver dr) {
        super(dr);
    }
}
