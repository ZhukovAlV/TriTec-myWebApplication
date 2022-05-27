package com.example.myWebApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/page/1")
    public String getPage1() {
        return "page1";
    }

    @GetMapping("/index")
    public String getIndexPage(Model model) {
        model.addAttribute("strHello", "Привет, я кот Вася");
        return "index";
    }

    @GetMapping("/")
    public String getMainPage(Model model) {
        model.addAttribute("strHello", "Hello, I am cat Tom");
        return "index";
    }

}
