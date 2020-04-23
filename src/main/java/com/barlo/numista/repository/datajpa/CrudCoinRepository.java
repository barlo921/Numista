package com.barlo.numista.repository.datajpa;

import com.barlo.numista.model.Coin;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface CrudCoinRepository extends JpaRepository<Coin, Integer> {

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Coin c WHERE c.id=:id AND c.user.id = ?#{ principal?.id }")
    int delete(@Param("id") int id);

    @Query(value = "SELECT c FROM Coin c WHERE c.id=:id AND c.user.id = ?#{ principal?.id }")
    Optional<Coin> findByIdWithOwner(@Param("id") int id);

    @Query(value = "SELECT c FROM Coin c WHERE c.name=:name AND c.user.id = ?#{ principal?.id }")
    Optional<Coin> findByName(@Param("name") String name);

    @Query(value = "SELECT c FROM Coin c WHERE c.collection.id=:collection_id AND c.user.id = ?#{ principal?.id }")
    List<Coin> findByCollection(@Param("collection_id") int collectionId);

    @Query(value = "SELECT c FROM Coin c WHERE c.user.id = ?#{ principal?.id }")
    List<Coin> getAll(Sort sort);

}
