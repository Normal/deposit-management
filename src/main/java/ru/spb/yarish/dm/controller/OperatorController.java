package ru.spb.yarish.dm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.spb.yarish.dm.model.entity.Account;
import ru.spb.yarish.dm.model.dto.DepositForm;
import ru.spb.yarish.dm.service.AccountService;
import ru.spb.yarish.dm.service.DepositService;

@Controller
@RequestMapping("/operator")
public class OperatorController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private DepositService depositService;

    @RequestMapping("")
    public String indexPage(Model model) {
        model.addAttribute("account", new Account());
        return "operator/index";
    }

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String createAccountPage(Model model) {
        model.addAttribute("account", new Account());
        return "operator/account";
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public String createAccount(@ModelAttribute Account account, Model model) {
        accountService.createCustomer(account);
        model.addAttribute("status", "done");

        return "operator/index";
    }

    @RequestMapping(value = "/deposit", method = RequestMethod.GET)
    public String createDepositPage(Model model) {
        model.addAttribute("deposit", new DepositForm());
        model.addAttribute("names", accountService.getCustomersNames());
        model.addAttribute("indexes", depositService.getBankIndexes());
        return "operator/deposit";
    }

    @RequestMapping(value = "/deposit", method = RequestMethod.POST)
    public String createDeposit(@ModelAttribute DepositForm deposit, Model model) {
        depositService.createDeposit(deposit);
        model.addAttribute("status", "done");

        return "operator/index";
    }

}
