package com.smarttechnologies.servicesqatar.Services;

import com.smarttechnologies.servicesqatar.Entities.Post;
import com.smarttechnologies.servicesqatar.Entities.Vote;
import com.smarttechnologies.servicesqatar.Exception.PostNotFoundException;
import com.smarttechnologies.servicesqatar.Exception.SpringRedditException;
import com.smarttechnologies.servicesqatar.Repositories.PostRepository;
import com.smarttechnologies.servicesqatar.Repositories.VoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

    @Service
    @Transactional
 public class VoteServiceImpl implements VoteService{

        private final VoteRepository voteRepository;
        private final PostRepository postRepository;

        public VoteServiceImpl(VoteRepository voteRepository, PostRepository postRepository) {
            this.voteRepository = voteRepository;
            this.postRepository = postRepository;
        }


        public void vote(VoteService voteService) {
            Post post = postRepository.findById(VoteRepository.)
                    .orElseThrow(() -> new PostNotFoundException("Post Not Found with ID - " + Vote.getPostId()));
            Optional<Vote> voteByPostAndUser = voteRepository.findTopByPostAndUserOrderByVoteIdDesc(post, authService.getCurrentUser());
            if (voteByPostAndUser.isPresent() &&
                    voteByPostAndUser.get().getVoteType()
                            .equals(voteService.getVoteType())) {
                throw new SpringRedditException("You have already "
                        + voteService.getVoteType() + "'d for this post");
            }

  // WE WANT TO CHECK IF VOTE IS UPDATE
            if (UPVOTE.equals(voteDto.getVoteType())) {
                post.setVoteCount(post.getVoteCount() + 1);
            } else {
                post.setVoteCount(post.getVoteCount() - 1);
            }
            voteRepository.save(mapToVote(voteDto, post));
            postRepository.save(post);
        }

// MAP ALL THE VOTE BY VOTE iD
        private Vote mapToVote(VoteDto voteDto, Post post) {
            return Vote.builder()
                    .voteType(voteDto.getVoteType())
                    .post(post)
                    .user(authService.getCurrentUser())
                    .build();
        }
    }

