package praktikum.PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class RegistrationPage {
    private final WebDriver driver;

    private final By nameField = By.xpath("//label[text()='Имя']/following-sibling::input");
    private final By emailField = By.xpath("//label[text()='Email']/following-sibling::input");
    private final By passwordField = By.xpath("//label[text()='Пароль']/following-sibling::input");
    private final By registrationButton = By.xpath("//button[text()='Зарегистрироваться']");
    private final By RegistrationSuccess = By.xpath("//button[contains(text(),'Войти')]");
    private final By RegistrationFail = By.xpath(".//p[text()='Некорректный пароль']");
    private final By SignInButton = By.xpath("//a[@href='/login']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("заполнить поле Имя")
    public void SetName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    @Step("заполнить поле Email")
    public void SetEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("заполнить поле Пароль")
    public void SetPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("нажать на кнопку Зарегистрироваться")
    public void clickOnRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    @Step("заполнить все поля регистрации и нажать кнопку Зарегистрироваться")
    public void FullFillDataAndRegister (String name, String email, String password) {
        SetName(name);
        SetEmail(email);
        SetPassword(password);
        clickOnRegistrationButton();
    }

    @Step("проверить успешную регистрацию")
    public void checkRegistrationSuccess() {
        assertThat(driver.findElement(RegistrationSuccess).getText(), containsString("Войти"));
    }

    @Step("проверить что регистрация не прошла")
    public void checkRegistrationFail() {
        assertThat(driver.findElement(RegistrationFail).getText(), containsString("Некорректный пароль"));
    }

    @Step("нажать на кнопку Войти")
    public void clickOnSignInButton() {
        driver.findElement(SignInButton).click();
    }
}
