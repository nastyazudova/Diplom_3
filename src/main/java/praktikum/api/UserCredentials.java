package praktikum.api;

public class UserCredentials {
    private final String email;
    private final String password;
    private final String name;

    public UserCredentials(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public static UserCredentials fromUser(praktikum.api.User user) {
        return new UserCredentials(user.getEmail(), user.getPassword(), user.getName());
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
