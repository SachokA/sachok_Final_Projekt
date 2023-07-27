import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MainPage;

import java.util.Arrays;
import java.util.List;

public class CheckCategories extends BaseTest{

    @Test
    public void checkCategories(){
        MainPage mainPage = new MainPage();
        List<String> actualClothes = mainPage
                .moveToElement(mainPage.buttonClothes)
                .getList(mainPage.clothesList);
        List<String> expectedClothes = Arrays.asList("MEN","WOMEN");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualClothes,expectedClothes);
        List<String> actualAccessories = mainPage
                .moveToElement(mainPage.buttonAccessories)
                        .getList(mainPage.accessoriesList);
        List<String> expectedAccessories = Arrays.asList("STATIONERY" , "HOME ACCESSORIES");
        softAssert.assertEquals(actualAccessories,expectedAccessories);
        String actualAttributeArt = mainPage
                .moveToElement(mainPage.buttonArt)
                .getArtValue();
        softAssert.assertNotEquals(actualAttributeArt,"dropdown-item dropdown-submenu");
        softAssert.assertAll();
    }
}
