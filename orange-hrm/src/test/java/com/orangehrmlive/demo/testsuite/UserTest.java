package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.AddUserPage;
import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.pages.ViewSystemUserPage;
import com.orangehrmlive.demo.testbase.TestBase;
import graphql.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

@Listeners(CustomListeners.class)
public class UserTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    ViewSystemUserPage viewSystemUsersPage;
    AddUserPage addUserPage;
    SoftAssert softAssert;
    @BeforeMethod(alwaysRun = true)
    public void initialize(){
        homePage = new HomePage();
        loginPage = new LoginPage();
        viewSystemUsersPage = new ViewSystemUserPage();
        addUserPage = new AddUserPage();
        softAssert=new SoftAssert();
    }

    @Test(groups={"sanity","smoke","regression"})
    public void adminShouldAddUserSuccessFully() throws InterruptedException {
        loginPage.loginToApplication("Admin", "admin123");
        viewSystemUsersPage.clickOnAdminTab();
        viewSystemUsersPage.verifySystemUsersText("System Users");
        viewSystemUsersPage.clickAddButton();
        addUserPage.verifyAddUserText("Add User");
        addUserPage.addUserDetails("Admin", "Ananya Dash","hello12",
                "Disabled", "Hinal5572","Hinal5572");
        addUserPage.clickOnSaveButton();
        viewSystemUsersPage.verifySuccessfullySavedMessage("Successfully Saved");
    }

    @Test(groups={"smoke","regression"},retryAnalyzer = RetryAnalyzer.class)
    public void searchTheUserCreatedAndVerifyIt() throws InterruptedException {

        loginPage.loginToApplication("Admin", "admin123");
        viewSystemUsersPage.clickOnAdminTab();
        viewSystemUsersPage.verifySystemUsersText("System Users");
        viewSystemUsersPage.inputUserName("hello12");
        viewSystemUsersPage.selectUserRole("Admin");
        viewSystemUsersPage.selectUserStatus("Disabled");
        viewSystemUsersPage.clickOnSearchButton();
        List<String> names= viewSystemUsersPage.verifyUserInSearchResult();
        Assert.assertTrue(names.contains("hello12"));
    }
    @Test(groups={"regression"}, priority = 0)
    public void verifyThatAdminShouldDeleteTheUserSuccessFully() throws InterruptedException {

        loginPage.loginToApplication("Admin", "admin123");
        viewSystemUsersPage.clickOnAdminTab();
        viewSystemUsersPage.verifySystemUsersText("System Users");
        viewSystemUsersPage.enterEmployeeName("Joe Root");
        viewSystemUsersPage.selectUserRole("Admin");
        viewSystemUsersPage.selectUserStatus("Disabled");
        viewSystemUsersPage.clickOnSearchButton();
        List<String> names= viewSystemUsersPage.getTextFromEmployeeList();
        softAssert.assertTrue(names.contains("Joe Root"));
        viewSystemUsersPage.clickOnCheckBox();
        viewSystemUsersPage.clickOnDeleteButton();
        viewSystemUsersPage.acceptPopUpMessage();
        viewSystemUsersPage.verifyRecordSuccessfullyDeletedMessage("Successfully Deleted");
        softAssert.assertAll();
    }
    @Test(groups={"regression"},priority = 1)
    public void searchTheDeletedUserAndVerifyTheMessageNoRecordFound() throws InterruptedException {
        loginPage.loginToApplication("Admin", "admin123");
        viewSystemUsersPage.clickOnAdminTab();
        viewSystemUsersPage.verifySystemUsersText("System Users");
        viewSystemUsersPage.enterEmployeeName("Joe Root");
        viewSystemUsersPage.selectUserRole("Admin");
        viewSystemUsersPage.selectUserStatus("Disabled");
        viewSystemUsersPage.clickOnSearchButton();
        viewSystemUsersPage.verifyNoRecordFoundText("No Records Found");

    }
}
