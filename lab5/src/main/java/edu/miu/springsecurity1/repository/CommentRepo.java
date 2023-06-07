package edu.miu.springsecurity1.repository;

import edu.miu.springsecurity1.entity.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CommentRepo extends CrudRepository<Comment, Long> {
    List<Comment> findAll();
    @Query(value = "SELECT * FROM comment c WHERE c.post_id = :id", nativeQuery = true)
    List<Comment> findByPostId(Long id);
}

