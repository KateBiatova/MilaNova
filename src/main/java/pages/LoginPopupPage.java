package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPopupPage extends Base {

    public void loginPopupMethods() {
        PageFactory.initElements(driver, this);
    }

    WebDriverWait wait = new WebDriverWait(driver, 10);

    @FindBy(xpath = "//input[@id='uloglogin']")
    WebElement emailInputField;

    @FindBy(xpath = "//input[@id='ulogpass']")
    WebElement passwordInputField;

    @FindBy(xpath = "//a[@id='makeloginlnk']")
    WebElement enterButton;


    public void getEmailInputField() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='uloglogin']")));
        emailInputField.getLocation();
    }

    public void clickEmailInputField() {
        emailInputField.click();
    }

    public void enterEmail() {
        emailInputField.sendKeys(prop.getProperty("email"));
    }

    public void getPasswordInputField() {
        passwordInputField.getLocation();
    }

    public void clickPasswordInputField() {
        passwordInputField.click();
    }

    public void enterPassword() {
        passwordInputField.sendKeys(prop.getProperty("password"));
    }

    public void getEnterButton() {
        enterButton.getLocation();
    }

    public void clickEnterButton() {
        enterButton.click();
    }

}
