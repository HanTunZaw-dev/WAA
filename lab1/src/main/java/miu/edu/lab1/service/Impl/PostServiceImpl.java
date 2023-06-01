package miu.edu.lab1.service.Impl;

import lombok.RequiredArgsConstructor;
import miu.edu.lab1.domain.Post;
import miu.edu.lab1.domain.dto.PostDto;
import miu.edu.lab1.repo.PostRepo;
import miu.edu.lab1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private final PostRepo postRepo;

    public PostServiceImpl(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public List<Post> findAll() {
        return postRepo.findAll();
    }

    @Override
    public PostDto getById(long id) {
        /*
        var PostsId = postRepo.getById(id);
        PostDto p = new PostDto();
        p.setId(PostsId.getId());
        p.setTitle(PostsId.getTitle());
        p.setContent(PostsId.getContent());
        p.setAuthor(PostsId.getAuthor());
        return p;
        */
        return modelMapper.map(postRepo.getById(id), PostDto.class);
    }

    @Override
    public void addPost(Post p) {
        postRepo.addPost(modelMapper.map(p, Post.class));
    }

    @Override
    public void deletePost(long id) {
        postRepo.deletePost(id);
    }

    @Override
    public void updatePost(long id, Post p) {
        postRepo.updatePost(id, modelMapper.map(p, Post.class));
    }

    @Override
    public List<Post> getPostByAuthor(String author) {
        return postRepo.getPostByAuthor(author);
    }
}
