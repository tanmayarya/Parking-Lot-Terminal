package Models;

//Class to control initialization and properties of a ParkingSlot
public class ParkingSlot {
	private int slotNumber; // Slot Number Of Parking Slot
	private Car car; // Car parked at the current slot

	public ParkingSlot(int slotNum) {
		this.slotNumber = slotNum;
	}

	// getter and setters for the fields

	public int getSlotNumber() {
		return this.slotNumber;
	}

	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}

	public Car getCar() {
		return this.car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
}
