package com.androsor.spring.dto;

import lombok.Value;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * The {@code PageResponse}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 20.09.2022 11:02
 */
@Value
public class PageResponse<T> {
    List<T> content;
    MetaData metaData;

    public static <T> PageResponse<T> of(Page<T> page) {
        var metaData = new MetaData(page.getNumber(), page.getSize(), page.getTotalElements());
        return new PageResponse<>(page.getContent(), metaData);
    }

    @Value
    public static class MetaData {
        int page;
        int size;
        long totalElements;
    }
}
