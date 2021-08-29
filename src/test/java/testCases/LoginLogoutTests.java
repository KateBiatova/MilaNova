package testCases;

import base.Base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginLogoutTests extends Base {

    @BeforeMethod
    public void setUp(){
        initialization();
        initObjects();
    }

    @Test
    public void userLogin() {
        login();
        myAccountPage.myAccountPageMethods();
        myAccountPage.getMyOrdersHeader();
        myAccountPage.verifyMyOrdersHeader();
        header.getMyAccountText();
        header.verifyMyAccountText();
    }

    @Test
    public void userLogout() {
        userLogin();
        header.logout();

        header.getLoginText();
        header.verifyLoginLinkText();
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
