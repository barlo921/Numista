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
    @Query(value = "DELETE FROM Collection c WHERE c.id=:id AND c.user.id = ?#{ principal?.id }")
    int delete(@Param("id") int id);

    @Query(value = "SELECT c FROM Collection c WHERE c.id=:id AND c.user.id = ?#{ principal?.id }")
    Optional<Collection> findByIdWithOwner(@Param("id") int id);

    @Query(value = "SELECT c FROM Collection c WHERE c.name=:name AND c.user.id = ?#{ principal?.id }")
    Optional<Collection> findByName(@Param("name") String name);

    @Query(value = "SELECT c FROM Collection c WHERE c.parentId IS NULL AND c.user.id = ?#{ principal?.id }")
    List<Collection> findAllTopLevel();

    @Query(value = "SELECT c FROM Collection c WHERE c.parentId=:parent_id AND c.user.id = ?#{ principal?.id }")
    List<Collection> findSubLevel(@Param("parent_id") int parentId);

}
