package com.test.projectName.tests;

import com.test.projectName.pages.AppointmentPage;
import com.test.projectName.pages.LoginPage;
import com.test.projectName.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppointmentTest extends TestBase{

    @Test
    public void validateMakeAppointment() throws InterruptedException {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        AppointmentPage appointmentPage = new AppointmentPage(driver);
        mainPage.clickAppointmentButton();
        loginPage.login();

        Assert.assertEquals(appointmentPage.actualHeader(),"Make Appointment");
        Assert.assertEquals(appointmentPage.actualBackgroundColor(),"");
        appointmentPage.getAnAppointment("Tokyo CURA Healthcare Center",
                "Medicaid","02/02/2023",
                "Lets make an appointment");

        appointmentPage.validateInfo(driver, "https://katalon-demo-cura.herokuapp.com/",
                "Appointment Confirmation", "Tokyo CURA Healthcare Center",
                "Yes","Medicaid","02/02/2023","Lets make an appointment");





    }


}
