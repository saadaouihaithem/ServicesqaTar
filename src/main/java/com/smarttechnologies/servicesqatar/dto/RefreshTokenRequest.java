package com.smarttechnologies.servicesqatar.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class RefreshTokenRequest {
        @NotNull
        private String refreshToken;
        private String username;
    }


