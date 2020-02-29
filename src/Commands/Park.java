package Commands;

import Controller.ParkingLot;

// Class to control the park command
public class Park extends Command {
	public Park(ParkingLot parkingLot) {
		super(parkingLot);
	}

	// args[0] is name of the command
	public void execute(String args[]) {
		try {
			String registerationNumber = args[1]; // Registration number of the car to be parked
			int driversAge = Integer.parseInt(args[3]); // Age of the driver

			parkingLot.createCarAndPark(registerationNumber, driversAge);
		} catch (NumberFormatException e) {
			System.out.println("Invalid parameters"); // if parameters are not valid
		} catch (Exception e) { // to handle other exceptions
			System.out.println("Command can not be executed, some parameters are missing");
		}
	}
}
