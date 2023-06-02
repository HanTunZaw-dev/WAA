package miu.edu.lab2.repo;

import miu.edu.lab2.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {
    List<Post> findAll();

    Post findById(long id);
}
