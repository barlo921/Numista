package com.barlo.numista.repository;


import com.barlo.numista.model.users.User;

import java.util.List;

public interface UserRepository {

    User save(User user);

    boolean delete(int id);

    User get(int id);

    User getByUsername(String username);

    List<User> getAll();

}
