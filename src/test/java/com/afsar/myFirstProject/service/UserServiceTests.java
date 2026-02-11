package com.afsar.myFirstProject.service;

import com.afsar.myFirstProject.entity.User;
import com.afsar.myFirstProject.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

    @ParameterizedTest
    @ValueSource(strings = {
            "afsar",
            "asif",
            "rakib"
    })
    public void testFindByUserName(String name){
        Assertions.assertNotNull(userRepository.findByUserName(name));
    }

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,2,4",
            "3,3,8"

    })
    public void test(int a,int b,int expected){
        Assertions.assertEquals(expected,a+b);
    }
}
