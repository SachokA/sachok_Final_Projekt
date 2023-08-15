import enums.Category;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
;
import pages.MainPage;

import java.util.List;

import static enums.Category.ACCESSORIES;
import static enums.Category.CLOTHES;

public class CheckCategoriesTest extends BaseTest {

    @Test
    public void checkCategories() {
        MainPage mainPage = new MainPage();
        SoftAssertions softly = new SoftAssertions();

        mainPage.hoverOverClothesCategory();
        List<String> actualClothesSubCategories = mainPage.getClothesSubMenu();
        softly.assertThat(actualClothesSubCategories).containsAll(CLOTHES.getSubCategories());

        mainPage.hoverOverAccessoriesCategory();
        List<String> actualAccessoriesSubCategories = mainPage.getAccessoriesList();
        softly.assertThat(actualAccessoriesSubCategories).containsAll(ACCESSORIES.getSubCategories());

        mainPage.hoverOverArtCategory();
        String isArtCategory = mainPage.getArtValue();
        softly.assertThat(isArtCategory).doesNotContain("dropdown-submenu");


        softly.assertAll();
    }
}
