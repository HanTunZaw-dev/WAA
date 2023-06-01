package miu.edu.lab1.controller;

import miu.edu.lab1.domain.Post;
import miu.edu.lab1.domain.PostV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostResourceController {

    @GetMapping(value = "/posts/header", headers = "X-API-VERSION=1")
    public Post headerV1(){ return new Post(1,"Post V1 Title", "Post V1 Content", "Post V1 Author");}

    @GetMapping(value = "/posts/header", headers = "X-API-VERSION=2")
    public PostV2 headerV2(){ return new PostV2(1,"Post V2 Title", "Post V2 Content", "Post V2 Author");}
}
