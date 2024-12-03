package praktikum.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import praktikum.EnvConfig;
import io.qameta.allure.Step;


public class MainPage {
    private final WebDriver driver;

    private final By dashboardButton = By.xpath("//a[@href='/account']/p[text()='Личный Кабинет']");
    private final By logInButton = By.xpath("//button[text()='Войти в аккаунт']");

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
}
