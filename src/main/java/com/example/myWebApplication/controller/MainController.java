package com.example.myWebApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

  @GetMapping("/{a}/{b}/{operation}")
  public String mainPage(Model model, @PathVariable String a, @PathVariable String b, @PathVariable String operation) {
      int aInt = Integer.parseInt(a);
      int bInt = Integer.parseInt(b);

      if(operation.equals("+")) model.addAttribute("strHello", aInt + bInt);
      else if (operation.equals("-")) model.addAttribute("strHello", aInt - bInt);
      else if (operation.equals("*")) model.addAttribute("strHello", aInt * bInt);
      else if (operation.equals(":")) model.addAttribute("strHello", aInt / bInt);

      return "index";
  }

/*  @PostMapping
  public String mainPage() {
      return "index";
  }*/
}
