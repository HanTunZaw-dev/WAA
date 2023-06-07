package edu.miu.springsecurity1.service.impl;

import edu.miu.springsecurity1.entity.Post;
import edu.miu.springsecurity1.entity.PostUser;
import edu.miu.springsecurity1.entity.dto.CommentDto;
import edu.miu.springsecurity1.entity.dto.PostDto;
import edu.miu.springsecurity1.entity.dto.PostUserDto;
import edu.miu.springsecurity1.repository.PostRepo;
import edu.miu.springsecurity1.repository.PostUserRepo;
import edu.miu.springsecurity1.service.PostService;
import edu.miu.springsecurity1.service.PostUserService;
import edu.miu.springsecurity1.util.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostUserServiceImpl implements PostUserService {

    @Autowired
    PostUserRepo postUserRepo;

    @Autowired
    PostRepo postRepo;

    @Autowired
    PostService postService;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<PostUser, PostUserDto> listMapperUserToDto;

    @Override
    public List<PostUserDto> findAll() {
        return (List<PostUserDto>)listMapperUserToDto.mapList(postUserRepo.findAll(), new PostUserDto());
    }

    @Override
    public PostUserDto getById(long id) {
        return modelMapper.map(postUserRepo.findById(id), PostUserDto.class);
    }

    @Override
    public void addUser(PostUser user) {
        postUserRepo.save(user);
    }

    @Override
    public void deleteUser(long id) {
            postUserRepo.deleteById(id);

    }

    public List<Post> getAllPostsByUser(long id){
        return postUserRepo.findById(id).getPosts();
    }

    @Override
    public void updateUser(long id, PostUser user) {
        if(postUserRepo.existsById(id)) {
            postUserRepo.save(user);
        }
    }

    @Override
    public List<PostDto> getAllPostsByUserId(long id) {
        return postUserRepo.findById(id).getPosts()
                .stream()
                .map(p -> modelMapper.map(p, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PostUserDto> findUsersWithMoreThanOnePost() {
        return postUserRepo.findUsersWithMoreThanOnePost()
                .stream()
                .map(u -> modelMapper.map(u, PostUserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PostUserDto> findUsersWithMoreThanNPosts(int n) {
        return (List<PostUserDto>) listMapperUserToDto.mapList(postUserRepo.findUsersWithMoreThanNPosts(n), new PostUserDto());
    }

    @Override
    public List<PostUserDto> findUsersWhoMadePostsByTitle(String title) {
        System.out.println(title);
        return postRepo.getAllPostsByTitle(title).stream()
                .map(p -> modelMapper.map(p.getUser(), PostUserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    //must return CommentDto, if not return data are loop with post_id field
    public CommentDto getCommentByIdFromPostByIdFromUserById(long userId, long postId, long commentId) {

        List<Post> posts = postRepo.getPostsByUserId(userId);
        Post post = posts.stream().filter(p -> p.getId() == postId).findFirst().get();
        //System.out.println("Post Title is " + post.getTitle());

        return modelMapper.map(post.getComments().stream()
                .filter(c -> c.getId() == commentId).findFirst().get(), CommentDto.class);

    }
}
