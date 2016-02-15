package ru.spb.yarish.dm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
@RequestMapping(path = "/customer", method = RequestMethod.GET)
public class CustomerController {

    @RequestMapping("")
    public String indexPage(Model model, Principal principal) {
        String name = principal.getName();
        model.addAttribute("username", name);
        return "customer_index";
    }

    @RequestMapping(value = "/transfer", method = RequestMethod.GET)
    public String transferPage(Model model) {
        return "customer/customer_transfer";
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
