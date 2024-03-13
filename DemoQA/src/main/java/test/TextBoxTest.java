package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.ElementPage;
import page.HomePage;
import page.TextBoxPage;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

//All test cases of TextBox Page
public class TextBoxTest extends TestCase {
    @Test
    // TC01
    public void submitSuccessfully() {
        String userNameInput = "thuy";
        String userEmailInput = "thuy@mailsac.com";
        String currentAddressInput = "currentAddress";
        String permanentAddressInput ="permanentAddress";


        HomePage homePage = new HomePage(testBase.driver);
        homePage.testBase.scrollToEndPage();
        ElementPage elementPage = homePage.clickElement();
        TextBoxPage textBoxPage = elementPage.clickTextBox();
        textBoxPage.inputData(userNameInput, userEmailInput, currentAddressInput, permanentAddressInput);
        textBoxPage.clickSubmit();

        Assert.assertEquals(textBoxPage.getTextResult(textBoxPage.lbName), userNameInput);
        Assert.assertEquals(textBoxPage.getTextResult(textBoxPage.lbEmail), userEmailInput);
        Assert.assertEquals(textBoxPage.getTextResult(textBoxPage.lbCurrentAddress), currentAddressInput);
        Assert.assertEquals(textBoxPage.getTextResult(textBoxPage.lbPermanentAddress), permanentAddressInput);
    }
    @Test
    public void validEmail() {

        String userNameInput = "thuy";
        String userEmailInput = "thuymailsac.com";
        String currentAddressInput = "currentAddress";
        String permanentAddressInput ="permanentAddress";

        HomePage homePage = new HomePage(testBase.driver);
        homePage.testBase.scrollToEndPage();
        ElementPage elementPage = homePage.clickElement();
        TextBoxPage textBoxPage = elementPage.clickTextBox();
        textBoxPage.inputData(userNameInput, userEmailInput, currentAddressInput, permanentAddressInput);
        textBoxPage.clickSubmit();

        assertTrue(textBoxPage.testBase.getValueOfAttribute(textBoxPage.txtEmail,"class").contains("field-error"));
    }
}
