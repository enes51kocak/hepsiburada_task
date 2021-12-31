package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class ReusableMethods {

    /**
     *
     * @param name screenshot ismini parametre olarak veririz
     * @return kaydedilen screenshot yolunu ve adının verir
     * @throws IOException
     */
    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot avoid duplication
        String date = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the given path
        FileUtils.copyFile(source, finalDestination);
        return target;
    }

    /**
     *
     * @return the window handle of proceeded page
     */
    public static String switchToNextWindow() {
        WebDriver driver = Driver.getDriver();
        String currentPageWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String w : allWindowHandles) {
            if (!w.equals(currentPageWindowHandle)) {
                driver.switchTo().window(w);
            }
        }
        return driver.getWindowHandle();
    }

}
