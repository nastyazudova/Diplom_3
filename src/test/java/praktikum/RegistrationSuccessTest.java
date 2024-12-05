package praktikum;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import praktikum.api.User;
import praktikum.api.UserChecks;
import praktikum.api.UserClient;
import praktikum.api.UserCredentials;
import praktikum.pageobject.LogInPage;
import praktikum.pageobject.MainPage;
import praktikum.pageobject.RegistrationPage;

public class RegistrationSuccessTest {
    private UserClient client = new UserClient();
    private UserChecks check = new UserChecks();

    String bearerToken;

    @Rule
    public DriverRule factory = new DriverRule();

    @After
    public void deleteUser() {
        if (bearerToken != null) {
            ValidatableResponse response = client.delete(bearerToken);
            check.deleted(response);
        }
    }

    @Test
    @DisplayName("Проверка регистрации нового пользователя (пароль 6 символов)")
    public void checkRegistrationSuccessSixSigns()  {
        var user = User.sixSignsPassword();

        WebDriver driver = factory.getDriver();

        var mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickOnLogIn();

        var logInPage = new LogInPage(driver);
        logInPage.clickOnSignUp();

        var registrationPage = new RegistrationPage(driver);
        registrationPage.fullFillDataAndRegister(user.getName(),user.getEmail(), user.getPassword());
        registrationPage.checkRegistrationSuccess();

        var creds = UserCredentials.fromUser(user);
        ValidatableResponse loginResponse = client.logIn(creds);
        bearerToken = check.checkLoggedIn(loginResponse);
    }

    @Test
    @DisplayName("Проверка регистрации нового пользователя (пароль 7 символов)")
    public void checkRegistrationSuccessSevenSigns()  {
        var user = User.sevenSignsPassword();

        WebDriver driver = factory.getDriver();

        var mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickOnLogIn();

        var logInPage = new LogInPage(driver);
        logInPage.clickOnSignUp();

        var registrationPage = new RegistrationPage(driver);
        registrationPage.fullFillDataAndRegister(user.getName(),user.getEmail(), user.getPassword());
        registrationPage.checkRegistrationSuccess();

        var creds = UserCredentials.fromUser(user);
        ValidatableResponse loginResponse = client.logIn(creds);
        bearerToken = check.checkLoggedIn(loginResponse);
    }

    @Test
    @DisplayName("Проверка регистрации нового пользователя (пароль 13 символов)")
    public void checkRegistrationSuccessThirteenSigns()  {
        var user = User.thirteenSignsPassword();

        WebDriver driver = factory.getDriver();

        var mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickOnLogIn();

        var logInPage = new LogInPage(driver);
        logInPage.clickOnSignUp();

        var registrationPage = new RegistrationPage(driver);
        registrationPage.fullFillDataAndRegister(user.getName(),user.getEmail(), user.getPassword());
        registrationPage.checkRegistrationSuccess();

        var creds = UserCredentials.fromUser(user);
        ValidatableResponse loginResponse = client.logIn(creds);
        bearerToken = check.checkLoggedIn(loginResponse);
    }
}
