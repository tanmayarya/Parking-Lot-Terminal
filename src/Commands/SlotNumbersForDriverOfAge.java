package Commands;

import java.util.*;

import Controller.ParkingLot;

// Class to control the slot_numbers_for_cars_with_colour command
public class SlotNumbersForDriverOfAge extends Command {

	public SlotNumbersForDriverOfAge(ParkingLot parkingLot) {
		super(parkingLot);
	}

	public void execute(String args[]) {
		try {
			int driversAge = Integer.parseInt(args[1]); // Color of the cars whose slots are supposed to be extracted
			ArrayList<Integer> slotNumbers = parkingLot.slotNumberForCarsWithDriversAge(driversAge);
			if (slotNumbers == null) { // no parking lot exist case
				System.out.println("No parking lot exist");
			} else if (slotNumbers.isEmpty()) { // Check if list is empty
				System.out.println("No slots have cars with given Driver's age");
			} else {
				for (int i = 0; i < slotNumbers.size(); i++) {
					System.out.print(slotNumbers.get(i));
					if (i != slotNumbers.size() - 1) // to avoid coma after last number printed
						System.out.print(", ");
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid Driver's age");
		} catch (Exception e) { // to handle other exceptions
			System.out.println("Command can not be executed, some parameters are missing");
		}
	}
}
