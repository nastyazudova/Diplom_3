package praktikum;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.pageobject.LogInPage;
import praktikum.pageobject.MainPage;
import praktikum.pageobject.ProfilePage;
import praktikum.api.User;
import praktikum.api.UserChecks;
import praktikum.api.UserClient;
import praktikum.api.UserCredentials;

public class SignOutTest {
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
    @DisplayName("Проверка выхода из аккаунта по кнопке Выход")
    public void checkTransitionToConstructorByConstructorButton()  {
        var user = User.random();
        ValidatableResponse createResponse = client.createUser(user);
        check.checkCreated(createResponse);

        WebDriver driver = factory.getDriver();
        var mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickOnLogIn();

        var logInPage = new LogInPage(driver);
        logInPage.fullFillDataAndSignIn(user.getEmail(), user.getPassword());

        mainPage.clickOnDashboardButton();

        var profilePage = new ProfilePage(driver);
        profilePage.clickOnLogOutButton();

        logInPage.checkSignOutBySignOutButton();

        var creds = UserCredentials.fromUser(user);
        ValidatableResponse loginResponse = client.logIn(creds);
        bearerToken = check.checkLoggedIn(loginResponse);
    }
}
