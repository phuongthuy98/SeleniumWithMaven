package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccordianPage extends Page{

    public static By lbSection1 = By.id("section1Heading");
    public static By lbSection2 = By.id("section2Heading");
    public static By lbSection3 = By.id("section3Heading");

    public static By lbSection1Show = By.xpath("//div[@id='section1Heading']/following-sibling::div");
    public static By lbSection2Show = By.xpath("//div[@id='section2Heading']/following-sibling::div");
    public static By lbSection3Show = By.xpath("//div[@id='section3Heading']/following-sibling::div");

    public static By txtSection1 = By.xpath("//div[@id='section1Content']/p");
    public static By txtSection2 = By.xpath("//div[@id='section2Content']/p");
    public static By txtSection3 = By.xpath("//div[@id='section3Content']/p");


    public AccordianPage(WebDriver dr) {
        super(dr);
    }
}
