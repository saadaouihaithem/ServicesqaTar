package com.smarttechnologies.servicesqatar.Services;

import com.smarttechnologies.servicesqatar.Entities.Post;
import com.smarttechnologies.servicesqatar.Exception.EtBadRequestException;
import com.smarttechnologies.servicesqatar.Exception.EtResourceNotFoundException;
import com.smarttechnologies.servicesqatar.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class PostServiceImpl implements PostService {


    @Autowired
    public PostRepository postRepository;

   /* @Override
    public List<Post> findBypostId(Long postId,Long userId) {
        return postRepository.findById(postId,userId);
    }*/

    @Override
    public List<Post> fetchPostById(Long postId, Long userId) {
        return null;
    }

    public Optional<Post> findPostById(Long postId) throws EtResourceNotFoundException {
        return postRepository.findById(postId);
    }

    public Post addPost(Long  userId, Long postId,String title, String description) throws EtBadRequestException {
        Integer post= postRepository.create(userId, title, description);
        return postRepository.findById(userId,postId);
    }

    @Override
    public void updatePost(Long  userId, Long postId, Post post) throws EtBadRequestException {
        postRepository.update(userId,postId,post);
    }

    @Override
    public void removeCategoryWithAllOperation(Long  userId,Long postId) throws EtResourceNotFoundException {
        postRepository.removeById(userId,postId);
    }

    @Override
    public List<Post> getPostsByUsername(String name, Long postId) {
        return postRepository.findAll();
}}