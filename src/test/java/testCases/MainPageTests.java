package testCases;

import base.Base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainPageTests extends Base {

    @BeforeMethod
    public void setUp(){
        initialization();
        initObjects();
    }

    @Test
    public void searchGoods() {
        mainPage.mainPageMethods();
        mainPage.getSearchField();
        mainPage.clickSearchField();
        mainPage.searchDress();
        mainPage.verifySearchDress();
        mainPage.verifyListOfResultsIsDisplayed();
    }

    @Test
    public void addGoodsToBasket_deleteFromBusket() throws InterruptedException {
        mainPage.mainPageMethods();
        mainPage.getDressSection();
        mainPage.clickDressSection();
        mainPage.addFirstDressToBasket();

        inBasketPopup.inBasketPopupMethods();
        inBasketPopup.getInBasketPopup();
        inBasketPopup.verifyItemAddedIntoBasket();
        inBasketPopup.closeInBasketPopup();

        mainPage.getBasketIcon();
        mainPage.clickBasketIcon();

        basketPage.basketPageMethods();
        basketPage.verifyInBasketHeader();
        basketPage.getDeleteIcon();
        basketPage.clickDeleteIcon();
        basketPage.getEmptyBasketText();
        basketPage.verifyEmptyBasketText();

    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
