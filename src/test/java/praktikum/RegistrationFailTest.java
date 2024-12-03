package praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import praktikum.PageObject.LogInPage;
import praktikum.PageObject.MainPage;
import praktikum.PageObject.RegistrationPage;

@RunWith(Parameterized.class)
public class RegistrationFailTest {
    private final String name;
    private final String email;
    private final String password;


    @Rule
    public DriverRule factory = new DriverRule();

    public RegistrationFailTest(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Parameterized.Parameters
    public static Object[][] registrationDataFail() {
        return new Object[][]{
                {"Алена", RandomStringUtils.randomNumeric(5, 15) + "zastya_1011@gmail.com", ""},
                {"Алена", RandomStringUtils.randomNumeric(5, 15) + "zastya_1012@gmail.com", "1"},
                {"Алена", RandomStringUtils.randomNumeric(5, 15) + "zastya_1013@gmail.com", "123"},
                {"Алена", RandomStringUtils.randomNumeric(5, 15) + "zastya_1014@gmail.com", "1234"},
                {"Алена", RandomStringUtils.randomNumeric(5, 15) + "zastya_1015@gmail.com", "12345"}
        };
    }

    @Test
    @DisplayName("Проверка ошибки при регистрации нового пользователя с паролем короче 6 символов")
    public void checkRegistrationFail()  {
        WebDriver driver = factory.getDriver();
        var mainPage = new MainPage(driver);

        mainPage.open();
        mainPage.clickOnDashboardButton();


        var logInPage = new LogInPage(driver);

        logInPage.clickOnSignUp();

        var registrationPage = new RegistrationPage(driver);

        registrationPage.FullFillDataAndRegister(name, email, password);
        registrationPage.checkRegistrationFail();

    }
}
