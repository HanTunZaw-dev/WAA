package miu.edu.lab.controller;

import miu.edu.lab.domain.Comment;
import miu.edu.lab.domain.PostUser;
import miu.edu.lab.dto.CommentDto;
import miu.edu.lab.dto.PostDto;
import miu.edu.lab.dto.PostUserDto;
import miu.edu.lab.service.PostUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class PostUserController {

    @Autowired
    PostUserService postUserService;

    @GetMapping
    public List<PostUserDto> getPostUser(){
        return postUserService.findAll();
    }

    @GetMapping("/{id}")
    public PostUserDto getPostUserById(@PathVariable("id") long id) {return  postUserService.getById(id);}

    @GetMapping("{id}/posts")
    public List<PostDto> getAllPostsByUserId(@PathVariable("id") long id)
    {
        return postUserService.getAllPostsByUserId(id);
    }

    @GetMapping("/usersWithMoreThanOnePosts")
    public List<PostUserDto> findUsersWithMoreThanOnePost(){
        return postUserService.findUsersWithMoreThanOnePost();
    }

    @GetMapping("/usersWithMoreThanNPosts/{num}")
    public List<PostUserDto> findUsersWithMoreThanNPosts(@PathVariable("num") int num){
        return postUserService.findUsersWithMoreThanNPosts(num);
    }

    @GetMapping("/usersWhoMadePostsByTitle/{title}")
    public List<PostUserDto> findUsersWhoMadePostsByTitle(@PathVariable("title") String title){
        return postUserService.findUsersWhoMadePostsByTitle(title);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addPostUser(@RequestBody PostUser user){postUserService.addUser(user);}

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePostUser(@PathVariable("id") long id, @RequestBody PostUser user){
        postUserService.updateUser(id,user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePostUser(@PathVariable("id") long id){
        postUserService.deleteUser(id);
    }


    @GetMapping("{userId}/posts/{postId}/comments/{commentId}/")
    public CommentDto getCommentByIdFromPostByIdFromUserById(@PathVariable("userId") long userId, @PathVariable("postId") long postId, @PathVariable("commentId") long commentId)
    {
        return postUserService.getCommentByIdFromPostByIdFromUserById(userId,postId,commentId);
    }

}
