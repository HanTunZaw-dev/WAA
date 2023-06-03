package miu.edu.lab.service;

import miu.edu.lab.domain.Post;
import miu.edu.lab.dto.PostDto;

import java.util.List;

public interface PostService {
    List<Post> findAll();
    public PostDto getById(long id);
    public void addPost(PostDto p);
    public void deletePost(long id);
    public void updatePost(long id, Post p);
    public List<PostDto> getAllPostsMatchByTitle(String title);

}
