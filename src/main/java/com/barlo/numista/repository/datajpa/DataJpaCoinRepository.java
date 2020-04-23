package com.barlo.numista.repository.datajpa;

import com.barlo.numista.model.Coin;
import com.barlo.numista.repository.CoinRepository;
import com.barlo.numista.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public class DataJpaCoinRepository implements CoinRepository {

    private static final Sort SORT_COLLECTION_NAME = new Sort(Sort.Direction.ASC, "collection.name", "name");

    private CrudCoinRepository repository;
    private CrudCollectionRepository collectionRepository;
    private CrudUserRepository userRepository;

    @Autowired
    public DataJpaCoinRepository(CrudCoinRepository repository,
                                 CrudCollectionRepository collectionRepository,
                                 CrudUserRepository userRepository) {
        this.repository = repository;
        this.collectionRepository = collectionRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public Coin save(Coin coin, int collectionId, int ownerId) {
        coin.setCollection(collectionRepository.getOne(collectionId));
        coin.setUser(userRepository.getOne(ownerId));
        return repository.save(coin);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }

    @Override
    public Coin get(int id) {
        return repository.findByIdWithOwner(id).orElse(null);
    }

    @Override
    public Coin getByName(String name) {
        return repository.findByName(name).orElse(null);
    }

    @Override
    public List<Coin> getAll() {
        return repository.getAll(SORT_COLLECTION_NAME);
    }

    @Override
    public List<Coin> getAllByCollection(int collectionId) {
        return repository.findByCollection(collectionId);
    }
}
