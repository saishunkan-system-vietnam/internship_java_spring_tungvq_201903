package com.ssv.template.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String actionAdd(Model model) {
		model.addAttribute("building", new Building());
	 
		return BASE_DIR + "/addbuilding";
	}
	
	@RequestMapping("/successAdd")
	public String doAdd(@ModelAttribute ("Building") Building building,Model model) {
		int result = new BuildingService().insertBuilding(building);
		if (result != 0) {
			model.addAttribute("buildingList", new BuildingService().selectAllBuilding());
			return BASE_DIR + "/index";
		}
		return null;
	}
	 
	 
	@RequestMapping("/deleteBuilding/{id}")
	public String doDelete(@PathVariable int id ,Model model) {
		new BuildingRepository().deleteBuildingById(id);
		model.addAttribute("buildingList", new BuildingService().selectAllBuilding());
		return BASE_DIR + "/index";
	}
	
	
	@RequestMapping("/view/{id}")
	public String doView(@PathVariable int id,Model model) {
		Optional<Building> building = new BuildingRepository().findById(id);
		if(building.isPresent()) {
			model.addAttribute("building",building.get());
			return BASE_DIR + "/view";
		}
		return BASE_DIR + "/view";
	}
	
	@RequestMapping("/editForm/{id}")
	public String actionEdit(@PathVariable int id, Model model) {
		Optional<Building> building =  new BuildingRepository().findById(id);
		if(building.isPresent()) {
			model.addAttribute("building", building.get());
			return BASE_DIR + "/editForm";
		}
		return null;
	}
	
	@RequestMapping("/doneEdit")
	public String doEdit(@ModelAttribute("Building") Building building,Model model) {
		int result = new BuildingService().updateBuilding(building);
		if(result != 0) {
			model.addAttribute("buildingList", new BuildingService().selectAllBuilding());
			return BASE_DIR + "/index";
		}
		return null;
	}
	
	@RequestMapping("/search")
	public String doSearch(@RequestParam("name") String name, @RequestParam("arfrom") String arfrom, @RequestParam("arto") String arto,@RequestParam("floorfrom") String floorfrom, @RequestParam("floorto") String floorto ,Model model) {
		List<Building> building = new BuildingService().search(name,arfrom,arto,floorfrom,floorto);
		model.addAttribute("buildingList",building );
		model.addAttribute("name", name);
		model.addAttribute("arfrom", arfrom);
		model.addAttribute("arto", arto);
		model.addAttribute("floorfrom", floorfrom);
		model.addAttribute("floorto", floorto);
		return BASE_DIR + "/index";
	}
}
