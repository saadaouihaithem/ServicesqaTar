package com.smarttechnologies.servicesqatar.Services;


import com.smarttechnologies.servicesqatar.Entities.Post;
import com.smarttechnologies.servicesqatar.Exception.EtBadRequestException;
import com.smarttechnologies.servicesqatar.Exception.EtResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PostService {

    List<Post> fetchPostById(Long postId, Long userId);

    Post addPost(Long userId, Long postId, String title, String description) throws EtBadRequestException;

    void updatePost(Long  userId, Long  categoryId, Post category) throws EtBadRequestException;

    void removeCategoryWithAllOperation(Long userId, Long  categoryId) throws EtResourceNotFoundException;

  List<Post> getPostsByUsername(String username, Long PostId);
}