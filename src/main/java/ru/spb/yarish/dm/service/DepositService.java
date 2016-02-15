package ru.spb.yarish.dm.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import ru.spb.yarish.dm.model.dto.DepositResult;
import ru.spb.yarish.dm.model.entity.Account;
import ru.spb.yarish.dm.model.entity.Deposit;
import ru.spb.yarish.dm.model.dto.DepositForm;
import ru.spb.yarish.dm.repository.AccountRepository;
import ru.spb.yarish.dm.repository.DepositRepository;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DepositService {

    @Autowired
    private DepositRepository depositRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public void createDeposit(DepositForm depositForm) {
        Deposit deposit = new Deposit();
        BeanUtils.copyProperties(depositForm, deposit);

        Account account = accountRepository.getByName(depositForm.getAccount()).get();
        deposit.setAccount(account);
        depositRepository.create(deposit);
    }

    @Transactional
    public List<DepositResult> getAllDeposits() {
        List<Deposit> deposits = depositRepository.getAll();

        return deposits.stream().map(this::transform)
                .collect(Collectors.toList());
    }

    @Transactional
    public DepositResult getDepositByNumber(String number) {
        Deposit deposit = depositRepository.getByNumber(number);
        if (deposit == null) {
            return null;
        }
        return transform(deposit);
    }

    private DepositResult transform(Deposit x) {
        DepositResult dr = new DepositResult();
        BeanUtils.copyProperties(x, dr);
        dr.setAccount(x.getAccount().getName());
        dr.setCreation(new SimpleDateFormat("dd/MMM/yyyy").format(x.getCreationDate()));
        return dr;
    }
}
