package com.example.mockserver.user.repository;

import com.example.mockserver.user.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    List<User> findByEmailOrNicknameOrTel(String email, String nickname, String phone);

    Optional<User> findByNickname(String nickname);
}
