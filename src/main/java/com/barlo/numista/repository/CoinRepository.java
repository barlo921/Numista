package com.barlo.numista.repository;

import com.barlo.numista.model.Coin;

import java.util.List;

public interface CoinRepository {

    Coin save(Coin coin);

    boolean delete(long id);

    Coin get(long id);

    Coin getByName(String name);

    List<Coin> getAll();

    List<Coin> getAllByCollection(long collectionId);

}
