package com.flipkart.exception;

public class SlotFullException extends Exception {
	private Integer gymID;
	private Integer slotNumber;
	
	public SlotFullException(Integer gymID, Integer slotNumber) {
		this.gymID = gymID;
		this.slotNumber = slotNumber;
	}
	
	public Integer getGymID() {
		return gymID;
	}
	
	public Integer getSlotNumber() {
		return slotNumber;
	}
}
