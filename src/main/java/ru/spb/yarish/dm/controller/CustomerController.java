package ru.spb.yarish.dm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ru.spb.yarish.dm.model.entity.Transaction;
import ru.spb.yarish.dm.service.AccountService;
import ru.spb.yarish.dm.service.DepositService;
import ru.spb.yarish.dm.service.TransactionService;

import java.security.Principal;
import java.util.List;

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

        return "customer/index";
    }

    @RequestMapping(value = "/transfer", method = RequestMethod.GET)
    public String transferPage(Model model, Principal pr) {
        model.addAttribute("deposits", depositService.getCustomerDeposits(pr.getName()));
        model.addAttribute("names", accountService.getCustomersNames());
        model.addAttribute("transaction", new Transaction());

        return "customer/transfer";
    }

    @RequestMapping(value = "/transfer", method = RequestMethod.POST)
    public String transfer(@ModelAttribute Transaction tr, Model model, Principal pr) {
        String userName = pr.getName();
        tr.setUser(userName);
        transactionService.processTransaction(tr);
        model.addAttribute("status", "Successfully transferred!");
        model.addAttribute("username", userName);

        return "customer/index";
    }

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public String historyPage(Model model, Principal pr) {
        List<Transaction> trs = transactionService.getByUser(pr.getName());
        model.addAttribute("transactions", trs);

        return "customer/history";
    }

    @RequestMapping(value = "/close", method = RequestMethod.GET)
    public String closeDepositPage(Model model, Principal pr) {
        model.addAttribute("deposits", depositService.getCustomerDeposits(pr.getName()));

        return "customer/close";
    }

    @RequestMapping(value = "/close", method = RequestMethod.POST)
    public String closeDeposit(@RequestParam("deposit") String deposit, Model model, Principal pr) {
        depositService.closeDeposit(deposit);
        model.addAttribute("status", "Successfully closed!");
        model.addAttribute("username", pr.getName());

        return "customer/index";
    }
}
