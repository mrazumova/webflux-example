package by.iba.b;

import java.util.ArrayList;
import java.util.List;

public class RepositoryB {

    private List<User> userList;

    public RepositoryB() {
        userList = new ArrayList<>();

        userList.add(new User(0, "ivan", "ivanov", 24));
        userList.add(new User(1, "petr", "petrov", 32));

    }

    public User getUser() {
        return userList.get(1);
    }
}
