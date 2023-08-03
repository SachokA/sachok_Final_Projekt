import org.assertj.core.api.SoftAssertions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

public class CheckLanguages extends BaseTest{

    @Test
    public void checkLanguages(){
        MainPage mainPage = new MainPage();
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(mainPage.sizeLanguagesList()).isEqualTo(46);
        softAssertions.assertThat(mainPage.findingUkrainianLanguagesInList()).isTrue();
        softAssertions.assertAll();
    }
}