package miu.edu.lab2.controller;

import miu.edu.lab2.domain.User;
import miu.edu.lab2.dto.response.PostDto;
import miu.edu.lab2.dto.response.UserDto;
import miu.edu.lab2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public List<UserDto> getPostUser(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDto getPostUserById(@PathVariable("id") long id) {
        return  userService.getById(id);
    }

    @GetMapping("{id}/posts")
    public List<PostDto> getAllPostsByUserId(@PathVariable("id") long id)
    {
        return userService.getAllPostsByUserId(id);
    }

    @GetMapping("/usersWithMoreThanOnePosts")
    public List<UserDto> findUsersWithMoreThanOnePost(){
        return userService.findUsersWithMoreThanOnePost();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addPostUser(@RequestBody User user){
        userService.addUser(user);}

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePostUser(@PathVariable("id") long id, @RequestBody User user){
        userService.updateUser(id,user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePostUser(@PathVariable("id") long id){
        userService.deleteUser(id);
    }
}
