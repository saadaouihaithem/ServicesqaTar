package com.smarttechnologies.servicesqatar.Services;

import com.smarttechnologies.servicesqatar.Entities.Comments;
import com.smarttechnologies.servicesqatar.Entities.Post;
import com.smarttechnologies.servicesqatar.Entities.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

    @Service
    @Transactional
    public class CommentServiceImpl  implements CommentService {


        @Override
        public Comments creatComment(Comments comment) {
            return null;
        }

        @Override
        public List<Comments> getAllComment() {
            return null;
        }

        @Override
        public Comments updateEmployee(Comments comment, long commentId) {
            return null;
        }

        @Override
        public void deleteComment(long commentId) {

        }

        @Override
        public List<Post> getAllCommentsForPost(Long postId) {
            return null;
        }

        @Override
        public List<User> getAllCommentsForUser(String userName) {
            return null;
        }
    }
