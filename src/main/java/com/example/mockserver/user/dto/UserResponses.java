package com.example.mockserver.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class UserResponses {

    @Getter
    @RequiredArgsConstructor
    public static class UserInfoResponseDto {

        private final String email;
        private final String nickname;
        private final String phone;
    }
}
