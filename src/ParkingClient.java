import Commands.*;
import Controller.*;

import java.io.*;
import java.util.*;

// Class to initialize the whole project
public class ParkingClient {

	ParkingLot parkingLot; // Data member to process the parking lot
	HashMap<String, Command> availableCommands; // Data member to map the commands

	// constructor
	public ParkingClient() {
		parkingLot = new ParkingLot(); // initialize the parking lot
		availableCommands = new HashMap<String, Command>();// Available Commands to be executed
		// mapping all commands to corresponding functions
		availableCommands.put("Create_parking_lot", new CreateParkingLot(parkingLot));
		availableCommands.put("Park", new Park(parkingLot));
		availableCommands.put("Leave", new Leave(parkingLot));
		availableCommands.put("Vehicle_registration_number_for_driver_of_age",
				new VehicleRegisterationNumberForDriverOfAge(parkingLot));
		availableCommands.put("Slot_number_for_car_with_number", new SlotNumberForCarWithNumber(parkingLot));
		availableCommands.put("Slot_numbers_for_driver_of_age", new SlotNumbersForDriverOfAge(parkingLot));
	}

	// Function to execute commands from file input mode or command mode
	public void readAndExecute(String input) {
		String args[] = input.split(" "); // Split the input by space
		String commandName = args[0]; // First argument is the command name
		if (availableCommands.containsKey(commandName))// check for valid command
			availableCommands.get(commandName).execute(args);
		else
			System.out.println("Invalid Command");

	}

	public static void main(String[] args) throws Exception {
		ParkingClient client = new ParkingClient(); // Object of this class for execution of project
		String line;
//		Reading input from console
//		Scanner scn = new Scanner(System.in);
//		while (true) {
//			line = scn.nextLine();
//			client.readAndExecute(line);
//		}

		try {
			BufferedReader bufferReader = new BufferedReader(new FileReader(args[0]));

			while ((line = bufferReader.readLine()) != null) {// read file contents line by line
				if (line.equals("exit")) // condition for exit
					return;
				client.readAndExecute(line); // call to corresponding function
			}
			bufferReader.close(); // closing buffer reader
		} catch (FileNotFoundException ex) {
			System.out.println("File Not Found, please enter a valid path");
			ex.printStackTrace();
		} catch (IOException ex) {
			System.out.println("Unable to read input file");
			ex.printStackTrace();
		}
	}
}
