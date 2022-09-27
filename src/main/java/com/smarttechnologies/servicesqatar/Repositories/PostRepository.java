package com.smarttechnologies.servicesqatar.Repositories;
import com.smarttechnologies.servicesqatar.Entities.Post;
import com.smarttechnologies.servicesqatar.Entities.Subreddit;
import com.smarttechnologies.servicesqatar.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findAllBySubreddit(Subreddit subreddit);

    List<Post> findByUser(User user);
}