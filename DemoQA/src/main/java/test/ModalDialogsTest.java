package test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import page.AlertFrameWindowPage;
import page.HomePage;
import page.ModalDialogsPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ModalDialogsTest extends TestCase{
    public By btnSmallModal = By.id("showSmallModal");
    public By btnLargeModal = By.id("showLargeModal");
    public By btnCloseSmallModal = By.id("closeSmallModal");
    public By smallModalClass = By.xpath("//div[@class='modal-dialog modal-sm']");
    public By largeModalClass = By.xpath("//div[@class='modal-dialog modal-lg']");
    public By txtBodyModal = By.xpath("//div[@class='modal-body']");

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
        String actualSmModal = testBase.getTextByLocator(txtBodyModal);
        String expectedSmModal = "This is a small modal. It has very less content";
        assertEquals(actualSmModal, expectedSmModal);

        //close small modal
        testBase.clickByLocator(btnCloseSmallModal);
        //Open large modal
        testBase.clickByLocator(btnLargeModal);

        String actualLargeModalClass = testBase.getValueOfAttribute(largeModalClass, "class");
        assertTrue(actualLargeModalClass.contains("modal-lg"));

        String actualBgModal = testBase.getTextByLocator(txtBodyModal);
        String expectedBgModal = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

        assertEquals(actualBgModal, expectedBgModal);

    }
}
