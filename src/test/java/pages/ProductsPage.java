package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private final By TITLE = By.className("title");
    private final By ADD_BACKPACK_TO_CART_BUTTON = By.id("add-to-cart-sauce-labs-backpack");
    private final By FIRST_ITEM_TITLE = By.xpath("//*[@class=\"inventory_list\"]/div[@class='inventory_item'][1]//div[@data-test='inventory-item-name']");
    private final By FILTER_NAME_A_TO_Z = By.xpath("//select/option[1]");
    private final By FILTER_NAME_Z_TO_A = By.xpath("//select/option[2]");
    private final By FILTER_PRICE_LOW_TO_HIGH = By.xpath("//select/option[3]");
    private final By FILTER_PRICE_HIGH_TO_LOW = By.xpath("//select/option[4]");
    private final By CART = By.className("shopping_cart_link");
    private final String ADD_TO_CART_PATTERN = "//div[text()='%s']/ancestor::div[@data-test='inventory-item']//button[text()='Add to cart']";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы с товаром")
    public void open() {
        driver.get(BASE_URL + "/inventory.html");
    }

    @Step("Проверка открытия страницы с товаром")
    public boolean isPageOpened() {
        return driver.findElement(TITLE).isDisplayed();
    }

    @Step("Проверка выбора фильтра от А до Z")
    public void chooseAToZFilter() {
        driver.findElement(FILTER_NAME_A_TO_Z).click();
    }

    @Step("Проверка выбора фильтра от Z до A")
    public void chooseZToAFilter() {
        driver.findElement(FILTER_NAME_Z_TO_A).click();
    }

    @Step("Проверка выбора фильтра по возростанию цены")
    public void choosePriseLowToHighFilter() {
        driver.findElement(FILTER_PRICE_LOW_TO_HIGH).click();
    }

    @Step("Проверка выбора фильтра по убыванию цены")
    public void choosePriseHighToLowFilter() {
        driver.findElement(FILTER_PRICE_HIGH_TO_LOW).click();
    }

    @Step("Добавить первый товар из списка в корзину")
    public String getFirstItemTitle() {
        return driver.findElement(FIRST_ITEM_TITLE).getText();
    }

    @Step("Добавить товар в корзину")
    public void addBackpackToCart() {
        driver.findElement(ADD_BACKPACK_TO_CART_BUTTON).click();
    }

    @Step("Перейти в корзину")
    public void goToCart() {
        driver.findElement(CART).click();
    }

    @Step("Добавить товар {productName} в корзину")
    public void addToCart (String product) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTERN, product))).click();
    }
}
