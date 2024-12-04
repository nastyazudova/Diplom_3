package praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.PageObject.MainPage;

public class ConstructorTest {
    @Rule
    public DriverRule factory = new DriverRule();

    @Test
    @DisplayName("Проверка работы перехода к разделу Булки")
    public void checkTransitionToBuns()  {
        WebDriver driver = factory.getDriver();

        var mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickOnSaucesButton();
        mainPage.clickOnBunsButton();

        mainPage.checkTransitionToBuns();
    }

    @Test
    @DisplayName("Проверка работы перехода к разделу Соусы")
    public void checkTransitionToSauces()  {
        WebDriver driver = factory.getDriver();

        var mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickOnSaucesButton();

        mainPage.checkTransitionToSauces();
    }

    @Test
    @DisplayName("Проверка работы перехода к разделу Начинки")
    public void checkTransitionToFillings()  {
        WebDriver driver = factory.getDriver();

        var mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickOnFillingsButton();

        mainPage.checkTransitionToFillings();
    }
}
