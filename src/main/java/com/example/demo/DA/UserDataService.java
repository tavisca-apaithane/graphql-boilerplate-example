package com.example.demo.DA;

import com.example.demo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDataService {
    @Autowired
    UserRepository userRepository;
    public List<User> getAllUsers(){
        List<User> userList = new ArrayList<>();
        for(User u : userRepository.findAll()){
            userList.add(u);
        }
        return userList;
    }

    public User createUser(String firstName, String lastName){
        return userRepository.save(new User(firstName, lastName));
    }
}
