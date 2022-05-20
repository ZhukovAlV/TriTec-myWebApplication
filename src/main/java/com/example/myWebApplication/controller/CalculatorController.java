package com.example.myWebApplication.controller;

import com.example.myWebApplication.service.CalculateService;
import com.example.myWebApplication.model.OperationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalculatorController {

    @Autowired
    private OperationModel operationModel;

    @Autowired
    private CalculateService calculateService;

    @GetMapping("/calculator")
    public String getCalculatorPage(Model model){
        model.addAttribute("operationModel",operationModel);
        return "calculator";
    }

    @PostMapping(value="/calculator", params="add")
    public String add(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        model.addAttribute("result", calculateService.add(operationModel));
        return "calculator";
    }

    @PostMapping(value="/calculator", params="subtract")
    public String subtract(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        model.addAttribute("result", calculateService.subtract(operationModel));
        return "calculator";
    }

    @PostMapping(value="/calculator", params="multiply")
    public String multiply(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        model.addAttribute("result", calculateService.multiply(operationModel));
        return "calculator";
    }

    @PostMapping(value="/calculator", params="divide")
    public String divide(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        model.addAttribute("result", calculateService.divide(operationModel));
        return "calculator";
    }

    @PostMapping(value="/calculator", params="clearSimple")
    public String clearSimple(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        model.addAttribute("operationModel",  calculateService.clearSimple(operationModel));
        model.addAttribute("result", 0);
        return "calculator";
    }
}
