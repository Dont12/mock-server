package com.example.mockserver.user.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

public class UserRequests {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SignupRequestDto {

        private String email;
        private String password;
        private String nickname;
        private String phone;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LoginRequestDto {

        private String email;
        private String password;
    }
}
