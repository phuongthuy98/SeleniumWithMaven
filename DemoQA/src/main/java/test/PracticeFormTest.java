package test;

import common.Utils;
import org.testng.annotations.Test;
import page.FormsPage;
import page.HomePage;
import page.PracticeFormPage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class PracticeFormTest extends TestCase{

    //TC-01
    @Test
    public void submitDataSuccessfully() {
        // String dataFile = System.getProperty("user.dir") + "/testdata/DemoQA_TestCase_v1.3.xlsx";
        // String dataSheet = "PracticeForm_Data";
        //List<HashMap<String, String>> dataList= Utils.getTestDataFromExcel(dataFile, dataSheet);
        String dataFile = System.getProperty("user.dir") + "/testdata/PractiveFormData.csv";
        List<Map> listData = Utils.getTestDataFromCSV(dataFile);

        HomePage homePage = new HomePage(testBase.driver);
        //homePage.testBase.zoomOut();
        homePage.testBase.scrollToEndPage();
        // Từ Home Page click vào Form, điều hướng trang khởi tạo trang Form mới
        FormsPage formPage = homePage.clickForms();
        //Từ Form page click vào practive form
        PracticeFormPage practiveFormPage= formPage.clickPracticeForm();
        practiveFormPage.inputData((listData.get(0)));

        String actualStudentName = practiveFormPage.getTextResult(practiveFormPage.txtStudentName);
        String expectedStudentName = listData.get(0).get("First name").toString() + " " + listData.get(0).get("Last name").toString();
        assertEquals(actualStudentName, expectedStudentName);


        String actualEmail = practiveFormPage.getTextResult(practiveFormPage.txtEmail);
        String expectedEmail = listData.get(0).get("Email").toString();
        assertEquals(actualEmail, expectedEmail);

        String actualGender = practiveFormPage.getTextResult(practiveFormPage.txtGender);
        String expectedGender = listData.get(0).get("Gender").toString();
        assertEquals(actualGender, expectedGender);

        String actualMobile = practiveFormPage.getTextResult(practiveFormPage.txtMobile);
        String expectedMobile = listData.get(0).get("Mobile").toString();
        assertEquals(actualMobile, expectedMobile);

        String actualDOB = practiveFormPage.getTextResult(practiveFormPage.txtDOB).replace(",", " ");
        String expectedDOB = listData.get(0).get("Date of Birth(DD MMM YYYY)").toString();
        assertEquals(actualDOB, expectedDOB);

        String actualSubjects = practiveFormPage.getTextResult(practiveFormPage.txtSubjects);
        String expectedSubjects = listData.get(0).get("Subjects").toString();
        assertEquals(actualSubjects, expectedSubjects);

        String actualHobbies = practiveFormPage.getTextResult(practiveFormPage.txtHobbies);
        String expectedHobbies = listData.get(0).get("Hobbies").toString();
        assertEquals(actualHobbies, expectedHobbies);

        String actualPicture = practiveFormPage.getTextResult(practiveFormPage.txtStudentName);
        String expectedPicture = listData.get(0).get("Picture").toString();
        assertEquals(actualPicture, expectedPicture);

        String actualCurrentAddress = practiveFormPage.getTextResult(practiveFormPage.txtCurrentAddress);
        String expectedCurrentAddress = listData.get(0).get("Current Address").toString();
        assertEquals(actualCurrentAddress, expectedCurrentAddress);

        String actualStateAndCity = practiveFormPage.getTextResult(practiveFormPage.txtStateAndCity);
        String expectedStateAndCity = listData.get(0).get("State").toString() + " " +listData.get(0).get("City").toString() ;
        assertEquals(actualStateAndCity, expectedStateAndCity);
    }

}
