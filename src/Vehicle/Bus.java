package Vehicle;

public class Bus extends Vehicle implements Drivable{

	private final int SIZE = 4;

	public Bus(String iD, String color) {
		super.setLicensePlateNum(iD.toUpperCase());
		super.setColor(color.toUpperCase());
		super.setVehicleSize(SIZE);
	}

	@Override
	public String vehicleType() {
		return "BUS";
	}

	@Override
	public void isDrivable() {

	}
}