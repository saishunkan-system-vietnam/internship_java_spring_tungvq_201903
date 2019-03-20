package saisystem.vn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import saisystem.vn.bean.City;
import saisystem.vn.repository.CityRepository;
import saisystem.vn.service.CityService;
import saisystem.vn.service.ICityService;

@Controller
public class MyController {
    
    @Autowired
    ICityService cityService;
    CityRepository cityRepo;

    @RequestMapping("/showCities")
    public String findCities(Model model) {
        
        List<City> cities = (List<City>) cityService.findAll();
        
        model.addAttribute("cities", cities);
        
        return "showCities";
    }
    
}
