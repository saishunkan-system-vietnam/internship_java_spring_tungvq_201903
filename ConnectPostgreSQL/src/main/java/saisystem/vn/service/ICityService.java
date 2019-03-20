package saisystem.vn.service;

import java.util.List;

import saisystem.vn.bean.City;

public interface ICityService {

    public List<City> findAll();
    
    public City save(City model);
}