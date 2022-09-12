package com.androsor.spring.integration.database.repository;

import com.androsor.spring.database.entity.Role;
import com.androsor.spring.database.entity.User;
import com.androsor.spring.database.repository.UserRepository;
import com.androsor.spring.dto.PersonalInfo;
import com.androsor.spring.dto.UserFilter;
import com.androsor.spring.integration.IntegrationTestBase;
import com.androsor.spring.integration.annatation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;



@RequiredArgsConstructor
class UserRepositoryTest extends IntegrationTestBase {

    private final UserRepository userRepository;

    @Test
    void checkBatchNamedQuery() {
        var users = userRepository.findAll();
        userRepository.updateCompanyAndRoleNamed(users);
        System.out.println();
    }

    @Test
    void checkBatch() {
        var users = userRepository.findAll();
        userRepository.updateCompanyAndRole(users);
        System.out.println();
    }

    @Test
    void checkJdbcTemplate() {
        var users = userRepository.findAllByCompanyIdAndRole(1, Role.USER);
        assertThat(users).hasSize(1);
    }

    @Test
    void checkAuditing() {
        var ivan = userRepository.findById(1L).get();
        ivan.setBirthDate(ivan.getBirthDate().plusYears(1L));
        userRepository.flush();
        System.out.println();
    }

    @Test
    void checkCustomImplementation() {
        UserFilter filter = new UserFilter(null, "ov", LocalDate.now());
        var users = userRepository.findAllByFilter(filter);
        System.out.println();
    }

    @Test
    void CheckProjections() {
        var users = userRepository.findAllByCompanyId(1);
        assertThat(users).hasSize(2);
        System.out.println();
    }

    @Test
    void checkPageable() {
        var pageable = PageRequest.of(0, 2, Sort.by("id"));
        var slice = userRepository.findAllBy(pageable);
        slice.forEach(user -> System.out.println(user.getCompany().getName()));

        while (slice.hasNext()) {
            slice = userRepository.findAllBy(slice.nextPageable());
            slice.forEach(user -> System.out.println(user.getCompany().getName()));
        }
    }

    @Test
    void checkSort() {
//        var sortBy = Sort.by("firstname").and(Sort.by("lastname"));
        var sortBy = Sort.sort(User.class);
        var sort = sortBy.by(User::getFirstname).and(sortBy.by(User::getLastname));
        var allUsers = userRepository.findTop3ByBirthDateBefore(LocalDate.now(), sort);
        assertThat(allUsers).hasSize(3);
    }

    @Test
    void checkFirstTop() {
        var allUsers = userRepository.findTop3ByBirthDateBeforeOrderByBirthDateDesc(LocalDate.now());
        assertThat(allUsers).hasSize(3);
        var maybeUser = userRepository.findFirstByOrderByIdDesc();
        assertTrue(maybeUser.isPresent());
        maybeUser.ifPresent(user -> assertEquals(5L, user.getId()));
    }

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
