package com.androsor.spring.http.controller;

import com.androsor.spring.dto.LoginDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The {@code LoginController}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 15.09.2022 12:51
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {

        return "user/login";
    }

    @PostMapping("/login")
    public String login(Model model,
                        @ModelAttribute("login") LoginDto loginDto) {
//        return "forward:/WEB-INF/jsp/user/login.html";
        return "redirect:https://banana.by";
    }
}
