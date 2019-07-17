package com.barlo.numista.repository.datajpa;

import com.barlo.numista.model.Coin;
import com.barlo.numista.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public class DataJpaCoinRepository implements CoinRepository {

    private static final Sort SORT_COLLECTION_NAME = new Sort(Sort.Direction.DESC, "collection.name", "name");

    private CrudCoinRepository repository;
    private CrudCollectionRepository collectionRepository;

    @Autowired
    public DataJpaCoinRepository(CrudCoinRepository repository, CrudCollectionRepository collectionRepository) {
        this.repository = repository;
        this.collectionRepository = collectionRepository;
    }

    @Override
    @Transactional
    public Coin save(Coin coin, int collectionId) {
        coin.setCollection(collectionRepository.getOne(collectionId));
        return repository.save(coin);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }

    @Override
    public Coin get(int id) {
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
    public List<Coin> getAllByCollection(int collectionId) {
        return repository.findByCollection(collectionId);
    }
}
