package com.ssv.template.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssv.template.data.repository.ProjectRepository;
import com.ssv.template.model.Building;
import com.ssv.template.model.Project;
import com.ssv.template.service.BuildingService;
import com.ssv.template.service.ProjectService;

@RestController
@RequestMapping("/api/projects")
public class ProjectRestController {
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Project> showListProject(){
		List<Project> list = new ProjectService().selectAllProject();
		return list;
	}
	
	@RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
	public Project detail(@PathVariable int id) {
		Project project = new ProjectService().selectProjectById(id);
		return project;
	}
	
	@RequestMapping(value = "/add" ,method = RequestMethod.POST)
	public Project addProject(@Valid @RequestBody Project project) {
		int resutl = new ProjectService().insertProject(project);
		return project;
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Project> deleteProject(@PathVariable(value = "id") int id) {
		Project project = new ProjectService().selectProjectById(id);
		if(project == null) {
			return ResponseEntity.notFound().build();
		}
		new ProjectService().deleteProjectById(id);
			return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Project update(@Valid @RequestBody Project projectForm ){
		Project project = new ProjectService().selectProjectById(projectForm.getId());
		project.setNameproject(projectForm.getNameproject());
		project.setStartdate(projectForm.getStartdate());
		project.setEnddate(projectForm.getEnddate());
		int result = new ProjectService().updateProject(project);
		return project;
	}
	
	@RequestMapping( value = "/search", method = RequestMethod.GET )
	public ResponseEntity<List<Project>> searchProject(@RequestParam("nameproject") String nameproject ) {
		List<Project> list = new ProjectService().searchName(nameproject);
		if (list.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Project>>(list, HttpStatus.OK);
	}	
}
