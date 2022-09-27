package com.smarttechnologies.servicesqatar.Mapper;

import com.github.marlonlom.utilities.timeago.TimeAgo;
import com.smarttechnologies.servicesqatar.Entities.*;
import com.smarttechnologies.servicesqatar.Repositories.CommentsRepository;
import com.smarttechnologies.servicesqatar.Repositories.VoteRepository;
import com.smarttechnologies.servicesqatar.Services.AuthService;
import com.smarttechnologies.servicesqatar.dto.PostRequest;
import com.smarttechnologies.servicesqatar.dto.PostResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static com.smarttechnologies.servicesqatar.Entities.VoteType.DOWNVOTE;
import static com.smarttechnologies.servicesqatar.Entities.VoteType.UPVOTE;


@Mapper(componentModel = "spring")
public abstract class PostMapper {

    @Autowired
    private CommentsRepository commentRepository;
    @Autowired
    private VoteRepository voteRepository;
    @Autowired
    private AuthService authService;


    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "description", source = "postId")
    @Mapping(target = "Subreddit", source = "postId")
    @Mapping(target = "voteCount", constant = "0")
    @Mapping(target = "user", source = "postId")

    public abstract  Post map(PostRequest postRequest, Subreddit subreddit, User user);

    @Mapping(target = "id", source = "postId")
    @Mapping(target = "subredditName", source = "subreddit.name")
    @Mapping(target = "userName", source = "user.username")
    @Mapping(target = "commentCount", expression = "java(commentCount(post))")
    @Mapping(target = "duration", expression = "java(getDuration(post))")
    @Mapping(target = "upVote", expression = "java(isPostUpVoted(post))")
    @Mapping(target = "downVote", expression = "java(isPostDownVoted(post))")
    public abstract PostResponse mapToDto(Post post);

    Integer commentCount(Post post) {
        return commentRepository.findByPost(post).size();
    }

    String getDuration(Post post) {
        return TimeAgo.using(post.getCreatedDate().toEpochMilli());
    }

    boolean isPostUpVoted(Post post) {
        return checkVoteType(post, UPVOTE);
    }

    boolean isPostDownVoted(Post post) {
        return checkVoteType(post, DOWNVOTE);
    }

    private boolean checkVoteType(Post post, VoteType voteType) {
        if (authService.isLoggedIn()) {
            Optional<Vote> voteForPostByUser =
                    voteRepository.findTopByPostAndUserOrderByVoteIdDesc(post,
                            authService.getCurrentUser());
            return voteForPostByUser.filter(vote -> vote.getVoteType().equals(voteType))
                    .isPresent();
        }
        return false;
    }
}
