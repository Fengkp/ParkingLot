package ParkingLot;

import Vehicle.Car;
import Vehicle.Vehicle;

import java.util.*;

public class ParkingLot {

	private final int NUMBER_OF_SMALL_SPACES = 10;
	private final int NUMBER_OF_MEDIUM_SPACES = 30;
	private final int NUMBER_OF_LARGE_SPACES = 5;
	private final int TOTAL_NUMBER_OF_SPACES = NUMBER_OF_SMALL_SPACES + NUMBER_OF_MEDIUM_SPACES + NUMBER_OF_LARGE_SPACES;
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

	public ParkingSpace getSpace(int spaceNum) {
	    if (!isValidSpaceNum(spaceNum))
	        return null;
        ParkingSpace space = availableSpaces.get(spaceNum - 1);
        return space;
    }

    public boolean hasVehicle(String key) {
	    if (usedSpaces.get(key) == null)
	        return false;
        return true;
    }

	public void occupySpace(Vehicle vehicle, int spaceNum) {
        ParkingSpace spaceToOccupy = getSpace(spaceNum);

	    if (vehicle.getVehicleSize() > spaceToOccupy.getSpaceSize()
                || !spaceToOccupy.getSpaceAvailable()) {
	        System.out.println("Invalid Space");
            return;
        }

        spaceToOccupy.setSpaceAvailable(false);
	    usedSpaces.put(vehicle.getLicensePlateNum(), spaceToOccupy);
    }

    public void makeSpaceAvailable(String key) {
	    if (usedSpaces.get(key) == null)
	        return;
	    usedSpaces.remove(key);
    }

	public int getTotalSpaces() {
	    return TOTAL_NUMBER_OF_SPACES;
    }

	public void getUsedSpaces(String key) {
        ParkingSpace usedSpace = usedSpaces.get(key);
        usedSpace.display();
    }

    public boolean isValidSpaceNum(int num) {
        if (num > TOTAL_NUMBER_OF_SPACES || num < 1)
            return false;
        return true;
    }
}