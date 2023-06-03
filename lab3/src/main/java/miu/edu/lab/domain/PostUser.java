package miu.edu.lab.domain;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Data
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
    @Fetch(FetchMode.JOIN)
    private List<Post> posts;

    public PostUser(String name, List<Post> posts) {
        this.name = name;
        this.posts = posts;
    }
}