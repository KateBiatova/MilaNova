package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Header extends Base {
    private static final String LOGIN_LINK_TEXT = "Войти";
    private static final String MY_ACCOUNT_TEXT = "Мой кабинет";

    public void headerMethods() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(),'Мой кабинет')]")
    WebElement myAccount;

    @FindBy(xpath = "//a[@id='logoutlnk']")
    WebElement logoutLink;

    WebDriverWait wait = new WebDriverWait(driver, 10);

    @FindBy(xpath = "//a[@id='loginlnk']")
    WebElement loginLink;

//    @FindBy(xpath = "//body/div[@id='dlg-flywnd']/div[1]/div[1]")
//    WebElement popup;


    public void getLoginLink() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='loginlnk']")));
        loginLink.getLocation();
    }

    public void clickLoginLink() {
        loginLink.click();
    }

    public void getLoginText() {
        loginLink.getText();
    }

    public void verifyLoginLinkText() {
        Assert.assertEquals(LOGIN_LINK_TEXT, loginLink.getText());
    }

    public void getMyAccountText() {
        myAccount.getText();
    }

    public void verifyMyAccountText() {
        org.junit.Assert.assertEquals(MY_ACCOUNT_TEXT, myAccount.getText());
    }

    public void getLogoutLink() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='logoutlnk']")));
        logoutLink.getLocation();
    }

    public void logout() {
        getLogoutLink();
        logoutLink.click();
    }

    public void getMyAccountLink() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Мой кабинет')]/..")));
        myAccount.getLocation();
    }

    public void clickMyAccountLink() {
        myAccount.click();
    }

    public void get() {
        myAccount.click();
    }
}
