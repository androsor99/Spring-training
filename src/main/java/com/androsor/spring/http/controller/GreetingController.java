package com.androsor.spring.http.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

/**
 * The {@code GreetingController}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 14.09.2022 21:08
 */
@Controller
public class GreetingController {

    public ModelAndView hello(ModelAndView modelAndView) {
        modelAndView.setView("greeting/hello");
        return modelAndView;
    }

    public ModelAndView bye(ModelAndView modelAndView) {
        modelAndView.setView("greeting/bye");
        return modelAndView;
    }
}
