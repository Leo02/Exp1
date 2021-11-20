package com.example.exp1.Dao;

import com.example.exp1.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IAdminDao extends JpaRepository<Admin, String> {
    Admin findAdminByIdAndPassword(String id, String password);
    @Modifying
    @Transactional
    @Query("update Admin a set a.name=:name where a.id=:id")
    int updateAdminNameById(@Param("id")String id,@Param("name") String name);
}
