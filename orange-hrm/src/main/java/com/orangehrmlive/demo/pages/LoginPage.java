package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends Utility {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "txtUsername")
    WebElement username;

    @FindBy(id = "txtPassword")
    WebElement password;

    @FindBy(id = "btnLogin")
    WebElement loginBtn;

    @FindBy(xpath = "//div[text()='LOGIN Panel']")
    WebElement loginPanelTxt;

    public void loginToApplication(String uname, String passwd)  {

        sendTextToElement(username, uname);
        CustomListeners.test.log(Status.PASS,"Enter username " + uname);

        sendTextToElement(password, passwd);
        CustomListeners.test.log(Status.PASS,"Enter password " + passwd);

        clickOnElement(loginBtn);
        CustomListeners.test.log(Status.PASS,"Click on loginBtn");
    }

    public String getLoginPanelText(){
        return getTextFromElement(loginPanelTxt);
    }
}
