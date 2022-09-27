package com.smarttechnologies.servicesqatar.Services;

import com.smarttechnologies.servicesqatar.Entities.Comments;
import com.smarttechnologies.servicesqatar.Entities.NotificationEmail;
import com.smarttechnologies.servicesqatar.Entities.Post;
import com.smarttechnologies.servicesqatar.Entities.User;
import com.smarttechnologies.servicesqatar.Exception.PostNotFoundException;
import com.smarttechnologies.servicesqatar.Exception.SpringRedditException;
import com.smarttechnologies.servicesqatar.Mapper.CommentMapper;
import com.smarttechnologies.servicesqatar.Repositories.CommentsRepository;
import com.smarttechnologies.servicesqatar.Repositories.PostRepository;
import com.smarttechnologies.servicesqatar.Repositories.UserRepository;
import com.smarttechnologies.servicesqatar.dto.CommentsDto;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class CommentService {
    private static final String POST_URL = "";
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final AuthService authService;
    private final CommentMapper commentMapper;
    private final CommentsRepository commentsRepository;
    private final MailContentBuilder mailContentBuilder;
    private final MailService mailService;

    public static void save(CommentsDto commentsDto) {
        Post post = postRepository.findById(commentsDto.getPostId())
                .orElseThrow(() -> new PostNotFoundException(commentsDto.getPostId().toString()));
        Comments comment = commentMapper.map(commentsDto, post, authService.getCurrentUser());
        commentsRepository.save(comment);

        String message = mailContentBuilder.build(post.getUser().getUsername() + " posted a comment on your post." + POST_URL);
        sendCommentNotification(message, post.getUser());
    }

    private void sendCommentNotification(String message, User user) {
        mailService.sendMail(new NotificationEmail(user.getUsername() + " Commented on your post", user.getEmail(), message));
    }

    public List<CommentsDto> getAllCommentsForPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException(postId.toString()));
        return commentsRepository.findByPost(post)
                .stream()
                .map(commentMapper::mapToDto).collect(toList());
    }

    public List<CommentsDto> getAllCommentsForUser(String userName) {
        User user = userRepository.findByUsername(userName)
                .orElseThrow(() -> new UsernameNotFoundException(userName));
        return commentsRepository.findAllByUser(user)
                .stream()
                .map(commentMapper::mapToDto)
                .collect(toList());
    }

    public boolean containsSwearWords(String comment) {
        if (comment.contains("shit")) {
            throw new SpringRedditException("Comments contains unacceptable language");
        }
        return false;
    }}