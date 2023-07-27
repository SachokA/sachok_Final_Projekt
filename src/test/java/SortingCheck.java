import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.MainPage;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class SortingCheck extends BaseTest {
    @Test
    public void sortingCheck() throws InterruptedException {
        MainPage mainPage = new MainPage();
        HomePage homePage = new HomePage();
        SoftAssert softAssert = new SoftAssert();

        mainPage.clickAllProducts();
        homePage.clickButtonSorted();
        homePage.selectSortedNameAZ();
        List<String> actualResultSortedNameAZ = homePage.getAllProducts();
        List<String> expectedResultSortedNameAZ = homePage.sortedNameAZ();
        softAssert.assertEquals(actualResultSortedNameAZ, expectedResultSortedNameAZ);


        softAssert.assertAll();
    }
}
