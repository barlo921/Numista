package com.barlo.numista.repository.datajpa;

import com.barlo.numista.model.users.User;
import com.barlo.numista.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaUserRepository implements UserRepository {

    private final static Sort SORT_USERNAME = new Sort(Sort.Direction.ASC, "username");

    @Autowired
    private CrudUserRepository crudRepository;

    @Override
    public User save(User user) {
        return crudRepository.save(user);
    }

    @Override
    public boolean delete(int id) {
        return crudRepository.delete(id) != 0;
    }

    @Override
    public User get(int id) {
        return crudRepository.findById(id).orElse(null);
    }

    @Override
    public User getByUsername(String username) {
        return crudRepository.getByUsername(username);
    }

    @Override
    public List<User> getAll() {
        return crudRepository.findAll(SORT_USERNAME);
    }
}
