package edu.miu.springsecurity1.controller;

import edu.miu.springsecurity1.entity.Post;
import edu.miu.springsecurity1.entity.dto.PostDto;
import edu.miu.springsecurity1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    PostService postService;

    //for both posts/ and posts?filter=Tornado Warning in MidWest
    @GetMapping
    public List<PostDto> getPost(@RequestParam(value = "filter", required = false) String title){
        return title==null ? postService.findAll() : postService.getAllPostsMatchByTitle(title);
    }

    @GetMapping("/{id}")
    public PostDto getPostById(@PathVariable("id") long id){
        return postService.getById(id);
    }

    //http
    @GetMapping("/getAllPostsByTitle/{t}")
    public List<PostDto> getAllPostsByTitle(@PathVariable("t") String title){
        //System.out.println(title);
        return postService.getAllPostsMatchByTitle(title);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addPost(@RequestBody PostDto post){
        postService.addPost(post);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePost(@PathVariable("id") long id){
        System.out.println("===========CONTROLLER - DELETE BY ID: " + id + "===========");
        postService.deletePost(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  void updatePost(@PathVariable("id") long id, @RequestBody Post p){
        postService.updatePost(id, p);
    }
}
