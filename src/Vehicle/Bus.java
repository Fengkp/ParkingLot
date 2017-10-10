package Vehicle;

public class Bus extends Vehicle{

	private final int SIZE = 4;

	public Bus(String iD, String color) {
		super.setLicensePlateNum(iD);
		super.setColor(color);
		super.setVehicleSize(SIZE);
	}
}