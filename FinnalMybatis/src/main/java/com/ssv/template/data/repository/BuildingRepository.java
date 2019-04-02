package com.ssv.template.data.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ssv.template.data.mapper.BuildingMapper;
import com.ssv.template.model.Building;
import com.ssv.template.utils.AppStringUtils;

public class BuildingRepository extends Repository<Building, BuildingMapper> {

	@Override
	protected BuildingMapper mapper(SqlSession session) {
		return session.getMapper(BuildingMapper.class);
	}

	@Override
	public String tableName() {
		return AppStringUtils.toTableName(Building.class);
	}

	public int insertBuilding(Building building) {
		return execute((mapper) -> {
			return mapper.insertBuilding(building);
		});
	}
	
	public int updateBuilding(Building building) {
		return execute((mapper) -> {
			return mapper.updateBuilding(building);
		});
	}
	
	public int deleteBuildingById(int id) {
		return execute((mapper) -> {
			return mapper.deleteBuildingById(id);
		});
	}

	public  List<Building> findByParam(String name, String arfrom, String arto, String floorfrom,
			String floorto) {
		return  execute((mapper) -> {
			return mapper.findByParam(name,arfrom,arto,floorfrom, floorto);
		});
	}
	

}
