package com.example.demo.dao.mapper;

import com.example.demo.dao.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("SELECT * FROM account WHERE NAME = #{name}")
    public User findByName(@Param("name") String name);

    @Insert("INSERT INTO account(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

}
