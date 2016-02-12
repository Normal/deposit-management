package ru.spb.yarish.dm.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ru.spb.yarish.dm.entity.Account;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Repository
public class AccountRepository {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private EntityManagerFactory factory;

    public Optional<Account> getByName(String name) {
        EntityManager em = factory.createEntityManager();

        Account user = em.createQuery("from Account where name=?", Account.class)
                .setParameter(1, name)
                .getSingleResult();

        return Optional.of(user);
    }
}
