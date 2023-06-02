package miu.edu.lab2.service.Impl;

import miu.edu.lab2.domain.User;
import miu.edu.lab2.dto.response.PostDto;
import miu.edu.lab2.dto.response.UserDto;
import miu.edu.lab2.helper.ListMapper;
import miu.edu.lab2.repo.UserRepo;
import miu.edu.lab2.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<User, UserDto> listMapperUserToDto;
    @Override
    public List<UserDto> findAll() {
        return (List<UserDto>) listMapperUserToDto.mapList(userRepo.findAll(), new UserDto());
    }

    @Override
    public UserDto getById(long id) {
        return modelMapper.map(userRepo.findById(id), UserDto.class);
    }

    @Override
    public void addUser(User user) {
        userRepo.save(user);
    }

    @Override
    public void deleteUser(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public void updateUser(long id, User user) {
        if(userRepo.existsById(id)) {
            userRepo.save(user);
        }
    }

    @Override
    public List<PostDto> getAllPostsByUserId(long id) {
        return userRepo.findById(id).getPosts()
                .stream()
                .map(p -> modelMapper.map(p, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findUsersWithMoreThanOnePost() {
        return userRepo.findUsersWithMoreThanOnePost()
                .stream()
                .map(u -> modelMapper.map(u, UserDto.class))
                .collect(Collectors.toList());
    }
}
