package com.ssv.template.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssv.template.data.repository.BuildingRepository;
import com.ssv.template.model.Building;
import com.ssv.template.service.BuildingService;

@RestController
@RequestMapping("/api/building")
public class BuildingRestController {
	
	
	
	@CrossOrigin
	@RequestMapping(value= "/detail/{id}", method = RequestMethod.GET)
	public Building detail(@PathVariable int id) {
		Building building = new BuildingService().selectBuildingById(id);
		if(building == null) {
			ResponseEntity.notFound().build();
		}
		return building;
	}

	
	@RequestMapping(value= "/list", method = RequestMethod.GET)
	public ResponseEntity<List<Building>> getBuildingList() {
		List<Building> list = new BuildingService().selectAllBuilding();
		if(list.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Building>>(list, HttpStatus.OK);
	}
	
	
	@RequestMapping(value= "/add", method = RequestMethod.POST)
	public Building saveBuilding(@Valid @RequestBody Building building) {
		int result = new BuildingService().insertBuilding(building);
	    return building;
	  }
	
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Building> deleteBuilding(@PathVariable(value = "id") int id) {
		Building building = new BuildingService().selectBuildingById(id);
	    if(building == null) {
	        return ResponseEntity.notFound().build();
	    }
	    new BuildingRepository().deleteBuildingById(id);
	    return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Building updateBuilding(@Valid @RequestBody Building buildingForm){
		Building building = new BuildingService().selectBuildingById(buildingForm.getId());
		building.setArea(buildingForm.getArea());
		building.setName(buildingForm.getName());
		building.setFloor(buildingForm.getFloor());
		int result = new BuildingService().updateBuilding(building);
		return building;
	}
}
