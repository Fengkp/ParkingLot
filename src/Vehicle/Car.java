package Vehicle;

public class Car extends Vehicle implements Drivable{

	private final int SIZE = 2;

	public Car(String iD, String color) {
		super.setLicensePlateNum(iD.toUpperCase());
		super.setColor(color.toUpperCase());
		super.setVehicleSize(SIZE);
	}

	@Override
	public String vehicleType() {
		return "CAR";
	}

	@Override
	public void isDrivable() {

	}
}