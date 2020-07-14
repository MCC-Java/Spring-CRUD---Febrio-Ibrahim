/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.crud.services;

import com.mcc.crud.entities.Country;
import com.mcc.crud.repositories.CountryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gin
 */
@Service
public class CountryService {
    @Autowired
    CountryRepository countryRepository; 
    
    public List<Country> getAll(){
        return countryRepository.findAll();
    }
    
}
