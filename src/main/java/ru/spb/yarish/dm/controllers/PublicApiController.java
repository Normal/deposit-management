package ru.spb.yarish.dm.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api", method = RequestMethod.GET)
public class PublicApiController {

    @RequestMapping("/all")
    public String getAllDeposities() {
        return "1";
    }

    @RequestMapping("/find")
    public String getDepositByNumber() {
        return "1";
    }
}
