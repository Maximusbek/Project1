package steps;

import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.Driver;

public class GoogleSteps {

    Logger logger = LogManager.getLogger(GoogleSteps.class);
    @Given("user navigates to Google")
    public void user_navigates_to_Google() {
        logger.info("Navigating to google.com");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com/");
    }
}
