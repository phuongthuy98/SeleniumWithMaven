package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TabsPage extends Page{
    public By tabWhat = By.id("demo-tab-what");
    public By tabOrigin = By.id("demo-tab-origin");
    public By tabUse = By.id("demo-tab-use");
    public By tabMore = By.id("demo-tab-more");
    public By txtWhat = By.xpath("//*[@id='demo-tabpane-what']//descendant::p");
    public By txtOrigin = By.xpath("//*[@id='demo-tabpane-origin']//descendant::p");
    public By txtUse = By.xpath("//*[@id='demo-tabpane-use']//descendant::p");
    public TabsPage(WebDriver dr) {
        super(dr);
    }
}
