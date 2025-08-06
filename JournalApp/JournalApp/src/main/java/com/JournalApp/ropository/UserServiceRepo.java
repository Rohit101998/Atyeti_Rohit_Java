package com.JournalApp.ropository;

import com.JournalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserServiceRepo extends MongoRepository<User, ObjectId> {
    User findByUserName(String username);
}
