package com.jongky.prac.springweb.mapper;

import com.jongky.prac.springweb.model.UserProfile;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
public interface UserProfileMapper {

    @Select("select * from userprofile where id = #{id}")
    UserProfile getUserProfile(@Param("id") String id);

    @Select("select * from userprofile")
    List<UserProfile> getUserProfileList();

    @Insert("insert into userprofile values(#{id},#{name},#{phone},#{address})")
    int insertUserProfile(@Param("id") String id,@Param("name") String name,@Param("phone") String phone,@Param("address") String address);

    @Update("update userprofile set name=#{name}, phone=#{phone},address=#{address} where id=#{id}")
    int updateUserProfile(@Param("id") String id, @Param("name") String name, @Param("phone") String phone, @Param("address") String address);

    @Delete("delete from userprofile where id=#{id}")
    int deleteUserProfile(@Param("id") String id);
}
