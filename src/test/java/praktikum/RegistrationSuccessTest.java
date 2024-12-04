package praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import praktikum.PageObject.LogInPage;
import praktikum.PageObject.MainPage;
import praktikum.PageObject.RegistrationPage;
import praktikum.api.UserChecks;
import praktikum.api.UserClient;

@RunWith(Parameterized.class)
public class RegistrationSuccessTest {
    private final String name;
    private final String email;
    private final String password;

    @Rule
    public DriverRule factory = new DriverRule();

    public RegistrationSuccessTest(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Parameterized.Parameters
    public static Object[][] registrationDataSuccess() {
        return new Object[][]{
                {"Алена", RandomStringUtils.randomNumeric(5, 15) + "zastya_101@gmail.com", "123456"},
                {"Алена", RandomStringUtils.randomNumeric(5, 15) + "zastya_102@gmail.com", "1234567"},
                {"Алена", RandomStringUtils.randomNumeric(5, 15) + "zastya_103@gmail.com", "123456891011"}
        };
    }

    @Test
    @DisplayName("Проверка регистрации нового пользователя")
    public void checkRegistrationSuccess()  {
        WebDriver driver = factory.getDriver();

        var mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickOnLogIn();

        var logInPage = new LogInPage(driver);
        logInPage.clickOnSignUp();

        var registrationPage = new RegistrationPage(driver);
        registrationPage.FullFillDataAndRegister(name, email, password);
        registrationPage.checkRegistrationSuccess();
    }
}
