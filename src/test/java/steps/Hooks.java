package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.BrowserUtils;
import utils.Driver;

import java.io.IOException;

public class Hooks {
    @Before

    public void setUp(Scenario scenario){
        System.out.println("This will run before each Scenario");
        System.out.println(scenario.getName());
        System.out.println(scenario.getLine());
    }

    @After

    public void tearDown(Scenario scenario){

        System.out.println("This will run after each Scenario");

        System.out.println("Hooks clean up");
        System.out.println(scenario.getName());
        System.out.println(scenario.getStatus());

        if (scenario.isFailed()){
           try {
               BrowserUtils.takeScreenShot();
           }catch (Exception e){
               e.printStackTrace();
           }
        }
    }
}
