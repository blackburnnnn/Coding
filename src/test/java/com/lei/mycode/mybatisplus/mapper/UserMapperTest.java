package com.lei.mycode.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lei.mycode.mybatisplus.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void test(){

        // 增
//        User lzh = new User();
//        lzh.setName("雷神");
//        lzh.setSalary(100000000);
//        lzh.setAge(26);
//        lzh.setGender(1);
//        userMapper.insert(lzh);


        // 删
        LambdaQueryWrapper<User> deleteWrapper = new LambdaQueryWrapper<>();
        deleteWrapper.eq(User::getName, "不存在的名字");
        userMapper.delete(deleteWrapper);
//
//        // 查
//        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.gt(User::getSalary,20).eq(User::getGender, 1);
//
//        List<User> ls = userMapper.selectList(new LambdaQueryWrapper<User>()
//                .gt(User::getSalary,20)
//                .eq(User::getGender, 1)
//        );
//        for(User entity : ls){
//            System.out.println(entity);
//        }
//
//        // 改
//        LambdaUpdateWrapper<User> updateWrapper= new LambdaUpdateWrapper<>();
//        updateWrapper.eq(User::getGender,0).set(User::getAge,500).set(User::getSalary,10000);
//        userMapper.update(null, updateWrapper);
    }
}