package com.springboot.thymeleaf.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
    public class MyController {

        @RequestMapping(value = "/about" , method = RequestMethod.GET)
        public String about(Model model){
            model.addAttribute("name","brijeshhhh yy yadav");
            model.addAttribute("currentDate","date");

            System.out.println("going to inside about handler");


            return "about";
            //about.html
        }
    }


