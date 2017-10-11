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
    public boolean isDrivable() {
        return super.isDrivable;
    }

    @Override
    public void setDrivable(boolean towed) {
	    super.isDrivable = towed;
    }

    @Override
    public int wheelCount() {
        return 2;
    }
}