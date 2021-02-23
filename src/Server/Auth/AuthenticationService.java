package Server.Auth;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public class AuthenticationService {
    private static final Set<User> users = Set.of(
            new User("u1", "p1", "n1"),
            new User("u2", "p2", "n2"),
            new User("u3", "p3", "n3"),
            new User("u4", "p4", "n4")
    );

    public User findByCredentials(String login, String password){
        Optional<User> oUser = users.stream().filter(user -> user.getLogin().equals(login) && user.getPassword().equals(password)).findFirst();
        return oUser.orElse(null);
    }
}
