package Vehicle;

public class Car extends Vehicle{

	private final int SIZE = 2;

	public Car(String iD, String color) {
		super.setLicensePlateNum(iD);
		super.setColor(color);
		super.setVehicleSize(SIZE);
	}
}