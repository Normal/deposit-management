package ru.spb.yarish.dm.repository;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import ru.spb.yarish.dm.model.entity.Account;
import ru.spb.yarish.dm.model.entity.Role;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Slf4j
public class AccountRepository {

    @PersistenceContext
    private EntityManager em;

    public List<String> getAllNames() {
        return em.createQuery("select name from Account where role=?", String.class)
                .setParameter(1, Role.USER)
                .getResultList();
    }

    public Optional<Account> getByName(String name) {
        log.debug("Retrieving account ...");

        Account user = em.createQuery("from Account where name=?", Account.class)
                .setParameter(1, name)
                .getSingleResult();

        return Optional.of(user);
    }

    public void create(Account account) {
        em.persist(account);
    }
}
