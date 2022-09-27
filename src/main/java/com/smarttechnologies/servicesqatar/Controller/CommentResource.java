package com.smarttechnologies.servicesqatar.Controller;
import com.smarttechnologies.servicesqatar.Services.CommentService;
import com.smarttechnologies.servicesqatar.dto.CommentsDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.servlet.function.ServerResponse.status;

@RestController
@RequestMapping("/api/comments/")
@AllArgsConstructor
public class CommentResource {

    private final CommentService commentService;



    @PostMapping
    public ResponseEntity<Void> createComment(@RequestBody CommentsDto CommentsDto) {
        commentService.save(CommentsDto);
        return new ResponseEntity<>(CREATED);
    }

    @GetMapping("/by-post/{postId}")
    public ResponseEntity<List<CommentsDto>> getAllCommentsForPost(@PathVariable Long postId) {
        return ResponseEntity.status(OK)
                .body(commentService.getAllCommentsForPost(postId));
    }

    @GetMapping("/by-user/{userName}")
    public ResponseEntity<List<CommentsDto>> getAllCommentsForUser(@PathVariable String userName){
        return ResponseEntity.status(OK)
                .body(commentService.getAllCommentsForUser(userName));
    }
    }

