package ru.spb.yarish.dm.model.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * This is a deposit representation for UI forms.
 */
@Getter @Setter
public class DepositForm {

    private String index;
    private String number;
    private Double balance;
    private String account;
}
