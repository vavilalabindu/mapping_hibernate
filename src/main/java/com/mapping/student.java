package com.mapping;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class student {
  
	@Id
	private int stuId;
	private String stuName;
	private String stuClass;
	
	@OneToOne
	private bike bike;
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuClass() {
		return stuClass;
	}
	public void setStuClass(String stuClass) {
		this.stuClass = stuClass;
	}
	public bike getBike() {
		return bike;
	}
	public void setBike(bike bike) {
		this.bike = bike;
	}
	@Override
	public String toString() {
		return "student [stuId=" + stuId + ", stuName=" + stuName + ", stuClass=" + stuClass + ", bike=" + bike + "]";
	}
	
	
	
	
	
	
}
