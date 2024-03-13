package page;

import common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBoxPage extends Page{

    public TextBoxPage(WebDriver dr) {
        super(dr);
    }

    public By lbName = By.id("name");
    public By lbEmail = By.id("email");
    public By lbCurrentAddress = By.xpath("//p[@id='currentAddress']");
    public By lbPermanentAddress = By.xpath("//p[@id='permanentAddress']");
    public By txtFullName=By.id("userName");
    public By txtEmail=By.id("userEmail");
    public By txtCurrentAddress=By.id("currentAddress");
    public By txtPermanentAddress=By.id("permanentAddress");

    public void inputData(String userName, String userEmail, String currentAddress, String permanentAddress) {
        // Nhập input data
        testBase.inputText(txtFullName,userName, timeout_Short);
        testBase.inputText(txtEmail,userEmail, timeout_Short);
        testBase.inputText(txtCurrentAddress,currentAddress, timeout_Short);
        testBase.inputText(txtPermanentAddress,permanentAddress, timeout_Short);
    }

    public void clickSubmit() {
        testBase.scrollToEndPage();
        driverWeb.findElement(By.id("submit")).click();
    }

    public String getTextResult(By element) {
        String result = "";
        String originText = testBase.driver.findElement(element).getText();
        result = originText.substring(originText.indexOf(":") + 1);
        return result;
    }

}
