package com.mehdisarf.mvc.controller;

import com.mehdisarf.mvc.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/main")
public class MainController {

    @Autowired
    private GreetingService greetingService; // this is coming from a different Application Context;
    // other than the one associated with our DispatcherServlet that has actually created our controller.

    @ResponseBody
    @RequestMapping("/")
    public String message() {
        return greetingService.greet();
    }
}
