package com.barlo.numista.repository.datajpa;

import com.barlo.numista.model.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface CrudCollectionRepository extends JpaRepository<Collection, Integer> {

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Collection c WHERE c.id=:id")
    int delete(@Param("id") int id);

    @Query(value = "SELECT c FROM Collection c WHERE c.name=:name")
    Optional<Collection> findByName(@Param("name") String name);

    @Query(value = "SELECT c FROM Collection c WHERE c.parentId IS NULL")
    List<Collection> findAllTopLevel();

    @Query(value = "SELECT c FROM Collection c WHERE c.parentId=:parent_id")
    List<Collection> findSubLevel(@Param("parent_id") int parentId);

}