package com.team1.stelling.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/test/*")
public class TestController {

    @GetMapping("/category")
    public String category(){
        log.info("======카테고리 드러옴=============");
        return "freeSerialize/category";
    }
    @GetMapping("/header")
    public String header(){
        log.info("======카테고리 드러옴=============");
        return "fix/header";
    }

}
