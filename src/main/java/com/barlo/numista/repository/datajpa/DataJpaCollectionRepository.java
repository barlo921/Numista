package com.barlo.numista.repository.datajpa;

import com.barlo.numista.model.Collection;
import com.barlo.numista.repository.CollectionRepository;
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

    @Autowired
    public DataJpaCollectionRepository(CrudCollectionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection save(Collection collection) {
        return repository.save(collection);
    }

    @Override
    public boolean delete(long id) {
        return repository.delete(id) != 0;
    }

    @Override
    public Collection get(long id) {
        return repository.findById(id).orElse(null);
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
    public List<Collection> getSubLevel(long parentId) {
        return repository.findSubLevele(parentId);
    }
}
