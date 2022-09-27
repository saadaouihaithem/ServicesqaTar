package com.smarttechnologies.servicesqatar.dto;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class LogoutRequest {
        @NotNull
        private String refreshToken;
    }

