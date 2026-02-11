package com.afsar.myFirstProject.controller;

import com.afsar.myFirstProject.api_response.WeatherResponse;
import com.afsar.myFirstProject.entity.User;
import com.afsar.myFirstProject.repository.UserRepository;
import com.afsar.myFirstProject.service.UserService;
import com.afsar.myFirstProject.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WeatherService weatherService;

    @PutMapping()
    public ResponseEntity<?> updateUser(@RequestBody User user){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User userInDb = userService.findByUserName(userName);
        if(userInDb != null){
            userInDb.setUserName(user.getUserName());
            userInDb.setPassword(user.getPassword());
            userService.saveNewUser(userInDb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> DeleteUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userRepository.deleteByUserName(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<?> greeting(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WeatherResponse response = weatherService.getWeather("Dhaka");
        String greeting =" ";
        if(response != null){
            greeting = ", weather feels like "+response.getCurrent().getFeelsLike();
        }
        return new ResponseEntity<>("Hi "+authentication.getName()+greeting,HttpStatus.OK);
    }
}
