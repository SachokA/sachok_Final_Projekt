import org.assertj.core.api.SoftAssertions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

public class SubscribeWithInvalidEmail extends BaseTest{
@Test
    public void checkSubscribeWithInvalidEmail(){
    MainPage mainPage =new MainPage();
    SoftAssertions softAssertions = new SoftAssertions();
    softAssertions .assertThat(mainPage
            .getMessageOnPageGetOurLatestNewsAndSpecialSales())
            .isEqualTo("Get our latest news and special sales");
    softAssertions .assertThat(mainPage
            .getMessageOnPageOnMayUnsubscribeAtAnyMoment())
            .isEqualTo("You may unsubscribe at any moment. For that purpose, please find our contact info in the legal notice.");
    softAssertions .assertThat(mainPage
            .getMessageButtonSubscribe()).isEqualTo("uppercase");
    softAssertions.assertAll();
  }
}
