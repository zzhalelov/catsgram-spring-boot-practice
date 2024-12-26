package kz.zzhalelov.catsgramprojectspringboot.controller;

import kz.zzhalelov.catsgramprojectspringboot.model.Post;
import kz.zzhalelov.catsgramprojectspringboot.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/posts")
    public List<Post> findAll() {
        return postService.findAll();
    }

    @PostMapping("/posts")
    public Post create(@RequestBody Post post) {
        return postService.create(post);
    }

    @GetMapping("/posts/{id}")
    public Post findById(@PathVariable int id) {
        return postService.findById(id);
    }
}