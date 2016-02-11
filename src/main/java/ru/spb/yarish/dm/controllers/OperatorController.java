package ru.spb.yarish.dm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/operator")
public class OperatorController {

    @RequestMapping("")
    public String render(Model model) {
        return "operator";
    }

    @RequestMapping("/account")
    public String createCustomerAccount() {
        return "1";
    }

    @RequestMapping("/deposit")
    public String createCustomerDeposit() {
        return "1";
    }

}
