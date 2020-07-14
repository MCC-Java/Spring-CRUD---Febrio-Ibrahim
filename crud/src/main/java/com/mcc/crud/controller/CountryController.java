/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.crud.controller;

import com.mcc.crud.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Gin
 */
@Controller
public class CountryController {
    @Autowired
    CountryService countryService;
    /*
    @GetMapping("")
    public String index(Model model){
        model.addAttribute("country", countryService.getAll());
        return "index";
    } */
   
}
