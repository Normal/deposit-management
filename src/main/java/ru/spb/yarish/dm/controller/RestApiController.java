package ru.spb.yarish.dm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import ru.spb.yarish.dm.model.dto.DepositResult;
import ru.spb.yarish.dm.service.DepositService;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

@RestController
@RequestMapping(path = "/api", method = RequestMethod.GET)
@Slf4j
public class RestApiController {

    @Autowired
    private DepositService service;

    @RequestMapping("/all")
    public List<DepositResult> getAllDeposits() {
        return service.getAllDeposits();
    }

    @RequestMapping("/find")
    public ResponseEntity<DepositResult> getDepositByNumber(@RequestParam("number") String number) {
        DepositResult deposit = service.getDepositByNumber(number);
        if (deposit != null) {
            return new ResponseEntity<>(deposit, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
