package com.test.projectName.pages;

import com.test.projectName.utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    @FindBy(tagName ="h2")
    WebElement header;

    @FindBy(id= "btn-make-appointment")
    WebElement makeAppointmentButton;

    // you should have under pages --> elements and methods
    public String actualHeader(){
        return BrowserUtils.getText(header);
    }
public void clickAppointmentButton(){
        makeAppointmentButton.click();

}
}
