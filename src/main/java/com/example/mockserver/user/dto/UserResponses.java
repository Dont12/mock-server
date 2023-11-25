package com.example.mockserver.user.dto;

import lombok.Builder;
import lombok.Getter;

public class UserResponses {

    @Getter
    public static class UserInfoResponseDto {

        private final Long id;
        private final String email;
        private final String nickname;
        private final String tel;
        private final String profileImage;

        @Builder
        public UserInfoResponseDto(Long id, String email, String nickname, String tel, String profileImage) {
            this.id = id;
            this.email = email;
            this.nickname = nickname;
            this.tel = tel;
            this.profileImage = profileImage;
        }
    }
}
