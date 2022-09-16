package com.androsor.spring.integration.http.controller;

import com.androsor.spring.database.entity.Role;
import com.androsor.spring.dto.UserCreateEditDto;
import com.androsor.spring.integration.IntegrationTestBase;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static com.androsor.spring.dto.UserCreateEditDto.*;
import static com.androsor.spring.dto.UserCreateEditDto.Fields.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@RequiredArgsConstructor
class UserControllerTest extends IntegrationTestBase {

    private final MockMvc mockMvc;

    @Test
    void findAll() throws Exception {
        mockMvc.perform(get("/users"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("user/users"))
                .andExpect(model().attributeExists("users"))
                .andExpect(model().attribute("users", hasSize(5)));
    }

    @Test
    void create() throws Exception {
        mockMvc.perform(post("/users")
                .param(username, "test@gmail.com")
                .param(firstname, "Test")
                .param(lastname, "TestTest")
                .param(role, "ADMIN")
                .param(companyId, "1")
                        .param(birthDate, "2000-01-01")
        )
                .andExpectAll(
                        status().is3xxRedirection(),
                        redirectedUrlPattern("/users/{\\d+}")
                );
    }
}