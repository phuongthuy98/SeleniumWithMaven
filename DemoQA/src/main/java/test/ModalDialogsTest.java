package test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import page.AlertFrameWindowPage;
import page.HomePage;

import static org.testng.Assert.assertTrue;

public class ModalDialogsTest extends TestCase{
    public By btnSmallModal = By.id("showSmallModal");
    public By btnLargeModal = By.id("showLargeModal");
    public By btnCloseSmallModal = By.id("closeSmallModal");
    public By smallModalClass = By.xpath("//div[@class='modal-dialog modal-sm']");
    public By largeModalClass = By.xpath("//div[@class='modal-dialog modal-lg']");

    @Test
    public void verifyDisplayModal() {
        HomePage homePage = new HomePage(testBase.driver);
        testBase.scrollToEndPage();
        AlertFrameWindowPage alertFrameWindowPage = homePage.clickAlertFrameWindow();
        testBase.scrollToEndPage();
        alertFrameWindowPage.clickModalDialogsMenu();
        //open small modal
        testBase.clickByLocator(btnSmallModal);

        String actualSmallModalClass = testBase.getValueOfAttribute(smallModalClass, "class");
        assertTrue(actualSmallModalClass.contains("modal-sm"));

        //close small modal
        testBase.clickByLocator(btnCloseSmallModal);
        //Open large modal
        testBase.clickByLocator(btnLargeModal);

        String actualLargeModalClass = testBase.getValueOfAttribute(largeModalClass, "class");
        assertTrue(actualLargeModalClass.contains("modal-lg"));

    }
}
