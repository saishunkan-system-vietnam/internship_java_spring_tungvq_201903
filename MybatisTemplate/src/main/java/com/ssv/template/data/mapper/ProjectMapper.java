package com.ssv.template.data.mapper;

import java.util.List;


import com.ssv.template.model.Project;

public interface ProjectMapper extends Mapper<Project> {
	public int insertProject(Project project);

	public int updateProject(Project project);

	public int deleteProjectById(int id);
	
	public int selectProjectById(int id);
	
	public int selectProjectByName(Project project);
	
	List<Project> findByNameContaining(String q);
	
	
	
}


