package miu.edu.lab2.service.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import miu.edu.lab2.domain.Post;
import miu.edu.lab2.domain.User;
import miu.edu.lab2.dto.response.PostDto;
import miu.edu.lab2.dto.response.UserDto;
import miu.edu.lab2.helper.ListMapper;
import miu.edu.lab2.repo.PostRepo;
import miu.edu.lab2.repo.UserRepo;
import miu.edu.lab2.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepo postRepo;

    @Autowired
    UserRepo userRepo;

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<Post, PostDto> listMapperPostToDto;
    @Override
    public List<PostDto> findAll() {
        return (List<PostDto>) listMapperPostToDto.mapList(postRepo.findAll(), new PostDto());
    }

    @Override
    public PostDto getById(long id) {
        return  modelMapper.map(postRepo.findById(id), PostDto.class);
    }

    @Override
    public void addPost(Post p) {
        Post newP = new Post();
        newP.setTitle(p.getTitle());
        newP.setContent(p.getContent());
        newP.setAuthor(p.getAuthor());
        var user = userRepo.findById(p.getId());
        newP.setUser(user);
        postRepo.save(newP);
    }

    @Override
    public void deletePost(long id) {
        postRepo.deleteById(id);
    }

    @Override
    public void updatePost(long id, Post p) {
        if(postRepo.existsById(id)){
            postRepo.save(p);
        }
    }
}
