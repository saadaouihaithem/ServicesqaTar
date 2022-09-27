package com.smarttechnologies.servicesqatar.Controller;

import com.smarttechnologies.servicesqatar.Services.PostService;
import com.smarttechnologies.servicesqatar.dto.PostRequest;
import com.smarttechnologies.servicesqatar.dto.PostResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.servlet.function.ServerResponse.status;


    @RestController
    @RequestMapping("/Posts")
    @AllArgsConstructor
    public class PostResource {

        private final PostService postService;

        @PostMapping
        public ResponseEntity<Void> createPost(@RequestBody PostRequest postRequest) {
            postService.save(postRequest);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        @GetMapping
        public ResponseEntity<List<PostResponse>> getAllPosts() {
            return (ResponseEntity<List<PostResponse>>) status(HttpStatus.OK).body(postService.getAllPosts());

        }

        @GetMapping("/{postId}")
        public ResponseEntity<PostResponse> getPost(@PathVariable Long postId) {
            return (ResponseEntity<PostResponse>) status(HttpStatus.OK).body(postService.getPost(postId));
        }

        @GetMapping("by-subreddit/{id}")
        public ResponseEntity<List<PostResponse>> getPostsBySubreddit(Long id) {
            return (ResponseEntity<List<PostResponse>>) status(HttpStatus.OK).body(postService.getPostsBySubreddit(id));
        }

        @GetMapping("by-user/{username}")
        public ResponseEntity<List<PostResponse>> getPostsByUsername(String username) {
            return (ResponseEntity<List<PostResponse>>) status(HttpStatus.OK)
                    .body(postService.getPostsByUsername(username));
        }
}
