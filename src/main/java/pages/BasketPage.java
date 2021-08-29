package pages;

import base.Base;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasketPage extends Base {
    private static final String IN_BASKET_HEADER = "У ВАС В КОРЗИНЕ";
    private static final String EMPTY_BASKET_TEXT = "Корзина Заказов Пустая";

    public void basketPageMethods() {
        PageFactory.initElements(driver, this);
    }

    WebDriverWait wait = new WebDriverWait(driver, 10);

    @FindBy(xpath = "//span[contains(text(),'У вас в корзине')]")
    WebElement inBasketHeader;

    @FindBy(xpath = "//div[1]/div[1]/div[2]/a")
    WebElement deleteIcon;

    @FindBy(xpath = "//div[3]/div[1]/div[2]/div[1]")
    WebElement emptyBasketText;

    public void verifyInBasketHeader() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        inBasketHeader.getLocation();
        Assert.assertEquals(IN_BASKET_HEADER, inBasketHeader.getText());
    }

    public void getDeleteIcon() {
        deleteIcon.getLocation();
    }

    public void clickDeleteIcon() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Actions action = new Actions(driver);
        action.moveToElement(deleteIcon).click().build().perform();
        Thread.sleep(2000);
    }

    public void getEmptyBasketText() {

        emptyBasketText.getLocation();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        emptyBasketText.getText();
    }

    public void verifyEmptyBasketText() {
        Assert.assertEquals(EMPTY_BASKET_TEXT, emptyBasketText.getText());
    }

}
