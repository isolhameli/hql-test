package com.example.demo.repository;

import com.example.demo.models.UserModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {

    @Query("select u from UserModel u where u.userName like concat('%',:name,'%') order by u.userName")
    List<UserModel> findUsuarioModelByName(@Param("name") String name);

    @Query("select u from UserModel u")
    List<UserModel> findAll();

    @Query("select u from UserModel u where u.id = :id")
    Optional<UserModel> findById(Long id);

    @Query("select u from UserModel u where u.userName = :name")
    Optional<UserModel> findByName(String name);

    @Transactional
    @Modifying
    @Query("delete UserModel u where u.id = :id")
    void deleteById(Long id);

    @Transactional
    @Modifying
    @Query("update UserModel set password=:password where id=:id")
    void updatePasswordById(String password, Long id);
}



