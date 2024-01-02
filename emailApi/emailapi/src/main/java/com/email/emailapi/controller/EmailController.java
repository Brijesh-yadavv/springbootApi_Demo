package com.email.emailapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @GetMapping("/welcome")
    public String welcome(){
        return "hello this is my email api";
    }

    

}
