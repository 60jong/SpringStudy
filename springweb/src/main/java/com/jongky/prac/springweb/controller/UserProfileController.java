package com.jongky.prac.springweb.controller;

import com.jongky.prac.springweb.model.UserProfile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
        userMap.put("1", new UserProfile("1", "유경종", "4903-9081", "서울시"));
        userMap.put("2", new UserProfile("2", "주은진", "2715-0288", "수원시"));
    }

    @GetMapping("/user/{id}")
    public UserProfile getUserProfile(@PathVariable(name = "id") String id) {
        return userMap.get(id);
    }

    @GetMapping("/user/all")
    public List<UserProfile> getUserProfileList() {
        return new ArrayList<UserProfile>(userMap.values());
    }
}
