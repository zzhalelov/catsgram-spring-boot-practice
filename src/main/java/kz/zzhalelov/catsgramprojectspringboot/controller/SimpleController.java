package kz.zzhalelov.catsgramprojectspringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
    @GetMapping("/home")
    public String homePage() {
        return "catsGram";
    }
}