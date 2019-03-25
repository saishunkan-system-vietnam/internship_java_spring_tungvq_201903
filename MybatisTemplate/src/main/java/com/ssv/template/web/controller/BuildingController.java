package com.ssv.template.web.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssv.template.data.repository.BuildingRepository;
import com.ssv.template.model.Building;
import com.ssv.template.service.BuildingService;


@Controller
@RequestMapping("/web/building")
public class BuildingController {
	private static final String BASE_DIR = "web/building";

	@RequestMapping(value = { "/index" })
	public String list(Model model) {
		model.addAttribute("buildingList", new BuildingService().selectAllBuilding());
		return BASE_DIR + "/index";
	}
	
	@RequestMapping("/addbuilding")
	  public String insertBuilding(Model model) {
	    model.addAttribute("building", new Building());
	    return BASE_DIR + "/addbuilding";
	  }
	
	 @RequestMapping("/saveBuilding")
	  public String doSaveBuilding(@ModelAttribute("Building") Building building, Model model) {
		int result = new BuildingService().insertBuilding(building);
		if (result != 0) {
			model.addAttribute("buildingList", new BuildingService().selectAllBuilding());
			return BASE_DIR + "/index";
		}
		return null;
	}
	 
	 
	@RequestMapping("/deleteBuilding/{id}")
	public String doDelete(@PathVariable int id,Model model) {
		new BuildingService().deleteBuildingById(id);
		model.addAttribute("buildingList", new BuildingService().selectAllBuilding());
		return BASE_DIR + "/index";
		
	}
	
	@RequestMapping("/editbuilding-form/{id}")
	public String updateBuilding(@PathVariable int id, Model model) {
		Optional<Building> building = new BuildingRepository().findById(id); ;
	    if (building.isPresent()) {
	      model.addAttribute("building", building.get());
	    }
	   
		return BASE_DIR + "/editbuilding-form";
		
	}
	
	@RequestMapping("/editBuilding")
	public String successUpdateBuilding(@ModelAttribute("Building") Building building, Model model) {
		int result = new BuildingService().updateBuilding(building);
		if (result != 0){
			model.addAttribute("buildingList", new BuildingService().selectAllBuilding());
		}
		return BASE_DIR + "/index";
	}
	
	@RequestMapping("/view/{id}")
	public String view(@PathVariable int id, Model model) {
		Optional<Building> building = new BuildingRepository().findById(id);
		if (building.isPresent()) {
			model.addAttribute("building", building.get());
		}
		return BASE_DIR + "/view";
	}

	
	@RequestMapping(value = { "/test" })
	public String test(Model model) {
		model.addAttribute("buildingList", new BuildingService().selectAllBuilding());
		return BASE_DIR + "/test";
	}
}
