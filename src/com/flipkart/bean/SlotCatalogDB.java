package com.flipkart.bean;

public class SlotCatalogDB {
	private String gymID;
	public String getGymID() {
		return gymID;
	}
	public void setGymID(String gymID) {
		this.gymID = gymID;
	}
	public int getSlotNumber() {
		return slotNumber;
	}
	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public boolean isAvailableStatus() {
		return availableStatus;
	}
	public void setAvailableStatus(boolean availableStatus) {
		this.availableStatus = availableStatus;
	}
	private int slotNumber;
	private int availableSeats;
	private boolean availableStatus;
}
