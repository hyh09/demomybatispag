package com.example.demo.dao.entity;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
    private Integer id;
    private String name;
    private String balance;

    /**
     * CREATE TABLE `account` (
     *   `id` bigint(20) DEFAULT NULL,
     *   `name` varchar(45) DEFAULT NULL,
     *   `balance` varchar(20) DEFAULT NULL
     * ) ENGINE=InnoDB DEFAULT CHARSET=utf8
     */
}
