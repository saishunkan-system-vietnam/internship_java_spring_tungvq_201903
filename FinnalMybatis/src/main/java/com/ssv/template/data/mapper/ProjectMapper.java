package com.ssv.template.data.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssv.template.model.Building;
import com.ssv.template.model.Project;

public interface ProjectMapper extends Mapper<Project> {
	public int insertProject(Project project);

	public int updateProject(Project project);

	public int deleteProjectById(int id);
	
	public int selectProjectById(int id);
	
	public int selectProjectByName(Project project);
	
	List<Project> findByNameContaining(@Param("nameproject") String nameproject,@Param("startsearch") String startsearch,@Param("endsearch") String endsearch,@Param("namebuilding") String namebuilding);
	
	List<Project> findByNameContaining1(@Param("nameproject") String nameproject);
	
	List<Project> findByDateContaining(String b);
	
	
}


