package com.mapping;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

@Entity
public class manager {

	@Id
	private int managerId;
	private String managerName;
	private String managerLocation;
	
	@ManyToMany
	@JoinTable(
			name="manager_laptop",
			joinColumns= {@JoinColumn(name="managerId")},
			inverseJoinColumns= {@JoinColumn(name="laptopId")}
			)
	
	private List<laptop> lap;

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerLocation() {
		return managerLocation;
	}

	public void setManagerLocation(String managerLocation) {
		this.managerLocation = managerLocation;
	}

	public List<laptop> getLap() {
		return lap;
	}

	public void setLap(List<laptop> lap) {
		this.lap = lap;
	}

	@Override
	public String toString() {
		return "manager [managerId=" + managerId + ", managerName=" + managerName + ", managerLocation="
				+ managerLocation + ", lap=" + lap + "]";
	}
	
	
	
}
