package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class InBasketPopup extends Base {

    public void inBasketPopupMethods() {
        PageFactory.initElements(driver, this);
    }

    WebDriverWait wait = new WebDriverWait(driver, 10);

    @FindBy(xpath = "//div[@id='cart-flywnd']")
    WebElement inBasketPopup;

    @FindBy(xpath = "//body/div[@id='cart-flywnd']/div[2]/div[1]/div[3]/div[1]")
    WebElement goodsInBasket;

    @FindBy(xpath = "//body/div[@id='cart-flywnd']/div[2]/div[1]/div[1]/a[1]")
    WebElement closeInBasketPopup;

    public void getInBasketPopup() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='cart-flywnd']")));
        inBasketPopup.getLocation();
    }

    public void verifyItemAddedIntoBasket() {
        goodsInBasket.isDisplayed();
    }

    public void closeInBasketPopup () {
        closeInBasketPopup.getLocation();
        closeInBasketPopup.click();
    }
}
