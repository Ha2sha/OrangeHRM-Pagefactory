package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.AddUserPage;
import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.pages.ViewSystemUserPage;
import com.orangehrmlive.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class LoginTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    ViewSystemUserPage viewSystemUsersPage;
    AddUserPage addUserPage;

    @BeforeMethod(alwaysRun = true)
    public void initialize() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        viewSystemUsersPage = new ViewSystemUserPage();
        addUserPage = new AddUserPage();
    }


    @Test(groups={"sanity","smoke","regression"})
    public void verifyUserShouldLoginSuccessFully() {
        loginPage.loginToApplication("Admin", "admin123");
        homePage.verifyWelcomeText("welcome");
    }

    @Test(groups={"smoke","regression"})
    public void verifyThatTheLogoDisplayOnHomePage(){
        loginPage.loginToApplication("Admin", "admin123");
        homePage.verifyOrangeHrmLogoIsVisible();

    }
    @Test(groups={"regression"})
    public void verifyUserShouldLogOutSuccessFully() throws InterruptedException {
        loginPage.loginToApplication("Admin", "admin123");
        homePage.clickOnProfileLogo();
        homePage.mouseHovertoLogoutAndClick();

    }

}
