package com.barlo.numista.service;

import java.util.List;

//Common Service Interface to work with repository
public interface NumistaService<T> {

    T save(T object);

    List<T> findAll();

}
