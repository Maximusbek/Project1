package steps;

import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Driver;

public class AmazonSteps {
    Logger logger = LogManager.getLogger(AmazonSteps.class);
 WebDriver driver = Driver.getDriver();
    @Given("User navigates to Amazon Home page")
    public void user_navigates_to_Amazon_Home_page() {
        logger.info("Navigating to amazon.com");
    driver.navigate().to("https://www.amazon.com/");
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Evutec");
    }

}
