package kz.zzhalelov.catsgramprojectspringboot.service;

import kz.zzhalelov.catsgramprojectspringboot.exception.InvalidEmailException;
import kz.zzhalelov.catsgramprojectspringboot.exception.UserAlreadyExistException;
import kz.zzhalelov.catsgramprojectspringboot.model.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private final Map<String, User> users = new HashMap<>();

    public Collection<User> findAll() {
        return users.values();
    }

    public User create(User user) {
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new InvalidEmailException("Email is empty");
        }
        if (users.containsKey(user.getEmail())) {
            throw new UserAlreadyExistException("User is already exists");
        }
        users.put(user.getEmail(), user);
        return user;
    }

    public User update(User user) {
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new InvalidEmailException("Email is empty");
        }
        users.put(user.getEmail(), user);
        return user;
    }

    public User findUserByEmail(String email) {
        return users.get(email);
    }
}