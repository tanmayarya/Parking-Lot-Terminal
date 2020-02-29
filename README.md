# Parking lot problem implemented in java

Instructions to execute the project:

- Install java on your machine
	
	Refer the following links to install java

	For mac: https://java.com/en/download/help/mac_install.xml 
		or refer this video: https://www.youtube.com/watch?v=s5g59Z6C5Ts
	
	For ubuntu: https://linuxize.com/post/install-java-on-ubuntu-18-04/
		or refer this video: https://youtu.be/wxZ-R7XWWBs

- Download or clone the project

	link: https://github.com/tanmayarya/SquadParkingProblem


- Open terminal, Change the directory to src folder of the downloaded project
	
	example command: 
```
cd Downloads/SquadParkingProblem/src
```

- Paste the input text file in this folder

- Compile the program(ParkingClient.java) using javac compiler
	
	example command: 
```
javac ParkingClient.java
```
	this will compile the code and create .class file

- Run the compiled program using java interpreter and pass the input file(input.txt) as argument
	
	example command: java ParkingClient "input file name" 
	
```
java ParkingClient input.txt
```

- Use the exit command in input file to exit the program


## Application Explanation/flow
- ParkingClient.java is the root file of the app which initializes the whole project and handles all the inputs from the user through reading file input.

- Car.java, Driver.java and ParkingSlot.java are model classes which are interacting with ParkingLot.java for saving their instances in ParkingLot.java's parkingSlots[].

- ParkingLot is the file which acts as a controller and contains all required methods for making this app functional and interactive.

- Commands contains all the classes for specific terminal commands for the project.