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
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String content;
    private String author;
    //sulai: 15 Apr 2022 removed the CascadeType.ALL
    //as deleting post by Id effect cascade delete the other post with same user_id
    @ManyToOne()
    private PostUser user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<Comment> comments;

    public Post(String title, String content, String author, List<Comment> comments) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.comments = comments;
    }
}
