package com.afsar.myFirstProject.service;

import com.afsar.myFirstProject.entity.JournalEntry;
import com.afsar.myFirstProject.entity.User;
import com.afsar.myFirstProject.repository.JournalEntryRepository;
import com.afsar.myFirstProject.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void saveUser(User user){
        userRepository.save(user);
    }

    public boolean saveNewUser(User user){
        try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            log.error("An error occurred");
            log.info("An error occurred");
            log.warn("An error occurred");
            log.trace("An error occurred");
            log.debug("An error occurred");
            return false;
        }

    }
    public void addNewAdmin(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER","ADMIN"));
        userRepository.save(user);
    }

    public List<User> findAllUser(){
        return userRepository.findAll();
    }

    public Optional<User> findUserById(ObjectId id){
        return userRepository.findById(id);
    }

    public void deleteUserById(ObjectId id){
        userRepository.deleteById(id);
    }

    public User findByUserName(String username){
        return userRepository.findByUserName(username);
    }



}
