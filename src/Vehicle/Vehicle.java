package Vehicle;

public abstract class Vehicle {

	private String licensePlateNum;
	private String color;
	private int vehicleSize;

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
}