package praktikum.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class LogInPage {

    private final WebDriver driver;
    private final By signUpButton = By.xpath("//a[@href='/register']");
    private final By signInButton = By.xpath("//button[contains(text(),'Войти')]");
    private final By recoverPasswordButton = By.xpath("//a[@href='/forgot-password']");
    private final By emailField = By.xpath("//label[text()='Email']/following-sibling::input");
    private final By passwordField = By.xpath("//label[text()='Пароль']/following-sibling::input");

    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("нажать на кнопку Зарегистрироваться")
    public void clickOnSignUp() {
        driver.findElement(signUpButton).click();
    }

    @Step("заполнить поле Email")
    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("заполнить поле Пароль")
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("нажать на кнопку Войти")
    public void clickOnSignInButton() {
        driver.findElement(signInButton).click();
    }

    @Step("заполнить все поля и нажать кнопку Войти")
    public void fullFillDataAndSignIn(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickOnSignInButton();
    }

    @Step("нажать на кнопку Восстановить пароль")
    public void clickOnRecoverPasswordButton() {
        driver.findElement(recoverPasswordButton).click();
    }

    @Step("проверить выход из аккаунта по кнопке Выход")
    public void checkSignOutBySignOutButton() {
        assertThat(driver.findElement(signInButton).getText(), containsString("Войти"));
    }
}
