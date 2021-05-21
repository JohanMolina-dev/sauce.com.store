package screenshot;

import com.github.javafaker.Faker;
import com.google.common.io.Files;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class TakeScreenShotBuyItems {
    private final WebDriver driver;
    private static final Logger LOGGER = LogManager.getLogger(TakeScreenShotBuyItems.class);
    Faker faker = new Faker();
    int numberM = faker.number().numberBetween(1,6);

    public TakeScreenShotBuyItems(WebDriver driver) {
        this.driver = driver;
    }


    public void takeScreenshotBuy() {

        var camera = (TakesScreenshot) driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        try {
            Files.move(screenshot, new File(new StringBuilder().append("src/main/resources/screens_buy_items/BuyItems").append(Arrays.toString(new String[]{String.valueOf(numberM)})).append(".png").toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.info("ScreenShot taken from Buy runner" + screenshot.getAbsolutePath());

    }
    public void takeScreenshotCart(){
        var camera = (TakesScreenshot) driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        try {
            Files.move(screenshot, new File(new StringBuilder().append("src/main/resources/screens_cart_append/cartAppend").append(Arrays.toString(new String[]{String.valueOf(numberM)})).append(".png").toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.info("ScreenShot taken from Cart Append runner" + screenshot.getAbsolutePath());

    }

    }




