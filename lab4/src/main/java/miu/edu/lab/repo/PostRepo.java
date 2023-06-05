package miu.edu.lab.repo;

import miu.edu.lab.domain.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepo extends CrudRepository<Post, Long> {
    List<Post> findAll();

    public Post findById(long id);

    @Query(value = "SELECT * FROM post p WHERE p.title = :title", nativeQuery = true)
    public List<Post> getAllPostsByTitle(String title);

    @Query(value = "SELECT * FROM post p WHERE p.user_id = :id", nativeQuery = true)
    public List<Post> getPostsByUserId(long id);


    /*public Post getById(long id);
    public void addPost(Post p);
    public void deletePost(long id);
    public void updatePost(long id, Post p);
    */
}
