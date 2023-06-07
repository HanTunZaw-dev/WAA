package edu.miu.springsecurity1.service.impl;

import edu.miu.springsecurity1.entity.User;
import edu.miu.springsecurity1.entity.dto.PostUserDto;
import edu.miu.springsecurity1.repository.UserRepo;
import edu.miu.springsecurity1.service.UserService;
import org.apache.catalina.realm.UserDatabaseRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;


    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }


}
