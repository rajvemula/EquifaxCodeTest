package com.amazon.libs;

import com.amazon.utilities.PropertyFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BrowserFactory extends PropertyFileReader{

    public static WebDriver driver;
    public PropertyFileReader prop = new PropertyFileReader();

    @BeforeTest
    public void startBrowser() throws IOException {
        System.setProperty("webdriver.chrome.driver", "src\\test\\browser-drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(prop.getUrl().toString());
		    driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterTest
    public void closeBrowser() throws IOException {
        if(driver != null) {
            driver.close();
        }
    }

}
