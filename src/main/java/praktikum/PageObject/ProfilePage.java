package praktikum.PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProfilePage {
    private final WebDriver driver;

    private final By orderHistoryButton = By.xpath();

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("проверить успешную регистрацию")
    public void checkSignInSuccess() {
        assertThat(driver.findElement(orderHistoryButton).getText(), containsString("История заказов"));
    }
}
