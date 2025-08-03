package pages;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class BasePage {

    protected final String BASE_URL = "https://www.saucedemo.com/";
    WebDriver driver;
    JavascriptException js = (JavascriptException) driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    }
