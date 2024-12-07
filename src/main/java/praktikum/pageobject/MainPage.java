package praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import praktikum.EnvConfig;
import io.qameta.allure.Step;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;


public class MainPage {
    private final WebDriver driver;

    private final By dashboardButton = By.xpath("//a[@href='/account']/p[text()='Личный Кабинет']");
    private final By logInButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By pickIngredients = By.xpath(".//h1[text()='Соберите бургер']");
    private final By bunsButton = By.xpath(".//span[text()='Булки']");
    private final By saucesButton = By.xpath(".//span[text()='Соусы']");
    private final By fillingsButton = By.xpath(".//span[text()='Начинки']");
    private final By ingredientTypeButtonSelected = By.className("tab_tab_type_current__2BEPc");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("открыть главную страницу")
    public void open() {
        driver.get(EnvConfig.BASE_URL);
    }

    @Step("нажать на кнопку Личный кабинет")
    public void clickOnDashboardButton() {
        driver.findElement(dashboardButton).click();
    }

    @Step("нажать на кнопку Войти в аккаунт")
    public void clickOnLogIn() {
        driver.findElement(logInButton).click();
    }

    @Step("проверить переход в Конструктор")
    public void checkTransitionToConstructor() {
        assertThat(driver.findElement(pickIngredients).getText(), containsString("Соберите бургер"));
    }

    @Step("нажать на кнопку Булки")
    public void clickOnBunsButton() {
        driver.findElement(bunsButton).click();
    }

    @Step("нажать на кнопку Соусы")
    public void clickOnSaucesButton() {
        driver.findElement(saucesButton).click();
    }

    @Step("нажать на кнопку Начинки")
    public void clickOnFillingsButton() {
        driver.findElement(fillingsButton).click();
    }

    @Step("проверить переход в раздел Булки")
    public void checkTransitionToBuns() {
        assertThat(driver.findElement(ingredientTypeButtonSelected).getText(), containsString("Булки"));
    }

    @Step("проверить переход в раздел Соусы")
    public void checkTransitionToSauces() {
        assertThat(driver.findElement(ingredientTypeButtonSelected).getText(), containsString("Соусы"));
    }

    @Step("проверить переход в раздел Начинки")
    public void checkTransitionToFillings() {
        assertThat(driver.findElement(ingredientTypeButtonSelected).getText(), containsString("Начинки"));
    }
}
