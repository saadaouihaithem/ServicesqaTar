package com.smarttechnologies.servicesqatar.Services;

import com.smarttechnologies.servicesqatar.Entities.Comments;
import com.smarttechnologies.servicesqatar.Entities.Post;
import com.smarttechnologies.servicesqatar.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentService extends JpaRepository<Comments,Long> {

    Comments creatComment(Comments comment);
    List<Comments> getAllComment();
    Comments updateEmployee(Comments comment, long commentId);
    void deleteComment(long commentId);


    List<Post>getAllCommentsForPost(Long postId);

    List<User>getAllCommentsForUser(String userName);
}
