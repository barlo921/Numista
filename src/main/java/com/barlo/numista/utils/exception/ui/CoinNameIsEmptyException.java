package com.barlo.numista.utils.exception.ui;

import com.barlo.numista.utils.exception.AbstractNumistaException;

public class CoinNameIsEmptyException extends AbstractNumistaException {

    public CoinNameIsEmptyException() {
        super("Please choose Coin name");
    }

    @Override
    public String getException() {
        return "Coin name is not set";
    }
}
