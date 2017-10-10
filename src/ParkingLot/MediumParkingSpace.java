package ParkingLot;

public class MediumParkingSpace extends ParkingSpace {

	private final double HOURLY_RATE = 10.00;
    private final int SIZE = 3;

	public MediumParkingSpace(int spaceNum) {
		super.setHourlyRate(HOURLY_RATE);
		super.setSpaceNum(spaceNum);
		super.setSpaceAvailable(true);
        super.setSpaceSize(SIZE);
	}

    @Override
    public String spaceType() {
        return "MEDIUM";
    }
}