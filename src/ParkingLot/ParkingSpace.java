package ParkingLot;

public abstract class ParkingSpace {
	
	private int spaceNum;
	private double hourlyRate;
	private boolean spaceAvailable;

	public int getSpaceNum() {
		return spaceNum;
	}

	public void setSpaceNum(int spaceNum) {
		this.spaceNum = spaceNum;
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

    public boolean getSpaceAvailable() {
        return spaceAvailable;
    }

    public void setSpaceAvailable(boolean spaceAvailable) {
        this.spaceAvailable = spaceAvailable;
    }
}