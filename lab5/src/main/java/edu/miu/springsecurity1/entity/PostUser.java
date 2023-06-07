package edu.miu.springsecurity1.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PostUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    //@OneToMany(cascade = CascadeType.PERSIST)//when user delete, it won't delete posts
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Post> posts;

    public PostUser(String name, List<Post> posts) {
        this.name = name;
        this.posts = posts;
    }
}