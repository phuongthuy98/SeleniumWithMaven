package test;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import page.AccordianPage;
import page.AlertFrameWindowPage;
import page.HomePage;
import page.WidgetsPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AccordianTest extends TestCase{

    @Test
    public void verifyAccordian() {
        /*HomePage homePage = new HomePage(testBase.driver);
        testBase.scrollToEndPage();
        WidgetsPage widgetsPage = homePage.clickWidgets();
        testBase.driver.navigate().to("https://demoqa.com/accordian");
        WidgetsPage.clickAccordian();*/
        AccordianPage accordianPage = new AccordianPage(testBase.driver);

        testBase.navigateBrowser("https://demoqa.com/accordian");
        testBase.scrollToEndPage();

        //Section1
        String expectedHeaderSection1 = "What is Lorem Ipsum?";
        String actualHeaderSection1 = testBase.getTextByLocator(AccordianPage.lbSection1);

        assertEquals(actualHeaderSection1, expectedHeaderSection1);

        String actualSection1ShowClass = testBase.getValueOfAttribute(AccordianPage.lbSection1Show, "class");
        assertTrue(actualSection1ShowClass.contains("show"));

        String expectedContentSection1 = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        String actualContentSection1 = testBase.getTextByLocator(AccordianPage.txtSection1);

        assertEquals(actualContentSection1, expectedContentSection1);

        //Section2
        String expectedHeaderSection2 = "Where does it come from?";
        String actualHeaderSection2 = testBase.getTextByLocator(AccordianPage.lbSection2);
        assertEquals(actualHeaderSection2, expectedHeaderSection2);

        testBase.clickByLocator(AccordianPage.lbSection2);
        String actualSection2ShowClass = testBase.getValueOfAttribute(AccordianPage.lbSection2Show, "class");
        assertTrue(actualSection2ShowClass.contains("show"));

        String expectedContentSection2 = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32. The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.";
        String actualContentSection2 = testBase.getContentText(AccordianPage.txtSection2);
        assertEquals(actualContentSection2, expectedContentSection2);

        //Section3
        String expectedHeaderSection3 = "Why do we use it?";
        String actualHeaderSection3 = testBase.getTextByLocator(AccordianPage.lbSection3);
        assertEquals(actualHeaderSection3, expectedHeaderSection3);

        testBase.clickByLocator(AccordianPage.lbSection3);
        String actualSection3ShowClass = testBase.getValueOfAttribute(AccordianPage.lbSection3Show, "class");
        assertTrue(actualSection3ShowClass.contains("show"));

        String expectedContentSection3 = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).";
        String actualContentSection3 = testBase.getContentText(AccordianPage.txtSection3);

        assertEquals(actualContentSection3, expectedContentSection3);


    }
}
