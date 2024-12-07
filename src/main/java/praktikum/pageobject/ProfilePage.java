package praktikum.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProfilePage {
    private final WebDriver driver;

    private final By orderHistoryButton = By.xpath("//a[@href='/account/order-history']");
    private final By constructorButton = By.xpath("//a[@href='/']/p[text()='Конструктор']");
    private final By stellarBurgerButton = By.className("AppHeader_header__logo__2D0X2");
    private final By logOutButton = By.xpath("//button[text()='Выход']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("проверить успешный вход")
    public void checkSignInSuccess() {
        assertThat(driver.findElement(orderHistoryButton).getText(), containsString("История заказов"));
    }

    @Step("нажать на кнопку Конструктор")
    public void clickOnConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    @Step("нажать на кнопку StellarBurger")
    public void clickOnStellarBurgerButton() {
        driver.findElement(stellarBurgerButton).click();
    }

    @Step("нажать на кнопку Выйти")
    public void clickOnLogOutButton() {
        driver.findElement(logOutButton).click();
    }
}
