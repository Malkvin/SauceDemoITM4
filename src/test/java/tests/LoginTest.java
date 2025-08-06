package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest{

    @Test
    public void checkLoginWithoutPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "Сообщение не соответствует");
    }

    @Test
    public void checkLoginWithoutUsername() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Сообщение не соответствует");
    }

    @Test
    public void checkLoginWithNegativeValues() {
        loginPage.open();
        loginPage.login("test", "test");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Сообщение не соответствует");
    }

    @Test(retryAnalyzer = Retry.class)
    public void checkLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        assertTrue(productsPage.isPageOpened());
    }

    @DataProvider(name = "LoginData")
    public Object[][] loginData() {
        return new Object[][] {
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"test", "test", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test (dataProvider = "LoginData")
    public void checkLoginWithNegativeValue1(String user, String password, String expectedMessage) {
        loginPage.open();
        loginPage.login(user, password);
        Assert.assertEquals(loginPage.getErrorMessage(),
                expectedMessage,
                "Сообщение не соответствует");
    }
}
