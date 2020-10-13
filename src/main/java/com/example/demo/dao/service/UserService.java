package com.example.demo.dao.service;

import com.example.demo.config.rete.DataSource11;
import com.example.demo.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    @DataSource11("datasource1")
    @Transactional
    public int insertUser1(String name, Integer age){
        int result = mapper.insert(name, age);
       // int i = 1 / age;
        return result;
    }

    @DataSource11("datasource2")
    @Transactional
    public int insertUser2(String name, Integer age){
        int result = mapper.insert(name, age);
       // int i = 1 / age;
        return result;
    }

}
