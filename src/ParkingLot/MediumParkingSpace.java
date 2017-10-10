package ParkingLot;

public class MediumParkingSpace extends ParkingSpace {

	private final double HOURLY_RATE = 10.00;

	public MediumParkingSpace(int spaceNum) {
		super.setHourlyRate(HOURLY_RATE);
		super.setSpaceNum(spaceNum);
		super.setSpaceAvailable(true);
	}
}