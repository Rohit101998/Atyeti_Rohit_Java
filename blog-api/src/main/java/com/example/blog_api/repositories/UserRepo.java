package com.example.blog_api.repositories;

import com.example.blog_api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

}
