package kz.zzhalelov.catsgramprojectspringboot.model;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class Post {
    private int id;
    private final String author;
    private final Instant creationDate = Instant.now();
    private String description;
    private String photoUrl;

    public Post(String author, String description, String photoUrl) {
        this.author = author;
        this.description = description;
        this.photoUrl = photoUrl;
    }
}