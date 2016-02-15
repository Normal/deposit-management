package ru.spb.yarish.dm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.spb.yarish.dm.model.entity.Account;
import ru.spb.yarish.dm.model.entity.Role;
import ru.spb.yarish.dm.repository.AccountRepository;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @Transactional
    public void createCustomer(Account account) {
        account.setRole(Role.USER);
        // TODO: actually should be encoded on client side instead
        account.setPassword(encoder.encode(account.getPassword()));
        repository.create(account);
    }

    public List<String> getCustomersNames() {
        return repository.getAllNames();
    }
}
