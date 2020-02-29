package Commands;

import Controller.ParkingLot;

public class Command {
	ParkingLot parkingLot;

	public Command(ParkingLot parkingLot) { // Constructor
		this.parkingLot = parkingLot;
	}

	// Function to be executed if command is not found
	public void execute(String args[]) {
		System.out.println("Invalid Command");
	}
}
