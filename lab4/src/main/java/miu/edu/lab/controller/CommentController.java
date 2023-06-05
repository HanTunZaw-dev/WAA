package miu.edu.lab.controller;

import miu.edu.lab.domain.Comment;
import miu.edu.lab.dto.CommentDto;
import miu.edu.lab.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {
    @Autowired
    CommentService commentService;

//    @Autowired
//    ModelMapper modelMapper;

    @GetMapping
    public List<CommentDto> getComment(){
        System.out.println("================ controller getComment ====================");
       return commentService.findAll();
    }
    @GetMapping("/post/{id}")
    public List<CommentDto> getByPostId(@PathVariable("id")Long id){
        System.out.println("================ controller ====================");
        return commentService.getByPostId(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addComment(@RequestBody CommentDto c){
        commentService.addComment(c);
    }
}
