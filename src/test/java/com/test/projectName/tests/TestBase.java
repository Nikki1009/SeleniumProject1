package com.test.projectName.tests;

import com.test.projectName.utils.BrowserUtils;
import com.test.projectName.utils.ConfigReader;
import com.test.projectName.utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverHelper.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfigReader.readProperty("QA_project_name_URL"));

    }

    @AfterMethod
    public void tearDown(){
        BrowserUtils.getScreenShot(driver,"projectName");
        driver.quit();

    }
}
