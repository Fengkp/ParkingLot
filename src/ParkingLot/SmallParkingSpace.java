package ParkingLot;

public class SmallParkingSpace extends ParkingSpace {

    private final double HOURLY_RATE = 10.00;
    private final int SIZE = 1;

    public SmallParkingSpace(int spaceNum) {
        super.setHourlyRate(HOURLY_RATE);
        super.setSpaceNum(spaceNum);
        super.setSpaceAvailable(true);
        super.setSpaceSize(SIZE);
    }

    @Override
    public String spaceType() {
        return "SMALL";
    }
}