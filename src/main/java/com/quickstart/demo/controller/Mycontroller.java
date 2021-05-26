package com.quickstart.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mycontroller {

    @GetMapping("/")
    public String test(){
        return "hello testing for dm ";
    }

}
