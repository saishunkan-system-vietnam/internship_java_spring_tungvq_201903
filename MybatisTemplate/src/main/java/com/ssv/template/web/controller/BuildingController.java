package com.ssv.template.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
	    return "addbuilding";
	  }
	
	 @RequestMapping("/saveBuilding")
	  public String doSaveCustomer(@ModelAttribute("Building") Building building, Model model) {
		new BuildingService().insertBuilding(building);
		model.addAttribute("buildingList", new BuildingService().selectAllBuilding());
		return BASE_DIR + "/index";
	}
	
	
	
	@RequestMapping("/detail/{id}")
	public String detail(@PathVariable int id, Model model) {
		Building b = new BuildingService().selectBuildingById(id);
		model.addAttribute("building", b);
		return BASE_DIR + "/details";
	}
	
	@RequestMapping(value = { "/test" })
	public String test(Model model) {
		model.addAttribute("buildingList", new BuildingService().selectAllBuilding());
		return BASE_DIR + "/test";
	}
}
