package kz.zzhalelov.catsgramprojectspringboot.service;

import kz.zzhalelov.catsgramprojectspringboot.exception.UserNotFoundException;
import kz.zzhalelov.catsgramprojectspringboot.model.Post;
import kz.zzhalelov.catsgramprojectspringboot.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PostService {
    private final List<Post> posts = new ArrayList<>();
    private final UserService userService;
    int counter = 1;

    public PostService(UserService userService) {
        this.userService = userService;
    }

    public List<Post> findAll() {
        return posts;
    }

    public Post create(Post post) {
        User user = userService.findUserByEmail(post.getAuthor());
        if (user == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        post.setId(getUniqueId());
        posts.add(post);
        return post;
    }

    public Post findById(int id) {
        return posts.stream()
                .filter(post -> post.getId() == id)
                .findFirst()
                .orElseThrow();
    }

    private int getUniqueId() {
        return counter++;
    }
}