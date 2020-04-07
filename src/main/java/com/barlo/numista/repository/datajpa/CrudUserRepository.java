package com.barlo.numista.repository.datajpa;


import com.barlo.numista.model.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface CrudUserRepository extends JpaRepository<User, Integer> {

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM User u WHERE u.id=:id")
    int delete(@Param("id") int id);

    @Query(value = "SELECT c FROM Collection c WHERE c.username=:username")
    User getByUsername(@Param("username") String username);

}
