package praktikum.PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProfilePage {
    private final WebDriver driver;

    private final By orderHistoryButton = By.xpath("//a[@href='/account/order-history']");
    private final By ConstructorButton = By.xpath("//a[@href='/']/p[text()='Конструктор']");
    private final By StellarBurgerButton = By.className("AppHeader_header__logo__2D0X2");
    private final By LogOutButton = By.xpath("//button[text()='Выход']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("проверить успешный вход")
    public void checkSignInSuccess() {
        assertThat(driver.findElement(orderHistoryButton).getText(), containsString("История заказов"));
    }

    @Step("нажать на кнопку Конструктор")
    public void clickOnConstructorButton() {
        driver.findElement(ConstructorButton).click();
    }

    @Step("нажать на кнопку StellarBurger")
    public void clickOnStellarBurgerButton() {
        driver.findElement(StellarBurgerButton).click();
    }

    @Step("нажать на кнопку Выйти")
    public void clickOnLogOutButton() {
        driver.findElement(LogOutButton).click();
    }
}
