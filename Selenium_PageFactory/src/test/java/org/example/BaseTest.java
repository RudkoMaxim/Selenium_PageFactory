package org.example;

import Pages.utils.DriverFactory;
import Pages.utils.PropertyReader;
import enums.Capability;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = DriverFactory.createDriver(PropertyReader.getConfigProperty(Capability.BROWSER));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterTest
    public void closeSession() {
        driver.quit();
    }
}
