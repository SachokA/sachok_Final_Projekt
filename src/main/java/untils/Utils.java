package untils;

import pages.BasePage;

import java.util.concurrent.TimeUnit;

public class Utils  {
    public static void waitSeconds(long seconds){
        try{
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e){
            System.out.println("Can't wait for "+ seconds+"seconds");
        }
    }
}
