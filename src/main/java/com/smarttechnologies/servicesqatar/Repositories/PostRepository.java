package com.smarttechnologies.servicesqatar.Repositories;


import com.smarttechnologies.servicesqatar.Entities.Post;
import com.smarttechnologies.servicesqatar.Exception.EtBadRequestException;
import com.smarttechnologies.servicesqatar.Exception.EtResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {

    List<Post> findAll(Long userId) throws EtResourceNotFoundException;

    Post findById(Long userId, Long postId) throws EtResourceNotFoundException;

    Integer create(Long  userId, String title, String description) throws EtBadRequestException;

    void update(Long userId, Long postId, Post category) throws EtBadRequestException;

    void removeById(Long userId, Long postId);

    Optional<Post> findById(Long postId);
}