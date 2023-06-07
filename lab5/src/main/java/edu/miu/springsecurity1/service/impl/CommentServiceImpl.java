package edu.miu.springsecurity1.service.impl;

import edu.miu.springsecurity1.entity.Comment;
import edu.miu.springsecurity1.entity.dto.CommentDto;
import edu.miu.springsecurity1.repository.CommentRepo;
import edu.miu.springsecurity1.repository.PostRepo;
import edu.miu.springsecurity1.service.CommentService;
import edu.miu.springsecurity1.util.ListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    PostRepo postRepo;

//    @Autowired
//    ModelMapper modelMapper;

    @Autowired
    ListMapper<Comment, CommentDto> listMapperCommentToDto;

    @Override
    public List<CommentDto> findAll() {
        return (List<CommentDto>) listMapperCommentToDto.mapList(commentRepo.findAll(), new CommentDto());
    }

    @Override
    public List<CommentDto> getByPostId(long id) {
        System.out.println("================ service ====================");
        return (List<CommentDto>) listMapperCommentToDto.mapList(commentRepo.findByPostId(id), new CommentDto());
    }

    @Override
    public void addComment(CommentDto c) {
        Comment newCmt = new Comment();
        newCmt.setName(c.getName());
        var post = postRepo.findById(c.getPostId());
        newCmt.setPost(post);
        commentRepo.save(newCmt);
    }

    @Override
    public void deleteComment(long id) {
        if(commentRepo.existsById(id)){
            commentRepo.deleteById(id);
        }
    }
}
