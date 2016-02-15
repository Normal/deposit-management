package ru.spb.yarish.dm.repository;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import ru.spb.yarish.dm.model.entity.Deposit;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Slf4j
public class DepositRepository {

    @PersistenceContext
    private EntityManager em;

    public void create(Deposit deposit) {
        log.debug("create deposit {} for {} account", deposit.getNumber(), deposit.getAccount());
        em.persist(deposit);
    }

    public List<Deposit> getAll() {
        return em.createQuery("from Deposit", Deposit.class)
                .getResultList();
    }

    public Deposit getByNumber(String number) {
        List<Deposit> result = em.createQuery("from Deposit where number=?", Deposit.class)
                .setParameter(1, number)
                .getResultList();
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }
    }
}
