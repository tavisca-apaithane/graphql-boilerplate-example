package com.example.demo.graphql;

import com.example.demo.DA.UserDataService;
import com.example.demo.DA.UserRepository;
import com.example.demo.User;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class AppDataFetcher {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserDataService userDataService;
    public DataFetcher getUserByFirstName(){
        return dataFetchingEnvironment ->{
            String firstName = dataFetchingEnvironment.getArgument("firstName");
            for(User user : userRepository.findAll()){
                System.out.println(user.getFirstName());
            }
            return userDataService.getAllUsers().stream()
                    .filter(user->user.getFirstName().equalsIgnoreCase(firstName)).findFirst();
        };
    }
    public DataFetcher getAllUsers(){
        return dataFetchingEnvironment->{
            return userDataService.getAllUsers();
        };
    }
}
