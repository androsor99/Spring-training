package com.androsor.spring.service;

import com.androsor.spring.database.entity.Company;
import com.androsor.spring.database.repository.CrudRepository;
import com.androsor.spring.dto.CompanyReadDto;
import com.androsor.spring.listener.entity.EntityEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CompanyServiceTest {

    private static final Integer COMPANY_ID = 1;

    @Mock
    private UserService userService;
    @Mock
    private CrudRepository<Integer, Company> companyRepository;
    @Mock
    private ApplicationEventPublisher applicationEventPublisher;
    @InjectMocks
    private CompanyService companyService;

    @Test
    void findById() {
        doReturn(Optional.of(new Company(COMPANY_ID)))
                .when(companyRepository).findById(COMPANY_ID);

        var actualResult = companyService.findById(COMPANY_ID);

        assertTrue(actualResult.isPresent());

        var expectedResult = new CompanyReadDto(COMPANY_ID);
        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));

        verify(applicationEventPublisher).publishEvent(any(EntityEvent.class));
        verifyNoMoreInteractions(applicationEventPublisher, userService);

    }
}
