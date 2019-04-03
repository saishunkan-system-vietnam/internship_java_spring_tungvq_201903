package com.ssv.template.model;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class Project {
	private int id;
	private String nameproject;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startdate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date enddate;
	private int buildingId;
	private Building building;
	
	public int getBuildingId() {
		return buildingId;
	}
	public void setBuildingid(int buildingId) {
		this.buildingId = buildingId;
	}
	public Building getBuilding() {
		return building;
	}
	public void setBuilding(Building building) {
		this.building = building;
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
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	
	}
