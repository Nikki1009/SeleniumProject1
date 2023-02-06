package com.test.projectName.tests;

import com.test.projectName.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest extends TestBase {

    //we need to extend because we have before method and after method

    @Test   // it works as main
    public  void validateUrlAndHeader(){
        MainPage mainPage = new MainPage(driver);

        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/"); //validation
        //in testNG actual comes first in Junit expected comes first
        Assert.assertEquals(mainPage.actualHeader(),"CURA Healthcare Service");
    }
}
