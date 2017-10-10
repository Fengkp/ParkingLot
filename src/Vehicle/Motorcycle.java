package Vehicle;

public class Motorcycle extends Vehicle{

	private final int SIZE = 1;

	public Motorcycle(String iD, String color) {
		super.setLicensePlateNum(iD);
		super.setColor(color);
		super.setVehicleSize(SIZE);
	}
}