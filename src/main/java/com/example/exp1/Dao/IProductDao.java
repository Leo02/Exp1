package com.example.exp1.Dao;

import com.example.exp1.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IProductDao extends JpaRepository<Product, String> {
    Product findProductById(String id);
    @Modifying
    @Transactional
    @Query("update Product p set p.name=:name where p.id=:id")
    int updateProductNameById(@Param("id")String id,@Param("name") String name);
}
