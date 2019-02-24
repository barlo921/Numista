package com.barlo.numista.exception;

public class CoinNameIsEmptyException extends AbstractNumistaException {

    private String message;

    public CoinNameIsEmptyException() {
        this.message = "Please choose Coin name";
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getException() {
        return "Coin name is not set";
    }
}
