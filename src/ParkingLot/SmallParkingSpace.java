package ParkingLot;

public class SmallParkingSpace extends ParkingSpace {

    private final double HOURLY_RATE = 10.00;

    public SmallParkingSpace(int spaceNum) {
        super.setHourlyRate(HOURLY_RATE);
        super.setSpaceNum(spaceNum);
        super.setSpaceAvailable(true);
    }
}