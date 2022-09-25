package com.smarttechnologies.servicesqatar.Entities;

import com.smarttechnologies.servicesqatar.Exception.SpringRedditException;

import javax.persistence.*;
import java.util.Arrays;
@Entity
public class VoteType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idVote", nullable = false)
    private Long idVote;

    private int direction;

        private Vote vote;

    public Long getId() {
        return idVote;
    }

    public void setId(Long idVote) {
        this.idVote = idVote;
    }

    public VoteType(int direction, Vote vote) {
        this.direction = direction;
        this.vote = vote;
    }

    public VoteType() {

    }

    @ManyToOne
    @JoinColumn(name = "vote_vote_id")
    public Vote getVote() {
        return vote;
    }

    public void setVote(Vote vote) {
        this.vote = vote;
    }
    public Integer getDirection() {
        return direction;
    }

    public static VoteType lookup (Integer direction) {
            return Arrays.stream(VoteType.value())
                    .filter(value -> value.getDirection().equals(direction))
                    .findAny()
                    .orElseThrow(() -> new SpringRedditException("Vote not found"));
        }

}
