package ru.spb.yarish.dm.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DepositForm {

    private String index;
    private String number;
    private Double balance;
    private String account;
}
