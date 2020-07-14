/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.crud.controller;

import com.mcc.crud.entities.Region;
import com.mcc.crud.services.RegionService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Gin
 */
@Controller
public class RegionController {
    @Autowired
    RegionService regionService;  
    
    /**
     * controller base url
     * @return view index
     */
    @GetMapping("")
    public String index(Model model, String keyword){
        model.addAttribute("regions", regionService.getAll()); 
        return "index";
    }  
    /**
     * controller menyimpan data dari index
     * @return view base url
     */ 
    @PostMapping("/save")
    public String save(@Valid Region region){
        regionService.save(region);
        return "redirect:/";
    }
    /**
     * controller menghubungkan index menuju new region page
     * @return url new region
     */
    @GetMapping("/newRegion") 
    public String showNewRegion(Model model){ 
        model.addAttribute("region", new Region());
        return "NewRegion";
    }
    
    /**
     * 
     * controller menlakukan update databerdasarkan id pada tabel
     * @return view edit data
     */
    @RequestMapping("/edit/{id}")
    public ModelAndView ShowEditRegion(@PathVariable(name = "id") Integer id){ 
        ModelAndView mav = new ModelAndView("EditRegion"); 
        Region region = regionService.getById(id);
        mav.addObject("region",region);
        return mav;
    }
    /**
     * 
     * controller menghapus data pada tabel
     * @return base url
     */
    @RequestMapping("/delete/{id}")
    public String deleteRegion(@PathVariable(name = "id") Integer id){
        regionService.delete(id);
        return "redirect:/";
    }
    /**
     * 
     * controller untuk binding table berdasarkan search keyword  
     * return tabel updated
     */
    @GetMapping("/search")
    public String searchByKeyword(Model model, String keyword){
        if (keyword != null) {
            model.addAttribute("regions", regionService.searchByKeyword(keyword));
        } else {
            model.addAttribute("regions", regionService.getAll());
        }
        
        return "index";
    }
    
}
