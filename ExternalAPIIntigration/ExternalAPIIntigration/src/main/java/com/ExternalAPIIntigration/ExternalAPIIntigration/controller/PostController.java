package com.ExternalAPIIntigration.ExternalAPIIntigration.controller;

import com.ExternalAPIIntigration.ExternalAPIIntigration.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/ ")
    List<Map<String,Object>> getAllPosts(){
        return postService.getPosts();
    }
    @GetMapping("/getPostById/{id}")
    Map<String,Object> getAllPosts(@PathVariable int id){
        return postService.getPostById(id);
    }

    @PostMapping("/insertPost")
    Map<String,Object> insertPost
            (@RequestBody Map<String,Object> payload){
        return postService.insertPost(payload);
    }
    @PutMapping("/updatePost/{id}")
    Map<String,Object> updatePost(@RequestBody Map<String,Object> payload,@PathVariable int id){
        return postService.updatePost(payload, id);
    }

    @DeleteMapping("/deletePosts/{id}")
    Map<String,Object> deletePost(@PathVariable int id){
        return postService.deletePost(id);
    }
}
