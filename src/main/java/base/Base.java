package base;

import pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public static WebDriver driver;
    public static Properties prop;
    protected static Header header;
    protected static LoginPopupPage loginPopup;
    protected static MyAccountPage myAccountPage;
    protected static Base base;
    protected static MainPage mainPage;
    protected static InBasketPopup inBasketPopup;
    protected static BasketPage basketPage;

    public static void initialization() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.setProperty("webdriver.chrome.driver", prop.getProperty("driverPath_chrome"));
        driver = new ChromeDriver();

//        System.setProperty("webdriver.firefox.driver", prop.getProperty("driverPath_firefox"));
//        System.setProperty("webdriver.firefox.bin","C:/Program Files/Mozilla Firefox/firefox.exe");
//        driver= new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Long.parseLong(prop.getProperty("timeout")), TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("timeout")), TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));
    }

    public static void initObjects() {
        header = new Header();
        loginPopup = new LoginPopupPage();
        myAccountPage = new MyAccountPage();
        base = new Base();
        mainPage = new MainPage();
        inBasketPopup = new InBasketPopup();
        basketPage = new BasketPage();
    }

    public void login() {
        header.headerMethods();
        header.getLoginLink();
        header.clickLoginLink();

        loginPopup.loginPopupMethods();
        loginPopup.getEmailInputField();
        loginPopup.clickEmailInputField();
        loginPopup.enterEmail();
        loginPopup.getPasswordInputField();
        loginPopup.clickPasswordInputField();
        loginPopup.enterPassword();
        loginPopup.getEnterButton();
        loginPopup.clickEnterButton();
    }
}
