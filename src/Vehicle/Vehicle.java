package Vehicle;

public abstract class Vehicle {

	private String licensePlateNum;
	private String color;
	private int vehicleSize;
	protected boolean isParked;

	public String getLicensePlateNum() {
		return licensePlateNum;
	}

	public void setLicensePlateNum(String licensePlateNum) {
		this.licensePlateNum = licensePlateNum;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getVehicleSize() {
		return vehicleSize;
	}

	public void setVehicleSize(int vehicleSize) {
		this.vehicleSize = vehicleSize;
	}

	public void display() {
	    System.out.println("License Plate Number: " + licensePlateNum
                + "\nVehicle Type: " + vehicleType()
                + "\nVehicle Color: " + color);
    }

    public String vehicleType() {
	    return null;
    }

    @Override
    public int hashCode() {
		return licensePlateNum.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		return this.licensePlateNum.equals(o);
	}

}