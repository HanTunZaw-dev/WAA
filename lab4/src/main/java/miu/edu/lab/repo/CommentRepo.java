package miu.edu.lab.repo;

import miu.edu.lab.domain.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepo extends CrudRepository<Comment, Long> {
    List<Comment> findAll();
    @Query(value = "SELECT * FROM comment c WHERE c.post_id = :id", nativeQuery = true)
    List<Comment> findByPostId(Long id);
}

