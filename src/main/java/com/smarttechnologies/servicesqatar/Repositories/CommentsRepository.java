package com.smarttechnologies.servicesqatar.Repositories;

import com.smarttechnologies.servicesqatar.Entities.Comments;
import com.smarttechnologies.servicesqatar.Entities.Post;
import com.smarttechnologies.servicesqatar.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long> {
    List<Comments> findByPost(Post post);

    List<Comments> findAllByUser(User user);
}