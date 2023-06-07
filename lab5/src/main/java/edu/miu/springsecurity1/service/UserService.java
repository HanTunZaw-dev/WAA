package edu.miu.springsecurity1.service;

import edu.miu.springsecurity1.entity.User;
import edu.miu.springsecurity1.entity.dto.PostUserDto;

import java.util.List;

public interface UserService {

    User findByEmail(String email);

}
