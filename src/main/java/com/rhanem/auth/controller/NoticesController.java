package com.rhanem.auth.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {

    @GetMapping("/notice")
    public String saveNotices(){
        return "hello notice";
    }
}
