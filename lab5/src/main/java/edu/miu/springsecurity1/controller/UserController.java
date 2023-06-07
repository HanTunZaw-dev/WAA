package edu.miu.springsecurity1.controller;

import edu.miu.springsecurity1.entity.User;
import edu.miu.springsecurity1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    //localhost:8080/api/v1/user?id=dean@miu.edu
    @GetMapping()
    public User getByEmail(@RequestParam ("id") String id){
        return userService.findByEmail(id);
    }
}
