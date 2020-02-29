package Commands;

import Controller.ParkingLot;

//Class to control the leave command
public class Leave extends Command {

	public Leave(ParkingLot parkingLot) {
		super(parkingLot);
	}

	public void execute(String args[]) {
		try {
			int slotNumber = Integer.parseInt(args[1]); // Slot number to be left vacant
			parkingLot.leaveParkingSlot(slotNumber);
		} catch (NumberFormatException ex) {
			System.out.println("Invalid slot Number"); // if slot number is invalid
		} catch (Exception e) { // to handle other exceptions
			System.out.println("Command can not be executed, some parameters are missing");
		}
	}
}
