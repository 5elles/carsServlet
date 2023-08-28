package it.academy.service;

import it.academy.model.entity.User;
import it.academy.model.repository.UserRepository;
import java.util.List;

public class LoginService {

    public boolean checkCredentials(String login, String password){
        List<User> users = UserRepository.getInstance().getUsers();
        for (User user : users){
            if (user.getLogin().equalsIgnoreCase(login) && user.getPassword().equals(password)) return true;
        }
        return false;
    }
}
