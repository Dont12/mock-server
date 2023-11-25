package com.example.mockserver.user.service;

import com.example.mockserver.config.security.token.UserPrincipal;
import com.example.mockserver.user.dto.UserRequests;
import com.example.mockserver.user.entity.ProfileImage;
import com.example.mockserver.user.entity.User;
import com.example.mockserver.user.exception.DuplicateEmailException;
import com.example.mockserver.user.exception.DuplicateNicknameException;
import com.example.mockserver.user.exception.DuplicatePhoneException;
import com.example.mockserver.user.exception.DuplicateValueException;
import com.example.mockserver.user.exception.NoSuchUserException;
import com.example.mockserver.user.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User registerUser(UserRequests.SignupRequestDto signupRequestDto) {
        ProfileImage defaultProfile = ProfileImage.createDefault();
        User newUser = User.createNewUser(signupRequestDto, passwordEncoder, defaultProfile);
        User savedUser = userRepository.save(newUser);
        return savedUser;
    }

    public boolean isDuplicated(UserRequests.SignupRequestDto signupRequestDto) throws DuplicateValueException {
        String requestEmail = signupRequestDto.getEmail();
        String requestNickname = signupRequestDto.getNickname();
        String requestTel = signupRequestDto.getPhone();

        List<User> byEmailOrNicknameOrTel = userRepository.findByEmailOrNicknameOrTel(
            requestEmail, requestNickname, requestTel);
        if (!byEmailOrNicknameOrTel.isEmpty()) {
            if (byEmailOrNicknameOrTel.stream()
                .anyMatch(user -> user.getEmail().equals(requestEmail))) {
                throw new DuplicateEmailException();
            }
            if (byEmailOrNicknameOrTel.stream()
                .anyMatch(user -> user.getTel().equals(requestTel))) {
                throw new DuplicatePhoneException();
            }
            if (byEmailOrNicknameOrTel.stream()
                .anyMatch(user -> user.getNickname().equals(requestNickname))) {
                throw new DuplicateNicknameException();
            }
        }
        return false;
    }

    public User readUser(UserPrincipal userPrincipal) throws NoSuchUserException {
        User findUser = userRepository.findById(userPrincipal.getId())
            .orElseThrow(() -> new NoSuchUserException());
        return findUser;
    }
}
