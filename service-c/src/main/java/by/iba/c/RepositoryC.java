package by.iba.c;


import java.util.ArrayList;
import java.util.List;

public class RepositoryC {

    private List<User> userList;

    public RepositoryC() {
        userList = new ArrayList<>();

        userList.add(new User(0, "ivan", "ivanov", 24));
        userList.add(new User(1, "petr", "petrov", 32));

    }

    public User getUser() {
        return userList.get(0);
    }
}
