package com.androsor.spring.http.controller;

import com.androsor.spring.dto.UserCreateEditDto;
import com.androsor.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The {@code UserController}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 15.09.2022 21:09
 */
@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public String findAll(Model model) {
//        model.addAttribute("users", userService.findAll());
//        model.addAttribute("users", userService.findAll(filter));
        return "user/users";
    }

    @GetMapping("/{id}")
    public String findById(Model model,
                           @PathVariable("id") Long id) {
//        model.addAttribute("user", userService.findById(id));
        return "user/user";
    }

    @PostMapping
    public String create(@ModelAttribute UserCreateEditDto user) {
//        userService.create(user);
        return "redirect:/users/" + 25;
    }

//    @PutMapping("/{id}")
    @PostMapping("/{id}/update") // временно и неправильно
    public String update(@ModelAttribute UserCreateEditDto user,
                         @PathVariable("id") Long id) {
//        userService.update(id, user);
        return "redirect:/users/{id}";
    }

//    @DeleteMapping("/{id}")
    @PostMapping("/{id}/delete") // временно и неправильно
    public String delete(@PathVariable("id") Long id) {
//        userService.delete(id);
        return "redirect:/users}";
    }
}
