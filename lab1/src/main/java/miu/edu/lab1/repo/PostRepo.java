package miu.edu.lab1.repo;

import miu.edu.lab1.domain.Post;
import java.util.List;

public interface PostRepo {
    List<Post> findAll();
    public Post getById(long id);
    public void addPost(Post p);
    public void deletePost(long id);
    public void updatePost(long id, Post p);
    public List<Post> getPostByAuthor(String author);

}
