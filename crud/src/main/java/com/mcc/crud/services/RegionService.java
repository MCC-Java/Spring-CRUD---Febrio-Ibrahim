/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.crud.services;

import com.mcc.crud.entities.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mcc.crud.repositories.RegionRepository;
import java.util.List;

/**
 *
 * @author Gin
 */
@Service
public class RegionService {
    
    @Autowired
    RegionRepository regionRepositories ;
    /**
     * Read from database
     * @return list of region
     */
    public List<Region> getAll(){
        return regionRepositories.findAll();
    }
    /**
     * Update or create region to database 
     */
    public void save(Region region){
        regionRepositories.save(region);
    }
    /**
     * Delete region data in database
     */
    public void delete (Integer id){
        regionRepositories.delete(new Region(id));
    }
    /**
     * melakukan pencarian berdasarkan id
     * @return region berdasarkan id yang di cari 
     */
    public Region getById(Integer id){
        return regionRepositories.findById(id).get();
    }
    /**
     * melakukan pencarian berdasarkan keyword
     * @return list region
     */
    public List<Region> searchByKeyword(String keyword){
        return regionRepositories.findByKeyword(keyword);
    }
}
