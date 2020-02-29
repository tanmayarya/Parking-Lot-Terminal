package Controller;

import java.util.*;

import Models.*;

// Controller class controls all the commands and handling for the parking slots
public class ParkingLot {

	int parkingLotCapacity; // Data member to store the capacity of the parking lot
	int availableSlots; // Data member to store the number of available slots
	HashSet<String> parkedCars; // Data member to store list of parked cars
	ArrayList<ParkingSlot> parkingSlots; // Data member to store the parking slots in the overall parking lot

	public ParkingLot() {
		parkingLotCapacity = 0;
		availableSlots = 0;
		parkedCars = new HashSet<String>();
		parkingSlots = new ArrayList<ParkingSlot>();
	}

	// This function will create a new parking lot with Capacity amount of Parking
	// slots
	public void createParkingLot(int capacity) {

		if (capacity <= 0) {
			System.out.println("Invalid capacity for the parking lot. Please enter a valid capacity");
			return;
		}
		if (parkingLotCapacity > 0) // check if parking already exist;
		{
			System.out.println("Parking already exist");
			return;
		}
		parkingLotCapacity = capacity; // Initialize the parking lot with the input capacity
		availableSlots = capacity;
		for (int i = 0; i < capacity; i++)
			parkingSlots.add(new ParkingSlot(i + 1)); // Append a new Parking Slot to the overall Parking lot

		System.out.println("Created parking of " + capacity + " slots");
	}

	// This function will park a car to an available nearest slot
	public void createCarAndPark(String registerationNumber, int driversAge) {
		if (parkingLotCapacity == 0) { // check if parking lot exist
			System.out.println("No parking lot exist");
			return;
		}
		if (availableSlots <= 0) { // check for availability of slots
			System.out.println("Sorry, parking lot is full");
			return;
		}
		if (parkedCars.contains(registerationNumber)) { // check if the car is already parked
			System.out.println("This car is already parked");
			return;
		}
		if (driversAge <= 0) { // check if driver's age is valid
			System.out.println("Enter valid Driver's age");
			return;
		}
		ParkingSlot slot = null;
		for (ParkingSlot parkingSlot : parkingSlots) { // Finding the first empty slot from the Parking lot
			if (parkingSlot.getCar() == null) {
				slot = parkingSlot; // If slot is empty then allocate a new slot
				break;
			}
		}

		Car car = new Car(registerationNumber, driversAge); // Create a new car entry
		slot.setCar(car); // Make an entry to store the car in the parking slot
		car.setParkingSlot(slot); // Make an entry to store the slot number corresponding to the current car
		availableSlots--; // decreasing available slots when new car enters
		parkedCars.add(registerationNumber); // entering the car to parked car list;
		System.out.println("Car with vehicle registration number “" + registerationNumber
				+ "” has been parked at slot number " + slot.getSlotNumber());

	}

	// this function Removes a car from the slot it earlier occupied
	public void leaveParkingSlot(int slotNumber) {
		if (parkingLotCapacity == 0) { // check if parking lot exist
			System.out.println("No parking lot exist");
			return;
		}
		if (slotNumber > parkingLotCapacity || slotNumber <= 0) { // check for valid slot number
			System.out.println("Slot number doesn't exist. Please enter a valid slot to leave");
			return;
		}
		Car car = parkingSlots.get(slotNumber - 1).getCar();
		if (car == null) { // check if slot is already empty
			System.out.println("Slot is already empty");
			return;
		}
		parkingSlots.set(slotNumber - 1, new ParkingSlot(slotNumber)); // Remove the entry of the car from the parking
		parkedCars.remove(car.getRegisterationNumber()); // Remove the entry of the car from the parking cars list
		availableSlots++; // increasing available slots when car left
		System.out.println("Slot number " + slotNumber + " vacated, the car with vehicle registration number “"
				+ car.getRegisterationNumber() + "” left the space, the driver of the car was of age "
				+ car.getDriver().getAge());
	}

	// This function returns the list of registration numbers of all the cars
	// corresponding to a given driver's age
	// returns null if no parking lot exist
	public ArrayList<String> registerationNumberForCarsWithDriversAge(int driversAge) {
		if (parkingLotCapacity == 0) { // check if parking lot exist
			return null;
		}
		ArrayList<String> selectedRegisterationNumbersList = new ArrayList<String>();
		for (ParkingSlot parkingSlot : parkingSlots) { // iterate over each slot
			if (parkingSlot.getCar() != null && parkingSlot.getCar().getDriver().getAge() == driversAge) { // check for
																											// valid
																											// condition
				selectedRegisterationNumbersList.add(parkingSlot.getCar().getRegisterationNumber());
			}
		}
		return selectedRegisterationNumbersList; // return the result list
	}

	// This function returns the slot number of the car corresponding to a given
	// registration number
	// return -1 if not found
	// return 0 if parking lot is not created
	public int slotNumberForRegisterationNumber(String registerationNumber) {
		if (parkingLotCapacity == 0) { // check if parking lot exist
			return 0;
		}
		for (ParkingSlot parkingSlot : parkingSlots) {
			if (parkingSlot.getCar() != null
					&& parkingSlot.getCar().getRegisterationNumber().equals(registerationNumber)) // check if
				return parkingSlot.getSlotNumber(); // return slot number if found
		}
		return -1; // return -1 if car does not exist in parking lot
	}

	// This function returns the slot numbers for the cars corresponding to a given
	// driver's age
	// returns null if parking lot does not exist
	public ArrayList<Integer> slotNumberForCarsWithDriversAge(int driversAge) {
		if (parkingLotCapacity == 0) { // check if parking lot exist
			return null;
		}
		ArrayList<Integer> selectedSlotNumbersList = new ArrayList<Integer>();
		for (ParkingSlot parkingSlot : parkingSlots) { // iterate over each slot
			if (parkingSlot.getCar() != null && parkingSlot.getCar().getDriver().getAge() == driversAge) { // check for
																											// valid
																											// condition
				selectedSlotNumbersList.add(parkingSlot.getSlotNumber());
			}
		}
		return selectedSlotNumbersList; // return the result list of slot numbers
	}

}
