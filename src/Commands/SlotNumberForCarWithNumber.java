package Commands;

import Controller.ParkingLot;

// Class to control the slot_number_for_registration_number command
public class SlotNumberForCarWithNumber extends Command {

	public SlotNumberForCarWithNumber(ParkingLot parkingLot) {
		super(parkingLot);
	}

	public void execute(String args[]) {
		try {
			String registerationNumber = args[1]; // Registration number of the car whose slot number is supposed to be
													// extracted
			int slotNumber = parkingLot.slotNumberForRegisterationNumber(registerationNumber);

			if (slotNumber == -1) { // case if registeration number is not found
				System.out.println("Car with the given registeration number is not parked in the Lot");
			} else if (slotNumber == 0) {//case when parking lot is not created
				System.out.println("No parking lot exist");
			} else {
				System.out.println(slotNumber);
			}
		} catch (Exception e) { // to handle other exceptions
			System.out.println("Command can not be executed, some parameters are missing");
		}
	}
}
