package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class ViewSystemUserPage extends Utility {

    public ViewSystemUserPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[contains(text(),'System Users')]")
    WebElement systemUserTxt;

    @FindBy(xpath = "//b[contains(text(),'Admin')]")
    WebElement adminLink;

    @FindBy(id = "btnAdd")
    WebElement addBtn;

    @FindBy(xpath = "//div[contains(text(),'Successfully Saved')]")
    WebElement successfullySavedText;

    @FindBy(id = "searchSystemUser_userName")
    WebElement searchUserName;

    @FindBy(id = "searchSystemUser_userType")
    WebElement searchUserRoleDropDown;

    @FindBy(id = "searchSystemUser_status")
    WebElement searchUserStatusDropDown;

    @FindBy(id = "searchBtn")
    WebElement searchBtn;

    @FindBy(xpath = "//table[@id='resultTable']/tbody/tr[1]/td[2]/a")
    List<WebElement> verifyResultList;

    @FindBy(xpath = "//input[@id='ohrmList_chkSelectAll']")
    WebElement checkBox;

    @FindBy(id = "btnDelete")
    WebElement deleteButton;

    @FindBy(id = "dialogDeleteBtn")
    WebElement deleteRecordPopUp;

    @FindBy(xpath = "//div[contains(text(),'Successfully Deleted')]")
    WebElement successFullyDeletedText;

    @FindBy(xpath = "//td[contains(text(),'No Records Found')]")
    WebElement noRecordFoundText;

    @FindBy(xpath="//input[@id='searchSystemUser_employeeName_empName']")
    WebElement employeeName;

    @FindBy(xpath ="//table[@id='resultTable']/tbody/tr/td[4]")
    List<WebElement> employeeNameList;

    public void enterEmployeeName(String name){
        CustomListeners.test.log(Status.PASS,"Entering Employee Name " + name);
        sendTextToElement(employeeName,name);
    }

    public void verifySystemUsersText(String text){
        verifyThatTextIsDisplayed(systemUserTxt, text);
        CustomListeners.test.log(Status.PASS,"Verify System User text " + text);
    }

    public void clickOnAdminTab(){
        clickOnElement(adminLink);
        CustomListeners.test.log(Status.PASS,"Click on Admin Tab ");
    }

    public void clickAddButton(){
        clickOnElement(addBtn);
        CustomListeners.test.log(Status.PASS,"Click on withdraw button ");
    }

    public void verifySuccessfullySavedMessage(String text) {
        verifyThatTextIsDisplayed(successfullySavedText, text);
        CustomListeners.test.log(Status.PASS,"Verify Successfully Saved Message displayed " + text);
    }

    public void clickOnSearchButton(){
        clickOnElement(searchBtn);
        CustomListeners.test.log(Status.PASS,"Click on searchBtn");
    }

    public void inputUserName(String userName){
        sendTextToElement(searchUserName, userName);
        CustomListeners.test.log(Status.PASS,"Enter username " +userName);
    }

    public void selectUserRole(String role){
        selectByVisibleTextFromDropDown(searchUserRoleDropDown, role);
        CustomListeners.test.log(Status.PASS,"Select user role from dropdown " + role);
    }

    public void selectUserStatus(String status){
        selectByVisibleTextFromDropDown(searchUserStatusDropDown, status);
        CustomListeners.test.log(Status.PASS,"Select user status " + status);
    }

    public List<String> verifyUserInSearchResult(){
        CustomListeners.test.log(Status.PASS,"Getting text from Username list  ");
        List<String> names=new ArrayList<>();
        for(WebElement n:verifyResultList)
        {
            String a=n.getText();
            names.add(a);
        }
        return names;
        }

    public List<String> getTextFromEmployeeList(){
        CustomListeners.test.log(Status.PASS,"Getting text from Employee name list ");
        List<String> names=new ArrayList<>();
        for(WebElement n:employeeNameList)
        {
            String a=n.getText();
            names.add(a);
        }
        return names;
    }


    public void clickOnCheckBox(){
        clickOnElement(checkBox);
        CustomListeners.test.log(Status.PASS,"Click on checkBox ");
    }

    public void clickOnDeleteButton(){
        clickOnElement(deleteButton);
        CustomListeners.test.log(Status.PASS,"Click on deleteButton");
    }

    public void acceptPopUpMessage(){
        clickOnElement(deleteRecordPopUp);
        CustomListeners.test.log(Status.PASS,"Accept popup ");
    }

    public void verifyRecordSuccessfullyDeletedMessage(String message){
        verifyThatTextIsDisplayed(successFullyDeletedText, message);
        CustomListeners.test.log(Status.PASS,"Verify message "+message);
    }

    public void verifyNoRecordFoundText(String message){
        verifyThatTextIsDisplayed(noRecordFoundText, message);
        CustomListeners.test.log(Status.PASS,"Verify message "+message);
    }
}
