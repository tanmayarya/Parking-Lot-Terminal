package Commands;

import Controller.ParkingLot;

//Class to control the Create_parking_lot command
public class CreateParkingLot extends Command {

	public CreateParkingLot(ParkingLot parkingLot) {
		super(parkingLot);
	}

	public void execute(String args[]) {
		try {
			int capacity = Integer.parseInt(args[1]); // Capacity of the parking lot
			parkingLot.createParkingLot(capacity);
		} catch (NumberFormatException e) {
			System.out.println("Invalid capacity"); // capacity is invalid
		} catch (Exception e) { // to handle other exceptions
			System.out.println("Command can not be executed, some parameters are missing");
		}
	}
}
