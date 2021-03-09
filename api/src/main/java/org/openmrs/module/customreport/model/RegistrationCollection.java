package org.openmrs.module.customreport.model;

import java.util.Date;

public class RegistrationCollection {
	
	private String id;
	
	private String collectionDate;
	
	private int opdPatient;
	
	private int emergencyPatient;
	
	private int malePatient;
	
	private int femalePatient;
	
	private int freePatient;
	
	private int paidPatient;
	
	private int totalPatient;
	
	private double totalCollection;
	
	public RegistrationCollection() {
		
	}
	
	public RegistrationCollection(String collectionDate, int opdPatient, int emergencyPatient, int malePatient,
	    int femalePatient, int freePatient, int paidPatient, int totalPatient, double totalCollection) {
		this.collectionDate = collectionDate;
		this.opdPatient = opdPatient;
		this.emergencyPatient = emergencyPatient;
		this.malePatient = malePatient;
		this.femalePatient = femalePatient;
		this.freePatient = freePatient;
		this.paidPatient = paidPatient;
		this.totalPatient = totalPatient;
		this.totalCollection = totalCollection;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getCollectionDate() {
		return collectionDate;
	}
	
	public void setCollectionDate(String collectionDate) {
		this.collectionDate = collectionDate;
	}
	
	public int getOpdPatient() {
		return opdPatient;
	}
	
	public void setOpdPatient(int opdPatient) {
		this.opdPatient = opdPatient;
	}
	
	public int getEmergencyPatient() {
		return emergencyPatient;
	}
	
	public void setEmergencyPatient(int emergencyPatient) {
		this.emergencyPatient = emergencyPatient;
	}
	
	public int getMalePatient() {
		return malePatient;
	}
	
	public void setMalePatient(int malePatient) {
		this.malePatient = malePatient;
	}
	
	public int getFemalePatient() {
		return femalePatient;
	}
	
	public void setFemalePatient(int femalePatient) {
		this.femalePatient = femalePatient;
	}
	
	public int getFreePatient() {
		return freePatient;
	}
	
	public void setFreePatient(int freePatient) {
		this.freePatient = freePatient;
	}
	
	public int getPaidPatient() {
		return paidPatient;
	}
	
	public void setPaidPatient(int paidPatient) {
		this.paidPatient = paidPatient;
	}
	
	public int getTotalPatient() {
		return totalPatient;
	}
	
	public void setTotalPatient(int totalPatient) {
		this.totalPatient = totalPatient;
	}
	
	public double getTotalCollection() {
		return totalCollection;
	}
	
	public void setTotalCollection(double totalCollection) {
		this.totalCollection = totalCollection;
	}
}
