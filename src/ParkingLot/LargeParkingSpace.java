package ParkingLot;

public class LargeParkingSpace extends ParkingSpace {

	private final double HOURLY_RATE = 15.00;
    private final int SIZE = 5;

	public LargeParkingSpace(int spaceNum) {
		super.setHourlyRate(HOURLY_RATE);
		super.setSpaceNum(spaceNum);
		super.setSpaceAvailable(true);
        super.setSpaceSize(SIZE);
	}

    @Override
    public String spaceType() {
        return "LARGE";
    }
}