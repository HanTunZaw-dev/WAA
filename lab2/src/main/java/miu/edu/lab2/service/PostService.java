package miu.edu.lab2.service;

import miu.edu.lab2.domain.Post;
import miu.edu.lab2.dto.response.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findAll();
    public PostDto getById(long id);
    public void addPost(Post p);
    public void deletePost(long id);
    public void updatePost(long id, Post p);
}
