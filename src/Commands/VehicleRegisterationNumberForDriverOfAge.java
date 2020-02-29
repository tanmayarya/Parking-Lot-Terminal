package Commands;

import java.util.ArrayList;

import Controller.ParkingLot;

//Class to control registration_numbers_for_cars_with_colour command
public class VehicleRegisterationNumberForDriverOfAge extends Command {

	public VehicleRegisterationNumberForDriverOfAge(ParkingLot parkingLot) {
		super(parkingLot);
	}

	public void execute(String args[]) {
		try {
			int driversAge = Integer.parseInt(args[1]); // Age of the driver
			ArrayList<String> registerationNumbers = parkingLot.registerationNumberForCarsWithDriversAge(driversAge);
			if (registerationNumbers == null) { // no parking lot exist case
				System.out.println("No parking lot exist");
			} else if (registerationNumbers.isEmpty()) { // if list is empty then there is no car
				System.out.println("There is no car parked in lot with the given driver's age");
			} else {
				for (int i = 0; i < registerationNumbers.size(); i++) {
					System.out.print(registerationNumbers.get(i));
					if (i != registerationNumbers.size() - 1) // to avoid coma after last number printed
						System.out.print(", ");
				}
			}
		} catch (NumberFormatException e) {// if driver's age is not a valid integer
			System.out.println("Invalid driver's age");
		} catch (Exception e) { // to handle other exceptions
			System.out.println("Command can not be executed, some parameters are missing");
		}
	}
}
