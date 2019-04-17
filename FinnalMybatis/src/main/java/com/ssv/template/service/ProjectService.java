package com.ssv.template.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.ssv.template.data.repository.ProjectRepository;
import com.ssv.template.model.Project;


public class ProjectService {
	public int insertProject(Project project) {
		return new ProjectRepository().insertProject(project);
	}

	public int updateProject(Project project) {
		return new ProjectRepository().updateProject(project);
	}

	public int deleteProjectById(int id) {
		return new ProjectRepository().deleteProjectById(id);
	}

	public List<Project> selectAllProject() {
		return new ProjectRepository().findAll();
	}
	
	public List<Project> search(String nameproject,String startsearch,String endsearch,String namebuilding) {
        return new ProjectRepository().findByNameContaining(nameproject,startsearch,endsearch,namebuilding);
    }
	
	
	public Project selectProjectById(int id) {
		Optional<Project> optProject = new ProjectRepository().findById(id);
		if (optProject.isPresent()) {
			return optProject.get();
		}
		return null;
	}

	public List<Project> searchStart(String b) {
		 return new ProjectRepository().findByDateContaining(b);
	}
	
	public List<Project> searchName(String nameproject){
		return new ProjectRepository().findByNameContaining1(nameproject);
	}



}