package praktikum.api;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class UserClient {
    private static final String BASE_URI = "https://stellarburgers.nomoreparties.site";
    private static final String BASE_PATH = "/api/";
    private static final String USER_PATH = "auth";

    public RequestSpecification spec() {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .basePath(BASE_PATH)
                ;
    }

    @Step("создать пользователя")
    public ValidatableResponse createUser(praktikum.api.User user) {
        return spec()
                .body(user)
                .when()
                .post(USER_PATH + "/register")
                .then().log().all();
    }

    @Step("удалить пользователя")
    public ValidatableResponse delete(String bearerToken) {
        return spec()
                .headers("Content-type", "application/json", "Authorization", "Bearer" + bearerToken)
                .when()
                .delete(USER_PATH + "/user")
                .then().log().all();
    }
}
