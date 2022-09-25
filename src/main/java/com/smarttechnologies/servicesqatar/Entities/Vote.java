package com.smarttechnologies.servicesqatar.Entities;

import com.sun.istack.NotNull;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Vote {
        @Id
        @GeneratedValue(strategy = IDENTITY)
        private Long voteId;
        private  final  VoteType voteType;

        public Vote(Long voteId, VoteType voteType, Post post, User user) {
                this.voteId = voteId;
                this.voteType = voteType;
                this.post = post;
                this.user = user;
        }

        @NotNull
        @ManyToOne(fetch = LAZY)
        @JoinColumn(name = "postId", referencedColumnName = "postId")
        private Post post;
        @ManyToOne(fetch = LAZY)
        @JoinColumn(name = "idUser", referencedColumnName = "idUser")
        private User user;

        public Long getVoteId() {
                return voteId;
        }

        public void setVoteId(Long voteId) {
                this.voteId = voteId;
        }

        public VoteType getVoteType() {
                return voteType;
        }

        public Post getPost() {
                return post;
        }

        public void setPost(Post post) {
                this.post = post;
        }

        public User getUser() {
                return user;
        }

        public void setUser(User user) {
                this.user = user;
        }
}

