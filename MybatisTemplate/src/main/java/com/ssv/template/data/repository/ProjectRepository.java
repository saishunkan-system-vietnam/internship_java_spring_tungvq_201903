package com.ssv.template.data.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ssv.template.data.mapper.ProjectMapper;
import com.ssv.template.model.Project;
import com.ssv.template.utils.AppStringUtils;

public class ProjectRepository extends Repository<Project, ProjectMapper> {

	@Override
	protected ProjectMapper mapper(SqlSession session) {
		return session.getMapper(ProjectMapper.class);
	
	}

	@Override
	public String tableName() {
		return AppStringUtils.toTableName(Project.class);
	}
	
	public int insertProject(Project project) {
		return execute((mapper) -> {
			return mapper.insertProject(project);
		});
	}
	
	public int updateProject(Project project) {
		return execute((mapper) -> {
			return mapper.updateProject(project);
		});
	}
	
	public int deleteProjectById(int id) {
		return execute((mapper) -> {
			return mapper.deleteProjectById(id);
		});
	}

	public static List<Project> findByNameContaining(String q) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
	

