package com.example.mockserver.user.controller;

import com.example.mockserver.common.response.BaseResponseBody;
import com.example.mockserver.common.response.DataResponseBody;
import com.example.mockserver.config.security.token.UserPrincipal;
import com.example.mockserver.response.ResponseBody;
import com.example.mockserver.user.dto.UserRequests;
import com.example.mockserver.user.dto.UserResponses;
import com.example.mockserver.user.entity.User;
import com.example.mockserver.user.exception.UserRegisterException;
import com.example.mockserver.user.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseBody<Void> signup(
        @Validated @RequestBody UserRequests.SignupRequestDto signupRequestDto) throws UserRegisterException {
        userService.isDuplicated(signupRequestDto);
        userService.registerUser(signupRequestDto);
        return ResponseBody.ok();
    }

    @PostMapping("/auth/login")
    public BaseResponseBody login(
        @Validated @RequestBody UserRequests.LoginRequestDto loginRequestDto) {
        throw new RuntimeException("로그인 기능은 필터에서 처리되어야 합니다.");
    }

    @GetMapping("/users")
    public ResponseBody<UserResponses.UserInfoResponseDto> info(
        @AuthenticationPrincipal UserPrincipal userPrincipal) {
        User findUser = userService.readUser(userPrincipal);
        return ResponseBody.ok(
            UserResponses.UserInfoResponseDto.builder()
                .id(findUser.getUserId())
                .email(findUser.getEmail())
                .nickname(findUser.getNickname())
                .tel(findUser.getTel())
                .profileImage(findUser.getProfileImage().getUrl())
                .build()
        );
    }
}
