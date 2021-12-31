package stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.Driver;
import utils.ReusableMethods;

import java.io.IOException;

public class Hooks {

    @After
    public void tearDown(Scenario scenario) throws IOException {

        if(scenario.isFailed()){
            final byte[] screenshot =  ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            ReusableMethods.getScreenshot("failed-screenshot-");
            scenario.attach(screenshot, "image/png", "screenshot");
        }
        Driver.closeDriver();

    }
}
