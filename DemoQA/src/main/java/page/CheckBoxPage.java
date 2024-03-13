package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBoxPage extends Page{
    public By chkHome = By.xpath("//label[@for='tree-node-home']/span[1]//*[name()='svg']");

    public CheckBoxPage(WebDriver dr) {
        super(dr);
    }

    public void clickCheckbox() {
        driverWeb.findElement(chkHome).click();
        driverWeb.findElement(By.xpath("//button[@class='rct-collapse rct-collapse-btn']")).click();
    }

    public String getActualHomeText() {
        String result = "";
        for(int i=1; i<=18;i++) {
            result=result + " " + driverWeb.findElement(By.xpath("//*[@id='result']/span["+ i +"]")).getText();
        }
        return result;
    }
}
