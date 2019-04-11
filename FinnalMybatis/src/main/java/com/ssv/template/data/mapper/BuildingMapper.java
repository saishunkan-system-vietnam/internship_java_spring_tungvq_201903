package com.ssv.template.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssv.template.model.Building;

public interface BuildingMapper extends Mapper<Building> {
	public int insertBuilding(Building building);

	public int updateBuilding(Building building);

	public int deleteBuildingById(int id);
	
	public int selectBuildingById(int id);
	
	List<Building> findByParam(@Param("name") String name,@Param("arfrom") String arfrom,@Param("arto") String arto,@Param("floorfrom") String floorfrom,
			@Param("floorto") String floorto);

	public Building insertBuilding1(Building building);
}
