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


public class TakeScreenshot {
    private final WebDriver driver;
    private static final Logger LOGGER = LogManager.getLogger(TakeScreenshot.class);
    Faker faker = new Faker();
    int numberM = faker.number().numberBetween(1,6);
    public TakeScreenshot(WebDriver driver) {
        this.driver = driver;
    }

    public void takeScreenshot(){

        var camera = (TakesScreenshot)driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        try {
            Files.move(screenshot, new File(new StringBuilder().append("src/main/resources/screenShotsCamera/LoginCase").append(Arrays.toString(new String[]{String.valueOf(numberM)})).append(".png").toString()));
        }catch (IOException e){
            e.printStackTrace();
        }
        LOGGER.info("ScreenShot taken Form Login runner" + screenshot.getAbsolutePath());

    }
}
