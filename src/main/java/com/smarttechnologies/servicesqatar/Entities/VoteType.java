package com.smarttechnologies.servicesqatar.Entities;


import com.smarttechnologies.servicesqatar.Exception.SpringRedditException;

import java.util.Arrays;

public enum VoteType {
        UPVOTE(1), DOWNVOTE(-1),
    ;

    VoteType(int direction) {
        this.direction = direction;
    }

    private int direction;
    // check the value of direction
        public static VoteType lookup(Integer direction) {
            return Arrays.stream(VoteType.values())
                    .filter(value -> value.getDirection().equals(direction))
                    .findAny()
                    .orElseThrow(() -> new SpringRedditException("Vote not found"));
        }

        public Integer getDirection() {
            return direction;
        }




    }

