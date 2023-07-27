import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

public class SubscribeWithInvalidEmail extends BaseTest{
@Test
    public void checkSubscribeWithInvalidEmail(){
    MainPage mainPage =new MainPage();
    Assert.assertEquals(mainPage
            .getMessageOnPageGetOurLatestNewsAndSpecialSales(),
            "Get our latest news and special sales");
    Assert.assertEquals(mainPage
            .getMessageOnPageOnMayUnsubscribeAtAnyMoment(),
            "You may unsubscribe at any moment. For that purpose, please find our contact info in the legal notice.");
    Assert.assertEquals(mainPage
            .getMessageButtonSubscribe(),"uppercase");
  }
}
