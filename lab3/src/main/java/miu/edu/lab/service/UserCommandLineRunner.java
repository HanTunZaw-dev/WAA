package miu.edu.lab.service;

import miu.edu.lab.domain.Comment;
import miu.edu.lab.domain.Post;
import miu.edu.lab.domain.PostUser;
import miu.edu.lab.repo.PostUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserCommandLineRunner implements CommandLineRunner {

    @Autowired
    PostUserRepo postUserRepo;

    @Override
    public void run(String... args) throws Exception {
//        setData();
    }

    private void setData() {
        Comment comment = new Comment("Hello comment");

        Post post = new Post("A","B","C", List.of(comment));

        //comment.setPost(post);

        PostUser postUser = new PostUser("C", List.of(post));
        //postUserRepo.save(postUser);
    }
}
