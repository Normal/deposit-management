package ru.spb.yarish.dm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/customer", method = RequestMethod.GET)
public class CustomerController {

    @RequestMapping("/transfer")
    public String transfer() {
        return "1";
    }

    @RequestMapping("/history")
    public String viewHistory() {
        return "1";
    }

    @RequestMapping("/close")
    public String closeDeposit() {
        return "1";
    }
}
