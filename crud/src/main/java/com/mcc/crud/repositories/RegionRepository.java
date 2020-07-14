/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.crud.repositories;

import com.mcc.crud.entities.Region;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Gin
 */
@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {
    @Query(value = "select * from region r where r.name like %:keyword% or r.id like %:keyword%", nativeQuery=true)
    List<Region> findByKeyword(@Param("keyword") String keyword);
}
