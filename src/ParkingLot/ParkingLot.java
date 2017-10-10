package ParkingLot;

import Vehicle.Car;
import Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class ParkingLot {

	private int NUMBER_OF_SMALL_SPACES = 10;
	private int NUMBER_OF_MEDIUM_SPACES = 10;
	private int NUMBER_OF_LARGE_SPACES = 10;
	private List<ParkingSpace> availableSpaces;
	private Hashtable<Vehicle, ParkingSpace> usedSpaces;

	public ParkingLot() {
		availableSpaces = new ArrayList<>(NUMBER_OF_SMALL_SPACES + NUMBER_OF_MEDIUM_SPACES + NUMBER_OF_LARGE_SPACES);
		createLot();
	}

	public void createLot() {
		int spaceCount = 1;

		for (int i = 1; i <= NUMBER_OF_SMALL_SPACES; i++) {
			availableSpaces.add(new SmallParkingSpace(spaceCount));
			spaceCount++;
		}
		for (int i = 1; i <= NUMBER_OF_MEDIUM_SPACES; i++) {
			availableSpaces.add(new MediumParkingSpace(spaceCount));
			spaceCount++;
		}
		for (int i = 1; i <= NUMBER_OF_LARGE_SPACES; i++) {
			availableSpaces.add(new LargeParkingSpace(spaceCount));
			spaceCount++;
		}
	}

	public void getAvailableSpaces() {
		System.out.print("Available Parking Spaces: ");
		for (ParkingSpace space : availableSpaces) {
			if (space.getSpaceAvailable())
				System.out.print(space.getSpaceNum() + ", ");
		}
	}

	
	public void display() {
		System.out.println("Parking Lot Size: " + availableSpaces.size() + "total parking spaces");
		getAvailableSpaces();
		System.out.println();

	}

	public static void main(String[] args) {
	    ParkingLot lot = new ParkingLot();
	    Vehicle car = new Car("HDX1234", "red");

    }
}