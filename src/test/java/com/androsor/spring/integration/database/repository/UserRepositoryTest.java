package com.androsor.spring.integration.database.repository;

import com.androsor.spring.database.entity.Role;
import com.androsor.spring.database.entity.User;
import com.androsor.spring.database.repository.UserRepository;
import com.androsor.spring.integration.annatation.IT;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.AssertionErrors;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
class UserRepositoryTest {

    private final UserRepository userRepository;

    @Test
    void checkUpdate() {
        var user = userRepository.getById(1L);
        assertSame(user.getRole(), Role.ADMIN);
        user.setBirthDate(LocalDate.now());

        var resultCount = userRepository.updateRole(Role.USER, 1L, 5L);
        assertEquals(2, resultCount);

        var theSameUser = userRepository.getById(1L);
        assertSame(theSameUser.getRole(), Role.USER);
    }

    @Test
    void findAllBy() {
        var users = userRepository.findAllBy("a", "ov");
        assertThat(users).hasSize(3);
        System.out.println(users);
    }
}
