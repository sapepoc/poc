package com.sample.model;

public class Fire 
{
	private Room room;
	// getter and setter methods here

	public Fire(Room room) {
		this.room = room;
	}

	
	public Room getRoom() {
		return room;
	}


	public void setRoom(Room room) {
		this.room = room;
	}

	@Override
	public String toString() {
		return "Fire [room=" + room + "]";
	}
	
	
}