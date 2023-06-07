package edu.miu.springsecurity1.service;

import edu.miu.springsecurity1.entity.PostUser;
import edu.miu.springsecurity1.entity.dto.CommentDto;
import edu.miu.springsecurity1.entity.dto.PostDto;
import edu.miu.springsecurity1.entity.dto.PostUserDto;


import java.util.List;

public interface PostUserService {
    List<PostUserDto> findAll();
    PostUserDto getById(long id);
    void addUser(PostUser user);
    void deleteUser(long id);
    void updateUser(long id, PostUser user);
    List<PostDto> getAllPostsByUserId(long id);
    List<PostUserDto> findUsersWithMoreThanOnePost();
    List<PostUserDto> findUsersWithMoreThanNPosts(int n);
    List<PostUserDto> findUsersWhoMadePostsByTitle(String title);
    CommentDto getCommentByIdFromPostByIdFromUserById(long userId, long postId, long commentId);
}
