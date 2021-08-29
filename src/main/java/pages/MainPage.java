package pages;

import base.Base;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage extends Base {
    private static final String SEARCH_RESULT_HEADER = "РЕЗУЛЬТАТЫ ПОИСКА";

    public void mainPageMethods() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#searchsw")
    WebElement searchField;

    @FindBy(xpath = " //input[@id='searchbut']")
    WebElement searchButton;

    @FindBy(xpath = "//span[contains(text(),'Результаты поиска')]")
    WebElement searchResultHeader;

    @FindBy(xpath = "//body/main[1]/div[1]/section[2]/div[2]/div")
    List<WebElement> listOfResults;

    @FindBy(xpath = "//section[1]/div[1]/div[1]/div[2]/span[1]/a[1]")
    WebElement dressSection;

    @FindBy(xpath = "//section[1]/div[3]/div[1]/div[1]/div[2]/div[4]/a[1]")
    WebElement detailsButtonForFirstItem;

    @FindBy(xpath = "//span[contains(text(),'42')]")
    WebElement sizeDress;

    @FindBy(xpath = "//a[contains(text(),'Добавить в корзину')]")
    WebElement addToBasketButton;

    @FindBy(xpath = "//a[@id='tcart-a']")
    WebElement basketIcon;

    public void getSearchField() {
        searchField.getLocation();
    }

    public void clickSearchField() {
        searchField.click();
    }

    public void searchDress() {
        searchField.sendKeys("dress");
        searchButton.getLocation();
        searchButton.click();
    }

    public void verifySearchDress() {
        searchResultHeader.getLocation();
        searchResultHeader.getText();
        Assert.assertEquals(SEARCH_RESULT_HEADER, searchResultHeader.getText());
    }

    public void verifyListOfResultsIsDisplayed() {
        Assert.assertTrue(listOfResults.size() > 0);
    }

    public void getDressSection() {
        dressSection.getLocation();
    }

    public void clickDressSection() {
        dressSection.click();
    }

    public void addFirstDressToBasket() {
        detailsButtonForFirstItem.getLocation();
        detailsButtonForFirstItem.click();
        sizeDress.getLocation();
        sizeDress.click();
        addToBasketButton.getLocation();
        addToBasketButton.click();
    }

    public void getBasketIcon() {
        basketIcon.getLocation();
    }

    public void clickBasketIcon() {
        basketIcon.click();
    }
}
