package test;

import org.testng.annotations.Test;
import page.ElementPage;
import page.HomePage;
import page.WebTablesPage;

import static org.testng.Assert.assertTrue;

public class WebTablesTest extends TestCase{
    String firstName="ha phuong";
    String lastName="thuy";
    String userEmail="thuy@gmail.com";
    String age="30";
    String salary="1234567890";
    String department="HaNoi";

    @Test
    //TC01
    public void searchByFirstNameSuccessfully() {

        String textInputSearch="rr";
        HomePage homePage = new HomePage(testBase.driver);
        //homePage.testBase.zoomOut();
        homePage.testBase.scrollToEndPage();
        // Từ Home Page click vào Element, điều hướng trang khởi tạo trang ElementPage mới
        ElementPage elementPage = homePage.clickElement();
        elementPage.testBase.scrollToEndPage();
        // Từ ElementPage click vào WebTablesPage, điều hướng trang khởi tạo trang WebTablesPage mới
        WebTablesPage webTablePage = elementPage.clickWebTable();
        webTablePage.inputSearch(textInputSearch);
        boolean result = webTablePage.isCheckSearchResult(webTablePage.lbFirstName, textInputSearch);

        assertTrue(result);
        //assertTrue(webTablePage.checkSearchResult(webTablePage.lbFirstName, textInputSearch));
    }

    @Test
    //TC02
    public void registerNewAccountSuccessfully() {
        HomePage homePage = new HomePage(testBase.driver);
        //homePage.testBase.zoomOut();
        homePage.testBase.scrollToEndPage();
        // Từ Home Page click vào Element, điều hướng trang khởi tạo trang ElementPage mới
        ElementPage elementPage = homePage.clickElement();
        elementPage.testBase.scrollToEndPage();
        // Từ ElementPage click vào WebTablesPage, điều hướng trang khởi tạo trang WebTablesPage mới
        WebTablesPage webTablePage = elementPage.clickWebTable();
        webTablePage.clickButtonAdd();
        webTablePage.addAccount(firstName, lastName, userEmail, age, salary, department);
        webTablePage.clickSubmit();

    }
}
