package com.test.projectName.pages;

import com.test.projectName.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }

    @FindBy(name ="username")
    WebElement userName;

    @FindBy(xpath = "//input[@id='txt-password']")
    WebElement password;

    @FindBy(css = ".btn-default") // if I put # means looking for id
    WebElement loginButton;
    // NOTE: When we locate by CSS :
    // hashtag # represent = id
    //dot . represents class
    public void login(){
        userName.sendKeys(ConfigReader.readProperty("QA_username"));
        password.sendKeys(ConfigReader.readProperty("QA_password"));
        loginButton.click();
    }
}
