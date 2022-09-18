package com.androsor.spring.service;

import com.androsor.spring.database.repository.CompanyRepository;
import com.androsor.spring.dto.CompanyReadDto;
import com.androsor.spring.listener.entity.AccessType;
import com.androsor.spring.listener.entity.EntityEvent;
import com.androsor.spring.mapper.CompanyReadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * The {@code CompanyService}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 29.08.2022 11:39
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CompanyService {

    private final UserService userService;
    private final CompanyRepository companyRepository;
    private final CompanyReadMapper companyReadMapper;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public Optional<CompanyReadDto> findById(Integer id) {
        return companyRepository.findById(id)
                .map(entity -> {
                    applicationEventPublisher.publishEvent(new EntityEvent(entity, AccessType.DELETE));
                    return companyReadMapper.map(entity);
                });
    }

    public List<CompanyReadDto> findAll() {
        return companyRepository.findAll()
                .stream()
                .map(companyReadMapper::map)
                .toList();
    }
}
