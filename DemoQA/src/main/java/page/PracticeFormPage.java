package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PracticeFormPage extends Page{
    public By txtStudentName = By.xpath("//td[text()='Student Name']/following-sibling::td");
    public By txtEmail = By.xpath("//td[text()='Student Email']/following-sibling::td");
    public By txtGender = By.xpath("//td[text()='Gender']/following-sibling::td");
    public By txtMobile = By.xpath("//td[text()='Mobile']/following-sibling::td");
    public By txtDOB = By.xpath("//td[text()='Date of Birth']/following-sibling::td");
    public By txtSubjects = By.xpath("//td[text()='Subjects']/following-sibling::td");
    public By txtHobbies = By.xpath("//td[text()='Hobbies']/following-sibling::td");
    public By txtPicture = By.xpath("//td[text()='Picture']/following-sibling::td");
    public By txtCurrentAddress = By.xpath("//td[text()='Address']/following-sibling::td");
    public By txtStateAndCity = By.xpath("//td[text()='State and City']/following-sibling::td");
    public By formFirstName = By.id("firstName");
    public By formLastName = By.id("lastName");
    public By formMail = By.id("userEmail");
    public By formMobile = By.id("userNumber");
    By formDOB = By.id("dateOfBirthInput");
    public By formSubject = By.id("subjectsInput");
    public By formUploadPicture = By.id("uploadPicture");
    public By formCurrentAddress = By.id("currentAddress");
    public By formState = By.xpath("//input[@id='react-select-3-input']");
    public By formCity = By.xpath("//input[@id='react-select-4-input']");

    public By btnSubmit = By.id("submit");

    public void inputData(Map data) {
        driverWeb.findElement(formFirstName).sendKeys(data.get("First name").toString());
        driverWeb.findElement(formLastName).sendKeys(data.get("Last name").toString());
        driverWeb.findElement(formMail).sendKeys(data.get("Email").toString());
        testBase.scrollToEndPage();
        String genderXpath = "//*[text()='" + data.get("Gender").toString() +"']";
        driverWeb.findElement(By.xpath(genderXpath)).click();
        driverWeb.findElement(formMobile).sendKeys(data.get("Mobile").toString());
        inputDate(data.get("Date of Birth(DD MMM YYYY)").toString());
        driverWeb.findElement(formSubject).sendKeys(data.get("Subjects").toString());
        driverWeb.findElement(formSubject).sendKeys(Keys.ENTER);
        String hobbiesXpath = "//*[text()='" + data.get("Hobbies").toString() +"']";
        driverWeb.findElement(By.xpath(hobbiesXpath)).click();
        driverWeb.findElement(formUploadPicture).sendKeys(data.get("Picture").toString());
        driverWeb.findElement(formCurrentAddress).sendKeys(data.get("Current Address").toString());
        testBase.scrollToEndPage();
        driverWeb.findElement(formState).sendKeys(data.get("State").toString());
        driverWeb.findElement(formState).sendKeys(Keys.ENTER);
        driverWeb.findElement(formCity).sendKeys(data.get("City").toString());
        driverWeb.findElement(formCity).sendKeys(Keys.ENTER);

        clickSubmit();
    }
    /*
    *
    * @param date: Date of Birth(DD MMMM YYYY)
    * */
    public void inputDate(String date) {
        int maxDate = 31;
        int minOfPreviousDate = 26;

        String[] dates = date.split("\s");
        driverWeb.findElement(formDOB).click();

        Select drYear = new Select(driverWeb.findElement(By.xpath("//select[@class='react-datepicker__year-select']")));
        drYear.selectByVisibleText(dates[2]);

        Select drMonth = new Select(driverWeb.findElement(By.xpath("//select[@class='react-datepicker__month-select']")));
        drMonth.selectByVisibleText(dates[1]);

       List<WebElement> dateInputElements = driverWeb.findElements(By.xpath("//*[text()='" + dates[0] +"']"));

       if (dateInputElements.size() > 1) {
           int convertedDate = Integer.parseInt(dates[0]);
           //neu date nhap vao > 26 & < 31 => chon phan tu so 2 de click
           System.out.println(convertedDate);
           if(minOfPreviousDate <= convertedDate && convertedDate <= maxDate) {
               dateInputElements.get(1).click();
           } else {
               dateInputElements.get(0).click();
           }
       }
        dateInputElements.get(0).click();
    }

    /*public void inputData(HashMap<String, String> data) {
        driverWeb.findElement(formFirstName).sendKeys(data.get("First name"));
        driverWeb.findElement(formLastName).sendKeys(data.get("Last name"));
        driverWeb.findElement(formMail).sendKeys(data.get("Email"));
        String genderXpath = "//*[text()='" + data.get("Gender") +"']/preceding-sibling::input";
        driverWeb.findElement(By.xpath(genderXpath)).click();
    }*/

    public void clickSubmit() {
        testBase.scrollToEndPage();
        driverWeb.findElement(btnSubmit).click();
    }

    /*public void clickRadioButtonByLabel(String radioLabel) {
        String xpathRadio = "//*[text()='" + radioLabel + "']";
        By rdElement = By.xpath(xpathRadio);
        driverWeb.findElement(rdElement).click();
    }*/

   /* public void clickCheckboxByLabel(String checkboxLabel) {
        String xpathCheckbox = "//*[text()='" + checkboxLabel + "']";
        By cbElement = By.xpath(xpathCheckbox);
        driverWeb.findElement(cbElement).click();
    }*/

    /*public void selectYear(String year) {
        String xpathYear = selectYear.replace("@param", year);
        driverWeb.findElement(By.xpath(xpathYear)).click();
    }

    public void selectMonth(String month) {
        String xpathMonth = selectMonth.replace("@param", month);
        driverWeb.findElement(By.xpath(xpathMonth)).click();
    }

    public void selectDay(String day) {
        String xpathDay = selectDays.replace("@param", day);
        List<WebElement> dayElements = driverWeb.findElements(By.xpath(xpathDay)); // Data special
        dayElements.get(0).click();
    }*/

    /*public void selectDateOfBirth(String year, String month, String day) {
        driverWeb.findElement(formDOB).click();
        selectYear(year);
        selectMonth(month);
        selectDay(day);
    }

    public void inputUploadPicture() {
        driverWeb.findElement(formUploadPicture)
                .sendKeys(System.getProperty("user.dir") + "/src/main/resources/1.jpeg");

    }*/

    public PracticeFormPage(WebDriver dr) {
        super(dr);
    }
}
