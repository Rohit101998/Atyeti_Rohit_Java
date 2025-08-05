package com.JournalApp.service;

import com.JournalApp.entity.User;
import com.JournalApp.ropository.UserServiceRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserService {

    @Autowired
    private UserServiceRepo userServiceRepo;

    public void saveEntry(User user){
        userServiceRepo.save(user);
    }

    public List<User> getAll(){
        return userServiceRepo.findAll();
    }
    public Optional<User> findById(ObjectId id){
        return userServiceRepo.findById(id);
    }
    public void deleteUser(ObjectId id){
        userServiceRepo.deleteById(id);
    }

}
