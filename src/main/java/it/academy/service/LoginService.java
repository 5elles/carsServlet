package it.academy.service;

import it.academy.model.entity.User;

import java.util.ArrayList;
import java.util.List;

public class LoginService {
    private final List<User> userList = new ArrayList<>();

    public LoginService(){
    User user1 = new User("admin", "admin");
    User user2 = new User("user", "user");
    userList.add(user1);
    userList.add(user2);
    }

    public boolean checkCredentials(String login, String password){
        for (User user : userList){
            if (user.getLogin().equalsIgnoreCase(login) && user.getPassword().equals(password)) return true;
        }
        return false;
    }
}
