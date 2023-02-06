package com.test.projectName.pages;

import com.test.projectName.utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class AppointmentPage {


    public AppointmentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "h2")
    WebElement header;

    @FindBy(xpath = "//select[@id='combo_facility']")
    WebElement facility;

    @FindBy(xpath = "//input[@id ='chk_hospotal_readmission']")
    WebElement readmission;

    @FindBy(xpath = "//input[@type='radio']") //3 elements
    List<WebElement> allHealthcareButtons;

    @FindBy(xpath = "//input[@name='visit_date']")
    WebElement date;

    @FindBy(id = "txt_comment")
    WebElement comment;

    @FindBy(xpath = "//button[contains(text(), 'Book Appointment')]")
    WebElement bookAppointment;

   @FindBy(xpath = "//section[@id='appointment']")
   WebElement section;

   @FindBy(tagName = "h2")
   WebElement confirmHeader;

   @FindBy(xpath = "//div[@class='col-xs-8']//p")
   List<WebElement>allConfirmations;

   @FindBy(linkText = "Go to Homepage")
   WebElement homePage;

   public String actualBackgroundColor(){
       return section.getCssValue("background color");
   }

    public String actualHeader() {
        return BrowserUtils.getText(header); // validation header

    }

    public void getAnAppointment(String facilityText, String healthcareProgram, String date, String comment) throws InterruptedException {
        Select forFacility = new Select(facility);
        forFacility.selectByVisibleText(facilityText);
        readmission.click();
        Assert.assertTrue(readmission.isSelected());

        for (WebElement radioButton : allHealthcareButtons) {
            if (radioButton.getAttribute("value").equals(healthcareProgram)) {
                radioButton.click();
                break;
            }
        }
        this.date.sendKeys(date);
        Thread.sleep(3000);
        this.comment.sendKeys(comment);
        bookAppointment.click();

    }
    public void validateInfo(WebDriver driver,  String expectedUrl, String expectedHeader, String facility, String readmission,String healthcare,
                             String date, String comment){
       Assert.assertEquals(BrowserUtils.getText(confirmHeader),
               expectedHeader);
       List<String> expectedInfo = Arrays.asList(facility,readmission,healthcare,date,comment);

       for(int i = 0; i < allConfirmations.size(); i++){
           Assert.assertEquals(allConfirmations.get(i).getText().trim(),expectedInfo.get(i));
       }
       homePage.click();
       Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);

    }
}