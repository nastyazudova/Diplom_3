package praktikum.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

@Data
@AllArgsConstructor
public class User {
    private final String email;
    private final String password;
    private final String name;

    public static User random() {
        return new User("jack" + RandomStringUtils.randomNumeric(5, 15) + "@yandex.ru",
                "P@ssw0rd123", "Sparrow");
    }

    public static User sixSignsPassword() {
        return new User("jack" + RandomStringUtils.randomNumeric(5, 15) + "@yandex.ru",
                "123456", "Sparrow");
    }

    public static User sevenSignsPassword() {
        return new User("jack" + RandomStringUtils.randomNumeric(5, 15) + "@yandex.ru",
                "1234567", "Sparrow");
    }

    public static User thirteenSignsPassword() {
        return new User("jack" + RandomStringUtils.randomNumeric(5, 15) + "@yandex.ru",
                "1234567891011", "Sparrow");
    }
}

