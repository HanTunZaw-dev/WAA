package edu.miu.springsecurity1.controller;

//import miu.edu.lab.aspect.annotation.ExecutionTime;

import edu.miu.springsecurity1.entity.PostUser;
import edu.miu.springsecurity1.entity.dto.CommentDto;
import edu.miu.springsecurity1.entity.dto.PostDto;
import edu.miu.springsecurity1.entity.dto.PostUserDto;
import edu.miu.springsecurity1.service.PostUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/users")
public class PostUserController {

    @Autowired
    PostUserService postUserService;

    @GetMapping
    public List<PostUserDto> getPostUser(){
        //make fake exception to test aspect log - @AfterThrowing, @Around
//        int[] arr = new int[3];
//        System.out.println(arr[5]);
        return postUserService.findAll();
    }

    //@ExecutionTime
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
