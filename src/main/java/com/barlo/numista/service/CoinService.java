package com.barlo.numista.service;

import com.barlo.numista.model.Coin;

import java.util.List;

public interface CoinService {

    Coin save(Coin coin);

    List<Coin> findAll();

}
