package untils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.BasePage;
import pages.MainPage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static pages.BasePage.getDriver;

public class Utils  {
    public static void waitSeconds(long seconds){
        try{
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e){
            System.out.println("Can't wait for "+ seconds+"seconds");
        }
    }
     public static List<String> getList(List<WebElement> webElements) {

        List<String> list = new ArrayList<>();
        List<WebElement> elements = webElements;
        for (WebElement element : elements) {
            list.add(element.getText());
        }
        return list;
    }
    public static void hoverOver(WebElement webElement) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(webElement).perform();
    }
}
