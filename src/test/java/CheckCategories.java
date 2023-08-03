import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
;
import pages.MainPage;

import java.util.List;

public class CheckCategories extends BaseTest {

    @Test
    public void checkCategories() {
        MainPage mainPage = new MainPage();
        SoftAssertions softly = new SoftAssertions();

        mainPage.hoverOverClothesCategory();
        List<String> actualClothesSubCategories = mainPage.getClothesSubMenuItems();
        softly.assertThat(actualClothesSubCategories).contains("MEN", "WOMEN");

        mainPage.hoverOverAccessoriesCategory();
        List<String> actualAccessoriesSubCategories = mainPage.getAccessoriesSubMenuItems();
        softly.assertThat(actualAccessoriesSubCategories).contains("STATIONERY", "HOME ACCESSORIES");

        mainPage.hoverOverArtCategory();
        String isArtCategory = mainPage.getArtValue();
        softly.assertThat(isArtCategory).doesNotContain("dropdown-submenu");


        softly.assertAll();
    }
}
