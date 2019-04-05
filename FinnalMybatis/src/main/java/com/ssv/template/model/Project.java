package com.ssv.template.model;

import java.util.Date;
import java.util.Optional;

import org.springframework.format.annotation.DateTimeFormat;

import com.ssv.template.data.repository.BuildingRepository;

public class Project {
	private int id;
	private String nameproject;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startdate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date enddate;
	private int buildingId;

	public int getBuildingId() {
		return buildingId;
	}

	public void setBuildingid(int buildingId) {
		this.buildingId = buildingId;
	}

	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameproject() {
		return nameproject;
	}

	public void setNameproject(String nameproject) {
		this.nameproject = nameproject;
	}
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Building getReferenceBuilding() {
		Optional<Building> optBuilding = new BuildingRepository().findById(this.getBuildingId());
		if (optBuilding.isPresent()) {
			return optBuilding.get();
		}
		return null;
	}
	
	
}
