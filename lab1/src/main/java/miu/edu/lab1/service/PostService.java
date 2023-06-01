package miu.edu.lab1.service;

import miu.edu.lab1.domain.Post;
import miu.edu.lab1.domain.dto.PostDto;

import java.util.List;

public interface PostService {
    public List<Post> findAll();
    PostDto getById(long id);
    void addPost(Post p);
    void deletePost(long id);
    void updatePost(long id, Post p);
    public List<Post> getPostByAuthor(String author);
}
