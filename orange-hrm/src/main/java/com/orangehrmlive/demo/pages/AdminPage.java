package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AdminPage extends Utility {

    public AdminPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@id='menu_admin_UserManagement']")
    WebElement userMgmt;

    @FindBy(xpath = "//a[@id='menu_admin_viewSystemUsers']")
    WebElement systemUser;


    public void clickOnAdminUserMgmtUSer() {
        mouseHoverToElement(userMgmt);
        mouseHoverToElementAndClick(systemUser);
        CustomListeners.test.log(Status.PASS,"Clicking on userlink in Admin menu"+systemUser.toString());
    }


}
