package miu.edu.lab2.service;

import miu.edu.lab2.domain.User;
import miu.edu.lab2.dto.response.PostDto;
import miu.edu.lab2.dto.response.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();
    UserDto getById(long id);
    void addUser(User user);
    void deleteUser(long id);
    void updateUser(long id, User user);
    List<PostDto> getAllPostsByUserId(long id);
    List<UserDto> findUsersWithMoreThanOnePost();
}
