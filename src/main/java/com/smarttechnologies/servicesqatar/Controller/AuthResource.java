package com.smarttechnologies.servicesqatar.Controller;

import com.smarttechnologies.servicesqatar.Entities.Post;
import com.smarttechnologies.servicesqatar.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthResource {


    @RestController
    @RequestMapping("/Posts")
    public class PostResource {


        private final PostService postService;
        @Autowired
        public PostResource(PostService postService) {
            this.postService = postService;
        }

        @GetMapping("")
        public ResponseEntity<List<Post>> getAllPost(HttpServletRequest request) {
            Long  userId = (Long) request.getAttribute("userId");
            Long  postId = (Long) request.getAttribute("postId");
            List<Post> post = postService.fetchPostById(postId,userId);
            return new ResponseEntity<>(post, HttpStatus.OK);
        }


        @GetMapping("{postId}")
        public ResponseEntity<Post> getCategoryById(HttpServletRequest request,
                                                    @PathVariable("postId") Long  postId) {
            Long  userId = (Long) request.getAttribute("userId");
            Post post = (Post) postService.fetchPostById(userId, postId);
            return new ResponseEntity<>(post, HttpStatus.OK);
        }


        @PostMapping("")
        public ResponseEntity<Post> addPost(HttpServletRequest request,
                                            @RequestBody Map<String, Object> categoryMap) {
            Long userId = (Long)request.getAttribute("userId");
            String title = (String) categoryMap.get("title");
            String description = (String) categoryMap.get("description");
            Long postId = (Long) categoryMap.get("postId");
            Post post=postService.addPost(userId,postId, title, description);
            return new ResponseEntity<>(post, HttpStatus.CREATED);
        }



        @PutMapping(path="{postId}")
        public ResponseEntity<Map<String, Boolean>> updatePost(HttpServletRequest request,
                                                               @PathVariable("postId") Long  postId,
                                                               @RequestBody Post post) {


            Long userId = (Long) request.getAttribute("userId");
            postService.updatePost(userId, postId,post);
            Map<String, Boolean> map = new HashMap<>();
            map.put("success", true);
            return new ResponseEntity<>(map, HttpStatus.OK);
        }

        @DeleteMapping("{postId}")
        public ResponseEntity<Map<String,Boolean>> deleteCategory(HttpServletRequest request,
                                                                  @PathVariable("postId") Long postId) {
            long  userId = (Long) request.getAttribute("userId");
            postService.removeCategoryWithAllOperation(userId,postId);
            Map<String, Boolean> map = new HashMap<>();
            map.put("success", true);
            return new ResponseEntity<>(map,HttpStatus.OK);

        }
}}
