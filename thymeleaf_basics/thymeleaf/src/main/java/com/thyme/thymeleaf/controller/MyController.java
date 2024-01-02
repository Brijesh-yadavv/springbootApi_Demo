package com.thyme.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MyController {

    @RequestMapping(value = "/about" , method = RequestMethod.GET)
    public String about(){
        System.out.println("going to inside about handler");
        return "about";
        //about.html
    }
}
