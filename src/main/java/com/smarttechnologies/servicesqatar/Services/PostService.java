package com.smarttechnologies.servicesqatar.Services;

import com.smarttechnologies.servicesqatar.Entities.Post;
import com.smarttechnologies.servicesqatar.Entities.Subreddit;
import com.smarttechnologies.servicesqatar.Entities.User;
import com.smarttechnologies.servicesqatar.Exception.EtResourceNotFoundException;
import com.smarttechnologies.servicesqatar.Exception.PostNotFoundException;
import com.smarttechnologies.servicesqatar.Mapper.PostMapper;
import com.smarttechnologies.servicesqatar.Repositories.PostRepository;
import com.smarttechnologies.servicesqatar.Repositories.SubredditRepository;
import com.smarttechnologies.servicesqatar.Repositories.UserRepository;
import com.smarttechnologies.servicesqatar.dto.PostRequest;
import com.smarttechnologies.servicesqatar.dto.PostResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.util.stream.Collectors.toList;


@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class PostService {

    private final PostRepository postRepository;
    private final SubredditRepository subredditRepository;
    private final UserRepository userRepository;
    private final AuthService authService;
    private final PostMapper postMapper;
    @Transactional()
    public void save(PostRequest postRequest) {
        Subreddit subreddit = subredditRepository.findByName(postRequest.getSubredditName())
                .orElseThrow(() -> new EtResourceNotFoundException(postRequest.getSubredditName()));
        postRepository.save(postMapper.map(postRequest, subreddit, authService.getCurrentUser()));
    }

    @Transactional()
    public PostResponse getPost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id.toString()));
        return postMapper.mapToDto(post);
    }

    @Transactional()
    public List<PostResponse> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(postMapper::mapToDto)
                .collect(toList());
    }

    @Transactional()
    public List<PostResponse> getPostsBySubreddit(Long subredditId) {
        Subreddit subreddit = subredditRepository.findById(subredditId)
                .orElseThrow(() -> new EtResourceNotFoundException(subredditId.toString()));
        List<Post> posts = postRepository.findAllBySubreddit(subreddit);
        return posts.stream().map(postMapper::mapToDto).collect(toList());
    }



    @Transactional()
    public List<PostResponse> getPostsByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EtResourceNotFoundException(username));
        return postRepository.findByUser(user)
                .stream()
                .map(postMapper::mapToDto)
                .collect(toList());
    } }