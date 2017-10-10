package ParkingLot;

public class LargeParkingSpace extends ParkingSpace {

	private final double HOURLY_RATE = 15.00;

	public LargeParkingSpace(int spaceNum) {
		super.setHourlyRate(HOURLY_RATE);
		super.setSpaceNum(spaceNum);
		super.setSpaceAvailable(true);
	}
}