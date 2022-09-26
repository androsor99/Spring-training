package com.androsor.spring.http.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

/**
 * The {@code MessageRestController}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 26.09.2022 21:18
 */
@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MessageRestController {

    private final MessageSource messageSource;

    @GetMapping
    public String getMessage(@RequestParam("key") String key,
                             @RequestParam("lang") String language) {
        return messageSource.getMessage(key, null, null, new Locale(language));
    }
}
