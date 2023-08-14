import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllProductsComponent;
import pages.HomePage;
import pages.MainPage;

import java.util.List;

public class SortingCheckTest extends BaseTest {
    @Test
    public void sortingCheck() throws InterruptedException {
        MainPage mainPage = new MainPage();
        HomePage homePage = new HomePage();
        SoftAssertions softAssert = new SoftAssertions();
        mainPage.clickAllProducts()
                .clickButtonSorted()
                .selectSortedNameAZ();
        List<AllProductsComponent> actualResultAZ = homePage.waitSecond(1).mergeList();
        List<AllProductsComponent> expectedResultAZ = homePage.sortedAZ();
        softAssert.assertThat(actualResultAZ).isEqualTo(expectedResultAZ);
        homePage.clickButtonSorted()
                .selectSortedNameZA();
        List<AllProductsComponent> actualResultZA = homePage
                .waitSecond(2)
                .mergeList();
        List<AllProductsComponent> expectedResultZA = homePage.sortedZA();
        softAssert.assertThat(actualResultZA).isEqualTo(expectedResultZA);
        homePage.clickButtonSorted()
                .selectSortedPriceLowHigh();
        List<AllProductsComponent> actualResultPriceLowHugh = homePage
                .waitSecond(2)
                .mergeList();
        List<AllProductsComponent> expectedResultPriceLowHugh = homePage
                .waitSecond(1)
                .sortedPriceLowHigh();
        softAssert.assertThat(actualResultPriceLowHugh).isEqualTo(expectedResultPriceLowHugh);
        homePage.clickButtonSorted()
                .selectSortedPriceHighLow();
        List<AllProductsComponent> actualResultPriceHughLow = homePage
                .waitSecond(1)
                .mergeList();
        List<AllProductsComponent> expectedResultPriceHughLow = homePage
                .waitSecond(1)
                .sortedPriceHighLow();
        softAssert.assertThat(actualResultPriceHughLow).isEqualTo(expectedResultPriceHughLow);
        softAssert.assertAll();
    }
}
