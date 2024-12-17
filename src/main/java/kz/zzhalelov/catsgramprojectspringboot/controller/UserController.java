package kz.zzhalelov.catsgramprojectspringboot.controller;

import kz.zzhalelov.catsgramprojectspringboot.exception.InvalidEmailException;
import kz.zzhalelov.catsgramprojectspringboot.exception.UserAlreadyExistException;
import kz.zzhalelov.catsgramprojectspringboot.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserController {
    private final Map<String, User> users = new HashMap<>();


    @GetMapping("/users")
    public Collection<User> findAll() {
        return users.values();
    }

    @PostMapping("/users")
    public User create(@RequestBody User user) {
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new InvalidEmailException("Email is empty");
        }
        if (users.containsKey(user.getEmail())) {
            throw new UserAlreadyExistException("User is already exists");
        }
        users.put(user.getEmail(), user);
        return user;
    }

    @PutMapping("/users")
    public User update(@RequestBody User user) {
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new InvalidEmailException("Email is empty");
        }

        users.put(user.getEmail(), user);
        return user;
    }
}