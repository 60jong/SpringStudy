package com.jongky.prac.springweb.controller;

import com.jongky.prac.springweb.mapper.UserProfileMapper;
import com.jongky.prac.springweb.model.UserProfile;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class UserProfileController {
    private UserProfileMapper mapper;

    public UserProfileController(UserProfileMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping("/user/{id}")
    public UserProfile getUserProfile(@PathVariable(name = "id") String id) {
        return mapper.getUserProfile(id);
    }

    @GetMapping("/user/all")
    public List<UserProfile> getUserProfileList() {
        return mapper.getUserProfileList();
    }

    @PostMapping("/user/{id}")
    public void postUserProfile(@PathVariable(name = "id") String id, String name, String phone, String address) {
        mapper.insertUserProfile(id, name, phone, address);
    }

    @PutMapping("/user/{id}")
    public void putUserProfile(@PathVariable(name = "id") String id, String name, String phone, String address) {
        mapper.updateUserProfile(id, name, phone, address);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserProfile(@PathVariable(name = "id") String id) {
        mapper.deleteUserProfile(id);
    }
}
