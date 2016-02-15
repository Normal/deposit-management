package ru.spb.yarish.dm.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class DepositForm {

    private String number;
    private Double balance;
    private String account;
}
