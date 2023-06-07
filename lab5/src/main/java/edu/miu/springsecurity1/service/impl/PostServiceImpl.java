package edu.miu.springsecurity1.service.impl;

import edu.miu.springsecurity1.entity.Comment;
import edu.miu.springsecurity1.entity.Post;
import edu.miu.springsecurity1.entity.dto.PostDto;
import edu.miu.springsecurity1.repository.PostRepo;
import edu.miu.springsecurity1.repository.PostUserRepo;
import edu.miu.springsecurity1.service.CommentService;
import edu.miu.springsecurity1.service.PostService;
import edu.miu.springsecurity1.util.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepo postRepo;

    @Autowired
    PostUserRepo postUserRepo;

    @Autowired
    CommentService commentService;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<Post, PostDto> listMapperPostToDto;

    @Override
    public List<PostDto> findAll() {
        return (List<PostDto>)listMapperPostToDto.mapList(postRepo.findAll(), new PostDto());
    }

    @Override
    public PostDto getById(long id) {
        return  modelMapper.map(postRepo.findById(id), PostDto.class);
    }

    @Override
    public void addPost(PostDto p) {
        // --- for join column data save ---
        Post newP = new Post();
        newP.setTitle(p.getTitle());
        newP.setAuthor(p.getAuthor());
        newP.setContent(p.getContent());
        var user = postUserRepo.findById(p.getUserId());
        newP.setUser(user);
        postRepo.save(newP);
    }

    @Override
    public void deletePost(long id) {
        System.out.println("===========SERVICE - DELETE BY ID: " + id + "===========");
        postRepo.deleteById(id);

    }

    public List<Comment> getAllCommentsByPostId(long id){
        return postRepo.findById(id).getComments();
    }

    @Override
    public void updatePost(long id, Post p) {
        if(postRepo.existsById(id)){
            postRepo.save(p);
        }
    }

    @Override
    //must return PostDto, with Post - data return are all loop in user
    public List<PostDto> getAllPostsMatchByTitle(String title) {
        return (List<PostDto>)listMapperPostToDto.mapList(postRepo.getAllPostsByTitle(title), new PostDto());
    }
}
