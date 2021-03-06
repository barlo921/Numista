package com.barlo.numista.repository.datajpa;

import com.barlo.numista.model.Collection;
import com.barlo.numista.repository.CollectionRepository;
import com.barlo.numista.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public class DataJpaCollectionRepository implements CollectionRepository {

    private static final Sort SORT_NAME = new Sort(Sort.Direction.DESC, "name");

    private CrudCollectionRepository repository;
    private CrudUserRepository userRepository;

    @Autowired
    public DataJpaCollectionRepository(CrudCollectionRepository repository, CrudUserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public Collection save(Collection collection, int ownerId) {
        collection.setUser(userRepository.getOne(ownerId));
        return repository.save(collection);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }

    @Override
    public Collection get(int id) {
        return repository.findByIdWithOwner(id).orElse(null);
    }

    @Override
    public Collection getByName(String name) {
        return repository.findByName(name).orElse(null);
    }

    @Override
    public List<Collection> getAll() {
        return repository.findAll(SORT_NAME);
    }

    @Override
    public List<Collection> getAllTopLevel() {
        return repository.findAllTopLevel();
    }

    @Override
    public List<Collection> getSubLevel(int parentId) {
        return repository.findSubLevel(parentId);
    }
}
