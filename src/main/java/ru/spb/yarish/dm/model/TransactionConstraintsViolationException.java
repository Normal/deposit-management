package ru.spb.yarish.dm.model;

public class TransactionConstraintsViolationException extends RuntimeException {

    public TransactionConstraintsViolationException(final String message) {
        super(message);
    }
}
