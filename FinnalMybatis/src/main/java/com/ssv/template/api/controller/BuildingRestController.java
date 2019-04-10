package com.ssv.template.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssv.template.model.Building;
import com.ssv.template.service.BuildingService;

@RestController
@RequestMapping("/api/building")
public class BuildingRestController {

	@CrossOrigin
	@RequestMapping("/detail/{id}")
	public Building detail(@PathVariable int id) {
		Building building = new BuildingService().selectBuildingById(id);
		return building;
	}

	@CrossOrigin
	@GetMapping(value= "/list")
	public List<Building> getBuildingList() {
		List<Building> list = new BuildingService().selectAllBuilding();
		return list;
	}
	
	@CrossOrigin
	@PostMapping("/add")
	public Building createBuilding(@Valid @RequestBody Building building) {
		new BuildingService().insertBuilding(building);
	    return building;
	  }
	
}
