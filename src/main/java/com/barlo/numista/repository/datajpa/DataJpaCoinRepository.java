package com.barlo.numista.repository.datajpa;

import com.barlo.numista.model.Coin;
import com.barlo.numista.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaCoinRepository implements CoinRepository {

    private static final Sort SORT_COLLECTION_NAME = new Sort(Sort.Direction.DESC, "collection.name", "name");

    private CrudCoinRepository repository;

    @Autowired
    public DataJpaCoinRepository(CrudCoinRepository repository) {
        this.repository = repository;
    }

    @Override
    public Coin save(Coin coin) {
        return repository.save(coin);
    }

    @Override
    public boolean delete(long id) {
        return repository.delete(id) != 0;
    }

    @Override
    public Coin get(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Coin getByName(String name) {
        return repository.findByName(name).orElse(null);
    }

    @Override
    public List<Coin> getAll() {
        return repository.findAll(SORT_COLLECTION_NAME);
    }

    @Override
    public List<Coin> getAllByCollection(long collectionId) {
        return repository.findByCollection(collectionId);
    }
}
