import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

public class CheckLanguages extends BaseTest{

    @Test
    public void checkLanguages(){
        MainPage mainPage = new MainPage();
        Assert.assertEquals(mainPage.sizeLanguagesList(),46);
        Assert.assertTrue(mainPage.findingUkrainianLanguagesInList());
    }
}
