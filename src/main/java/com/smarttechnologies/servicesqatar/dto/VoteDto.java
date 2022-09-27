package com.smarttechnologies.servicesqatar.dto;

import com.smarttechnologies.servicesqatar.Entities.VoteType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class VoteDto {
        private VoteType voteType;
        private Long postId;
    }

