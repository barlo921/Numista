package com.barlo.numista.repository;

import com.barlo.numista.model.Coin;

import java.util.List;

public interface CoinRepository {

    Coin save(Coin coin, int collectionId);

    boolean delete(int id);

    Coin get(int id);

    Coin getByName(String name);

    List<Coin> getAll();

    List<Coin> getAllByCollection(int collectionId);

}
