package com.nestedcode.jsontomap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class SaveBean {
@Id	
@GeneratedValue(strategy=GenerationType.AUTO)
private int mid;
private String date;
private String nav;
public int getMid() {
	return mid;
}
public void setMid(int mid) {
	this.mid = mid;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getNav() {
	return nav;
}
public void setNav(String nav) {
	this.nav = nav;
}
public SaveBean(int mid, String date, String nav) {
	super();
	this.mid = mid;
	this.date = date;
	this.nav = nav;
}
public SaveBean() {
	
}
}
