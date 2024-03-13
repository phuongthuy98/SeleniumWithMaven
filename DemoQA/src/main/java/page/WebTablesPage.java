package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebTablesPage extends Page{
   public By txtSearchBox = By.id("searchBox");
    public By txtFirstName = By.id("firstName");
    public By txtLastName = By.id("lastName");
    public By txtEmail = By.id("userEmail");
    public By txtAge = By.id("age");
    public By txtSalary = By.id("salary");
    public By txtDepartment = By.id("department");
    public By lbFirstName = By.xpath("//div[@role='grid']/div[2]//div[@role='row']/div[1]");

    public By lbLastName = By.xpath("//div[@role='grid']/div[2]//div[@role='row']/div[2]");

    public By lbAge = By.xpath("//div[@role='grid']/div[2]//div[@role='row']/div[3]");

    public By lbEmail = By.xpath("//div[@role='grid']/div[2]//div[@role='row']/div[4]");

    public By lbSalary = By.xpath("//div[@role='grid']/div[2]//div[@role='row']/div[5]");

    public By lbDepartment = By.xpath("//div[@role='grid']/div[2]//div[@role='row']/div[6]");

    public By btnSearch = By.id("basic-addon2");

    public By btnAddRecord = By.id("addNewRecordButton");

    public By btnSubmit = By.id("submit");

    public void inputSearch(String textInputSearch) {
        //click vao Type to Search
        driverWeb.findElement(txtSearchBox).click();
        //Nhập input data search
        driverWeb.findElement(txtSearchBox).sendKeys(textInputSearch);
        //click button search
        driverWeb.findElement(By.id("basic-addon2")).click();
    }
    public void clickButtonAdd() {
        //click button Add
        driverWeb.findElement(By.id("addNewRecordButton")).click();
    }

    public void addAccount(String firstName, String lastName, String userEmail, String age, String salary, String department) {
        //Nhập firstname
        testBase.inputText(txtFirstName,firstName, timeout_Short);
        testBase.inputText(txtLastName,lastName, timeout_Short);
        testBase.inputText(txtEmail,userEmail, timeout_Short);
        testBase.inputText(txtAge,age, timeout_Short);
        testBase.inputText(txtSalary,salary, timeout_Short);
        testBase.inputText(txtDepartment,department, timeout_Short);
    }

    public void clickSubmit() {
        //click submit
        driverWeb.findElement(By.id("submit")).click();
    }

    public boolean isCheckSearchResult(By locator, String keySearch) {
        boolean result = true;
        driverWeb.findElement(txtSearchBox).sendKeys(keySearch);
        List<WebElement> elements = driverWeb.findElements(locator);
        for (WebElement e : elements) {
            String text = e.getText();
            if (text == null || text.isEmpty() || text.trim().isEmpty()) {
                break;
            }
        }
        return result;
    }

/*    public boolean checkSearchResult(By locator, String keySearch) {
        boolean result = true;
        List<WebElement> elements = driverWeb.findElements(locator);
        int count = 0;
        for (WebElement e: elements){
            String searchResultText = e.getText();
            if ((searchResultText.trim()!=null && searchResultText.trim()= "") && searchResultText.contains(keySearch) ) {
                result = false;
            }
        }
        return result;
    }*/

    public WebTablesPage(WebDriver dr) {
        super(dr);
    }
}
