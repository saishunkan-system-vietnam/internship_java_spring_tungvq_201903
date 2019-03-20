package saisystem.vn.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import saisystem.vn.bean.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

}