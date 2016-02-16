package ru.spb.yarish.dm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.spb.yarish.dm.model.entity.Transaction;
import ru.spb.yarish.dm.service.AccountService;
import ru.spb.yarish.dm.service.DepositService;
import ru.spb.yarish.dm.service.TransactionService;

import java.security.Principal;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private DepositService  depositService;

    @Autowired
    private TransactionService transactionService;

    @RequestMapping("")
    public String indexPage(Model model, Principal pr) {
        model.addAttribute("username", pr.getName());

        return "customer/customer_index";
    }

    @RequestMapping(value = "/transfer", method = RequestMethod.GET)
    public String transferPage(Model model, Principal pr) {
        model.addAttribute("deposits", depositService.getCustomerDeposits(pr.getName()));
        model.addAttribute("names", accountService.getCustomersNames());
        model.addAttribute("transaction", new Transaction());

        return "customer/customer_transfer";
    }

    @RequestMapping(value = "/transfer", method = RequestMethod.POST)
    public String transfer(@ModelAttribute Transaction tr, Model model, Principal pr) {
        tr.setUser(pr.getName());
        transactionService.processTransaction(tr);
        model.addAttribute("status", "done");

        return "customer/customer_index";
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
