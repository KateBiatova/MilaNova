package pages;

import base.Base;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends Base {
    private static final String MY_ORDER_HEADER = "МОИ ЗАКАЗЫ";
    private static final String USER_NAME = "Karina";
    private static final String USER_PHONE_NUMBER = "380501234567";
    private static final String CURRENT_ADDRESS = "Город: Первомайск\n" +
            "Полный адрес: Киевская область, Первомайск, ул. Первомайская, д.1";
    private static final String CHANGED_ADDRESS = "Город: Первомайск\n" +
            "Полный адрес: Запорожская область, Первомайск, ул. Козацкая, д.2";

    public void myAccountPageMethods() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(),'Мои заказы')]")
    WebElement myOrdersHeader;

    @FindBy(xpath = "//span[contains(text(),'Адреса доставки')]/..")
    WebElement userAddress;

    @FindBy(xpath = "//span[contains(text(),'Личные данные')]/..")
    WebElement userDataTab;

    @FindBy(css = "tr:nth-child(1) td.frmelem > input.field")
    WebElement userNameField;

    @FindBy(css = "tr:nth-child(2) td.frmelem > input.field")
    WebElement userPhoneNumber;

    @FindBy(css = "div.pmain:nth-child(6) > div:nth-child(4)")
    WebElement currentAddress;

    @FindBy(xpath = "//tbody/tr[1]/td[2]/select[1]")
    WebElement regionDropdown;

    @FindBy(xpath = "//option[contains(text(),'Запорожская область')]")
    WebElement newRegion;

    @FindBy(xpath = "//tbody/tr[3]/td[1]/input[1]")
    WebElement applyAddress;

    @FindBy(css = "td.frmelem:nth-child(2) > input.field")
    WebElement cityInputField;

    @FindBy(xpath = "//tbody/tr[1]/td[4]/input[1]")
    WebElement streetInputField;

    @FindBy(xpath = "//tbody/tr[2]/td[1]/input[1]")
    WebElement houseInputField;

    public void getMyOrdersHeader() {
        myOrdersHeader.getText();
    }

    public void verifyMyOrdersHeader() {
        Assert.assertEquals(MY_ORDER_HEADER, myOrdersHeader.getText());
    }

    public void getUserAddressTab() {
        userAddress.getLocation();
    }
    public void clickUserAddressTab() {
        userAddress.click();
    }

    public void getCurrentAddress() {
        currentAddress.getLocation();
    }

    public void getTextCurrentAddress() {
        currentAddress.getText();
    }

    public void verifyCurrentAddress() {
        Assert.assertEquals(CURRENT_ADDRESS, currentAddress.getText());
    }

    public void getUserDataTab() {
        userDataTab.getLocation();
    }

    public void clickUserDataTab() {
        userDataTab.click();
    }

    public void getValuetUserNameField() {
        userNameField.getAttribute("value");
    }

    public void verifyUserName() {
        Assert.assertEquals(USER_NAME, userNameField.getAttribute("value"));
    }

    public void getValueUserPhoneNumberField() {
        userPhoneNumber.getAttribute("value");
    }

    public void verifyUserPhoneNumber() {
        Assert.assertEquals(USER_PHONE_NUMBER, userPhoneNumber.getAttribute("value"));
    }

    public  void changeAddress() {
        regionDropdown.getLocation();
        regionDropdown.click();
        newRegion.getLocation();
        newRegion.click();
        cityInputField.getLocation();
        cityInputField.click();
        cityInputField.sendKeys("Первомайск");
        streetInputField.getLocation();
        streetInputField.click();
        streetInputField.sendKeys("Козацкая");
        houseInputField.getLocation();
        houseInputField.click();
        houseInputField.sendKeys("2");
        applyAddress.getLocation();
        applyAddress.click();
    }

    public void verifyChangedAddress() {
        Assert.assertEquals(CHANGED_ADDRESS, currentAddress.getText());
    }

    public void verifyAddressWasChanged() {
        getUserDataTab();
        clickUserDataTab();
        getUserAddressTab();
        clickUserAddressTab();
        getCurrentAddress();
        getTextCurrentAddress();
        verifyChangedAddress();
    }

    public void setDefaultAddress() {
        regionDropdown.getLocation();
        regionDropdown.click();
        newRegion.getLocation();
        newRegion.click();
        cityInputField.getLocation();
        cityInputField.click();
        cityInputField.sendKeys("Первомайск");
        streetInputField.getLocation();
        streetInputField.click();
        streetInputField.sendKeys("Первомайская");
        houseInputField.getLocation();
        houseInputField.click();
        houseInputField.sendKeys("1");
        applyAddress.getLocation();
        applyAddress.click();
    }
}
