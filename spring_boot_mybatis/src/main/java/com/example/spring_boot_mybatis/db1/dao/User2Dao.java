package com.example.spring_boot_mybatis.db1.dao;

import com.example.spring_boot_mybatis.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("db1SqlSessionTemplate")
public interface User2Dao {
    @Select("SELECT * FROM user WHERE name = #{name} limit 1")
    User findUserByName(String name);
}
