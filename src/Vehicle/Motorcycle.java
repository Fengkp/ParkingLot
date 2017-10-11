package Vehicle;

public class Motorcycle extends Vehicle implements Drivable {

	private final int SIZE = 1;

	public Motorcycle(String iD, String color) {
        super.setLicensePlateNum(iD.toUpperCase());
        super.setColor(color.toUpperCase());
        super.setVehicleSize(SIZE);
	}

    @Override
    public String vehicleType() {
        return "MOTORCYCLE";
    }

    @Override
    public void isDrivable() {
        
    }
}