package Models;

// Class to control initialization and properties of a Car
public class Car {

	private String registerationNumber; // Registration Number Of Car
	private Driver driver; // Reference to driver of the Car
	private ParkingSlot parkingSlot; // Parking slot alloted to Car

	public Car(String registerationNumber, int driversAge) { // constructor
		this.registerationNumber = registerationNumber;
		driver = new Driver(driversAge);
	}

	// getter and setters for the fields

	public String getRegisterationNumber() {
		return this.registerationNumber;
	}

	public void setRegisterationNumber(String registerationNumber) {
		this.registerationNumber = registerationNumber;
	}

	public Driver getDriver() {
		return this.driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public ParkingSlot getParkingSlot() {
		return this.parkingSlot;
	}

	public void setParkingSlot(ParkingSlot parkingSlot) {
		this.parkingSlot = parkingSlot;
	}

}
