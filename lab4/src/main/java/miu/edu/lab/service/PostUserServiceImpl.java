package miu.edu.lab.service;

import miu.edu.lab.domain.Comment;
import miu.edu.lab.domain.Post;
import miu.edu.lab.domain.PostUser;
import miu.edu.lab.dto.CommentDto;
import miu.edu.lab.dto.PostDto;
import miu.edu.lab.dto.PostUserDto;
import miu.edu.lab.helper.ListMapper;
import miu.edu.lab.repo.PostRepo;
import miu.edu.lab.repo.PostUserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostUserServiceImpl implements PostUserService{

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
