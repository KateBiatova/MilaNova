package testCases;

import base.Base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAccountTests extends Base {

    @BeforeMethod
    public void setUp() {
        initialization();
        initObjects();
        login();
    }

    @Test
    public void checkUserAddress() {
        header.headerMethods();
        header.getMyAccountLink();
        header.clickMyAccountLink();

        myAccountPage.myAccountPageMethods();
        myAccountPage.getUserAddressTab();
        myAccountPage.clickUserAddressTab();
        myAccountPage.getCurrentAddress();
        myAccountPage.getTextCurrentAddress();
        myAccountPage.verifyCurrentAddress();
    }

    @Test
    public void checkUserPersonalData() {
        header.headerMethods();
        header.getMyAccountLink();
        header.clickMyAccountLink();

        myAccountPage.myAccountPageMethods();
        myAccountPage.getUserDataTab();
        myAccountPage.clickUserDataTab();
        myAccountPage.getValuetUserNameField();
        myAccountPage.verifyUserName();
        myAccountPage.getValueUserPhoneNumberField();
        myAccountPage.verifyUserPhoneNumber();

    }

    @Test
    public void changeUserAddress() {
        header.headerMethods();
        header.getMyAccountLink();
        header.clickMyAccountLink();

        myAccountPage.myAccountPageMethods();
        myAccountPage.getUserAddressTab();
        myAccountPage.clickUserAddressTab();
        myAccountPage.changeAddress();

        myAccountPage.verifyAddressWasChanged();
        myAccountPage.setDefaultAddress();
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
