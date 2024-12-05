package praktikum.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoverPasswordPage {
    private final WebDriver driver;

    private final By signInButton = By.xpath("//a[@href='/login']");

    public RecoverPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("нажать на кнопку Войти")
    public void clickOnSignInButton() {
        driver.findElement(signInButton).click();
    }
}
