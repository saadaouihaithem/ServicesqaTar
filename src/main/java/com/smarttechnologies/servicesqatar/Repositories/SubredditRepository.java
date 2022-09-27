package com.smarttechnologies.servicesqatar.Repositories;


import com.smarttechnologies.servicesqatar.Entities.Subreddit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
    public interface SubredditRepository extends JpaRepository<Subreddit, Long> {
 // find post byName
        Optional<Subreddit> findByName(String subredditName);
    }

