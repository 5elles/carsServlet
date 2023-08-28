package it.academy.model.repository;

import it.academy.model.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static UserRepository userRepository = new UserRepository();

    public static UserRepository getInstance(){
        return userRepository;
    }

    public List<User> getUsers(){
        final List<User> userList = new ArrayList<>();
        User user1 = new User("admin", "admin");
        User user2 = new User("user", "user");
        userList.add(user1);
        userList.add(user2);
        return userList;
    }

}
