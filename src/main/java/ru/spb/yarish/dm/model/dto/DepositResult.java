package ru.spb.yarish.dm.model.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * This is a deposit representation for public REST api.
 */
@Setter @Getter
public class DepositResult {

    private Long id;
    private String number;
    private Double balance;
    private String account;
    private Boolean closed;

    /**
     * Used by template engine.
     */
    @Override
    public String toString() {
        return number + " - " + balance;
    }
}
