package ParkingLot;

import Vehicle.Car;
import Vehicle.Vehicle;

import java.util.*;

public class ParkingLot {

	private int NUMBER_OF_SMALL_SPACES = 10000;
	private int NUMBER_OF_MEDIUM_SPACES = 10000;
	private int NUMBER_OF_LARGE_SPACES = 10000;
	private List<ParkingSpace> availableSpaces;
	private Map<String, ParkingSpace> usedSpaces;

	public ParkingLot() {
		availableSpaces = new ArrayList<>(NUMBER_OF_SMALL_SPACES + NUMBER_OF_MEDIUM_SPACES + NUMBER_OF_LARGE_SPACES);
		usedSpaces = new HashMap<>();
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

	public void occupySpace(Vehicle vehicle, int spaceNum) {
        ParkingSpace spaceToOccupy = availableSpaces.get(spaceNum - 1);

	    if (vehicle.getVehicleSize() > spaceToOccupy.getSpaceSize()
                || !spaceToOccupy.getSpaceAvailable()) {
	        System.out.println("Invalid Space");
            return;
        }

        spaceToOccupy.setSpaceAvailable(false);
	    usedSpaces.put(vehicle.getLicensePlateNum(), spaceToOccupy);
    }

    public void getUsedSpaces(String key) {
        ParkingSpace usedSpace = usedSpaces.get(key);
        usedSpace.display();

    }
}