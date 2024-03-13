package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import page.CheckBoxPage;
import page.ElementPage;
import page.HomePage;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckBoxTest extends TestCase{

    @Test
    // TC01
    public void verifyCheckBoxCorrectly() {
        //openBrowser();
        HomePage homePage = new HomePage(testBase.driver);
        homePage.testBase.scrollToEndPage();
        ElementPage elementPage = homePage.clickElement();
        CheckBoxPage checkBoxPage = elementPage.clickCheckBox();
        String actualClass = checkBoxPage.testBase.getValueOfAttribute(checkBoxPage.chkHome, "class");
        // 1. The [Home] checkbox is unchecked.
        assertTrue(actualClass.contains("rct-icon-uncheck"));

        checkBoxPage.clickCheckbox();

        //2. Text is shown: "You have selected :home desktop notes commands documents workspace react angular veu office public private classified general downloads wordFile excelFile"
        String expectedHomeText = "You have selected : home desktop notes " +
                "commands documents workspace react angular veu office public " +
                "private classified general downloads wordFile excelFile";
        String actualHomeText = checkBoxPage.getActualHomeText();

        assertEquals(actualHomeText, expectedHomeText);
        assertTrue(actualClass.contains("rct-icon-check"));

        //3. All checkboxes are displayed and checked:
        //- Desktop
        //- Documents
        //- Downloads
    }
}
