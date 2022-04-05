package com.jongky.prac.springweb.controller;

import com.jongky.prac.springweb.model.UserProfile;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserProfileController {
    private Map<String, UserProfile> userMap;

    @PostConstruct
    public void init() {
        userMap = new HashMap<String, UserProfile>();
        userMap.put("1", new UserProfile("1", "ykj", "4903-9081", "Seoul"));
        userMap.put("2", new UserProfile("2", "jej", "2715-0288", "Suwon"));
        userMap.put("3", new UserProfile("3", "kmc", "2715-0288", "Seoul"));
        userMap.put("4", new UserProfile("4", "iyh", "2715-0288", "Seoul"));
        userMap.put("5", new UserProfile("5", "kjw", "2715-0288", "Seoul"));
        userMap.put("6", new UserProfile("6", "kth", "2715-0288", "Suwon"));
        userMap.put("7", new UserProfile("7", "syd", "2715-0288", "Gangleung"));
        userMap.put("8", new UserProfile("8", "lhk", "2715-0288", "Seoul"));
    }

    @GetMapping("/user/{id}")
    public UserProfile getUserProfile(@PathVariable(name = "id") String id) {
        return userMap.get(id);
    }

    @GetMapping("/user/all")
    public List<UserProfile> getUserProfileList() {
        return new ArrayList<UserProfile>(userMap.values());
    }

    @PostMapping("/user/{id}")
    public void postUserProfile(@PathVariable(name = "id") String id, String name, String phone, String address) {
        UserProfile user = new UserProfile(id, name, phone, address);
        userMap.put(id, user);
    }

    @PutMapping("/user/{id}")
    public void putUserProfile(@PathVariable(name = "id") String id, String name, String phone, String address) {
        UserProfile user = userMap.get(id);
        user.setName(name);
        user.setPhone(phone);
        user.setAddress(address);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserProfile(@PathVariable(name = "id") String id) {
        userMap.remove(id);
    }
}
