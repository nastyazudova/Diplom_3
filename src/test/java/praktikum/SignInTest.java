package praktikum;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.PageObject.*;
import praktikum.api.User;
import praktikum.api.UserChecks;
import praktikum.api.UserClient;
import praktikum.api.UserCredentials;

public class SignInTest {
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
    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    public void checkSignInByLogInButton()  {
        var user = User.random();
        ValidatableResponse createResponse = client.createUser(user);
        check.checkCreated(createResponse);

        WebDriver driver = factory.getDriver();
        var mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickOnLogIn();

        var logInPage = new LogInPage(driver);
        logInPage.FullFillDataAndSignIn(user.getEmail(), user.getPassword());

        mainPage.clickOnDashboardButton();

        var profilePage = new ProfilePage(driver);
        profilePage.checkSignInSuccess();

        var creds = UserCredentials.fromUser(user);
        ValidatableResponse loginResponse = client.logIn(creds);
        bearerToken = check.checkLoggedIn(loginResponse);
    }

    @Test
    @DisplayName("вход через кнопку «Личный кабинет»")
    public void checkSignInByDashboardButton()  {
        var user = User.random();
        ValidatableResponse createResponse = client.createUser(user);
        check.checkCreated(createResponse);

        WebDriver driver = factory.getDriver();
        var mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickOnDashboardButton();

        var logInPage = new LogInPage(driver);
        logInPage.FullFillDataAndSignIn(user.getEmail(), user.getPassword());

        mainPage.clickOnDashboardButton();

        var profilePage = new ProfilePage(driver);
        profilePage.checkSignInSuccess();

        var creds = UserCredentials.fromUser(user);
        ValidatableResponse loginResponse = client.logIn(creds);
        bearerToken = check.checkLoggedIn(loginResponse);
    }

    @Test
    @DisplayName("вход через кнопку в форме регистрации")
    public void checkSignInBySignInButtonOnRegistrationPage()  {
        var user = User.random();
        ValidatableResponse createResponse = client.createUser(user);
        check.checkCreated(createResponse);

        WebDriver driver = factory.getDriver();
        var mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickOnDashboardButton();

        var logInPage = new LogInPage(driver);
        logInPage.clickOnSignUp();

        var registrationPage = new RegistrationPage(driver);
        registrationPage.clickOnSignInButton();

        logInPage.FullFillDataAndSignIn(user.getEmail(), user.getPassword());

        mainPage.clickOnDashboardButton();

        var profilePage = new ProfilePage(driver);
        profilePage.checkSignInSuccess();

        var creds = UserCredentials.fromUser(user);
        ValidatableResponse loginResponse = client.logIn(creds);
        bearerToken = check.checkLoggedIn(loginResponse);
    }

    @Test
    @DisplayName("вход через кнопку в форме восстановления пароля")
    public void checkSignInBySignInButtonOnRecoveryPage()  {
        var user = User.random();
        ValidatableResponse createResponse = client.createUser(user);
        check.checkCreated(createResponse);

        WebDriver driver = factory.getDriver();
        var mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickOnDashboardButton();

        var logInPage = new LogInPage(driver);
        logInPage.clickOnRecoverPasswordButton();

        var recoverPasswordPage = new RecoverPasswordPage(driver);
        recoverPasswordPage.clickOnSignInButton();

        logInPage.FullFillDataAndSignIn(user.getEmail(), user.getPassword());

        mainPage.clickOnDashboardButton();

        var profilePage = new ProfilePage(driver);
        profilePage.checkSignInSuccess();

        var creds = UserCredentials.fromUser(user);
        ValidatableResponse loginResponse = client.logIn(creds);
        bearerToken = check.checkLoggedIn(loginResponse);
    }
}
