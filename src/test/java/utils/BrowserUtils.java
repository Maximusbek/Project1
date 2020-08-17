package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class BrowserUtils {
    public static String takeScreenShot(){
        // First we cast driver to TakeScreenShot the we get as file

        File src = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        /*
        We need the destination to store all the screenshots
        System.setProperty(user.dir) - it will give the project location
        System.currentTimeMillis() helps us to give unique name for my Screenshot

         */

        String destination = System.getProperty("user.dir")+"\\Screenshot\\"+System.currentTimeMillis()+".png";
        File dest  = new File(destination);

        try {
            // copy file will get the file from source to the destination
            FileUtils.copyFile(src,dest);
        }catch (Exception e){
            e.printStackTrace();
        }
        return destination;
    }
}
