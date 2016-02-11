package ru.spb.yarish.dm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/operator", method = RequestMethod.GET)
public class OperatorController {

    @RequestMapping("/account")
    public String createCustomerAccount() {
        return "1";
    }

    @RequestMapping("/deposit")
    public String createCustomerDeposit() {
        return "1";
    }

}
