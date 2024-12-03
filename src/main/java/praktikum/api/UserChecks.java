package praktikum.api;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static java.net.HttpURLConnection.*;
import static org.junit.Assert.assertTrue;

public class UserChecks {
    @Step("создался успешно")
    public void checkCreated(ValidatableResponse response) {
        boolean created = response
                .assertThat()
                .statusCode(HTTP_OK)
                .extract()
                .path("success");
        assertTrue(created);
    }

    @Step("удалился")
    public void deleted(ValidatableResponse response) {
        boolean created = response
                .assertThat()
                .statusCode(HTTP_ACCEPTED)
                .extract()
                .path("success");
        assertTrue(created);
    }
}
