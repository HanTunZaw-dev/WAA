package edu.miu.springsecurity1.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    private Post post;

    public Comment(String name) {
        this.name = name;
    }

    public Comment(String name, Post post) {

        this.name = name;
        this.post = post;
    }
}
