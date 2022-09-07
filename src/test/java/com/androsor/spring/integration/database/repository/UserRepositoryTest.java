package com.androsor.spring.integration.database.repository;

import com.androsor.spring.database.entity.User;
import com.androsor.spring.database.repository.UserRepository;
import com.androsor.spring.integration.annatation.IT;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
class UserRepositoryTest {

    private final UserRepository userRepository;

    @Test
    void findAllBy() {
        var users = userRepository.findAllBy("a", "ov");
        Assertions.assertThat(users).hasSize(3);
        System.out.println(users);
    }
}