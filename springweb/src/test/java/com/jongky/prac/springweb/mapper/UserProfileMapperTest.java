package com.jongky.prac.springweb.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
public class UserProfileMapperTest {

    UserProfileMapper mapper;

    @Autowired
    public UserProfileMapperTest(UserProfileMapper mapper) {
        this.mapper = mapper;
    }

    @Test
    public void 유저_추가_테스트() {
        mapper.insertUserProfile("6", "jej", "2715-0288", "Suwon");
    }
    @Test
    public void 유저_조회_테스트() {
        mapper.getUserProfile("1");
    }
    @Test
    public void 유저_수정_테스트() {
        mapper.updateUserProfile("2", "jej", "2715-0288", "Suwon");
    }
    @Test
    public void 유저_삭제_테스트() {
        mapper.deleteUserProfile("2");
    }
}