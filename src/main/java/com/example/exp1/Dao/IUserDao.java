package com.example.exp1.Dao;

import com.example.exp1.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IUserDao extends JpaRepository<User, String> {
    User findUserByIdAndPassword(String id,String password);
    List<User> findUserByAgeGreaterThan(int age);
    @Modifying
    @Transactional
    @Query("update User u set u.name=:name where u.id=:id")
    int updateUserNameById(@Param("id")String id,@Param("name") String name);
    @Modifying
    @Transactional
    int deleteUserById(String id);
}
