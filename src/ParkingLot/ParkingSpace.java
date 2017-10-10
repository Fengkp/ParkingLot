package ParkingLot;

public abstract class ParkingSpace {
	
	private int spaceNum;
	private double hourlyRate;
	private boolean spaceAvailable;
	private int spaceSize;

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

    public int getSpaceSize() {
        return spaceSize;
    }

    public void setSpaceSize(int spaceSize) {
        this.spaceSize = spaceSize;
    }

    public void display() {
	    System.out.println("Ticket Number: " + "test"
                + "\nParking Space Number: " + spaceNum
                + "\nParking Space Type: " + spaceType());
    }

    public String spaceType() {
	    return null;
    }
}