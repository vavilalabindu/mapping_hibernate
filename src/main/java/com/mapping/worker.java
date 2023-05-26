package com.mapping;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class worker {
	 @Id
	private  int workerId;
	private  String workerName;
	private  String workerField;
	
	@ManyToOne
  private location workerLocation;

	public int getWorkerId() {
		return workerId;
	}

	public void setWorkerId(int workerId) {
		this.workerId = workerId;
	}

	public String getWorkerName() {
		return workerName;
	}

	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}

	public String getWorkerField() {
		return workerField;
	}

	public void setWorkerField(String workerField) {
		this.workerField = workerField;
	}

	public location getWorkerLocation() {
		return workerLocation;
	}

	public void setWorkerLocation(location workerLocation) {
		this.workerLocation = workerLocation;
	}

	@Override
	public String toString() {
		return "worker [workerId=" + workerId + ", workerName=" + workerName + ", workerField=" + workerField
				+ ", workerLocation=" + workerLocation + "]";
	}

	

}
