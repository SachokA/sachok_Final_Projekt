import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllProductsComponent;
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
        List<AllProductsComponent> actualResultAZ = homePage.mergeList();
        System.out.println(actualResultAZ.size());
        System.out.println(actualResultAZ);
        softAssert.assertAll();
    }
}
