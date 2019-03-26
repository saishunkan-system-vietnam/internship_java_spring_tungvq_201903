package com.ssv.template.web.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssv.template.data.repository.ProjectRepository;
import com.ssv.template.model.Project;
import com.ssv.template.service.ProjectService;



@Controller
@RequestMapping("/web/project")
public class ProjectController {
	private static final String BASE_DIR = "web/project";
	
	@RequestMapping(value = { "/index2" })
	public String list(Model model) {
		model.addAttribute("projectList", new ProjectService().selectAllProject());
		return BASE_DIR + "/index2";
	}
	@RequestMapping("/addproject")
	  public String insertProject(Model model) {
	    model.addAttribute("project", new Project());
	    return BASE_DIR + "/addproject";
	  }
	
	 @RequestMapping("/saveProject")
	  public String doSaveProject(@ModelAttribute("Project") Project project, Model model) {
		int result = new ProjectService().insertProject(project);
		if (result != 0) {
			model.addAttribute("projectList", new ProjectService().selectAllProject());
			return BASE_DIR + "/index2";
		}
		return null;
	 }
		 
	 
	@RequestMapping("/deleteProject/{id}")
	public String doDelete(@PathVariable int id,Model model) {
		new ProjectService().deleteProjectById(id);
		model.addAttribute("projectList", new ProjectService().selectAllProject());
		return BASE_DIR + "/index2";
		
	}
	
	@RequestMapping("/editproject-form/{id}")
	public String updateProject(@PathVariable int id, Model model) {
		Optional<Project> project = new ProjectRepository().findById(id); ;
	    if (project.isPresent()) {
	      model.addAttribute("project", project.get());
	    }
	   
		return BASE_DIR + "/editproject-form";
		
	}
	
	@RequestMapping("/editProject")
	public String successUpdateProject(@ModelAttribute("Project") Project project, Model model) {
		int result = new ProjectService().updateProject(project);
		if (result != 0){
			model.addAttribute("projectList", new ProjectService().selectAllProject());
		}
		return BASE_DIR + "/index2";
	}
	
	
	@RequestMapping("/view/{id}")
	public String view(@PathVariable int id, Model model) {
		Optional<Project> project = new ProjectRepository().findById(id);
		if (project.isPresent()) {
			model.addAttribute("project", project.get());
		}
		return BASE_DIR + "/view";
	}
	
	
}
