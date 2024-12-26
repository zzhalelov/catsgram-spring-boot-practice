package kz.zzhalelov.catsgramprojectspringboot.controller;

import kz.zzhalelov.catsgramprojectspringboot.model.User;
import kz.zzhalelov.catsgramprojectspringboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public Collection<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/users")
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("/users")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @GetMapping("/users/{email}")
    public User findByEmail(@PathVariable String email) {
        return userService.findUserByEmail(email);
    }
}