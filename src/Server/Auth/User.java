package Server.Auth;

import java.util.Objects;

public class User {
    private String login;
    private String password;
    private String name;

    public User (String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        User targetUser = (User) o;
        return Objects.equals(login, targetUser.getLogin()) && Objects.equals(password, targetUser.getPassword()) && Objects.equals(name, targetUser.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, name);
    }
}
