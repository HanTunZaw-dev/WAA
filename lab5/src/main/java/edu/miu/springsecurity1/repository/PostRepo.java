package edu.miu.springsecurity1.repository;

import edu.miu.springsecurity1.entity.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostRepo extends CrudRepository<Post, Long> {
    List<Post> findAll();

    public Post findById(long id);

    @Query(value = "SELECT * FROM post p WHERE p.title = :title", nativeQuery = true)
    public List<Post> getAllPostsByTitle(String title);

    @Query(value = "SELECT * FROM post p WHERE p.user_id = :id", nativeQuery = true)
    public List<Post> getPostsByUserId(long id);

    @Query(value = "DELETE FROM post p WHERE p.id = :id", nativeQuery = true)
    public void deletePost(long id);

    /*public Post getById(long id);
    public void addPost(Post p);
    public void deletePost(long id);
    public void updatePost(long id, Post p);
    */
}
