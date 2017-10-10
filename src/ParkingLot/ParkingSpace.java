package ParkingLot;

public abstract class ParkingSpace implements Availability {

    private boolean spaceAvailable;
    private String ticket;
    private double hourlyRate;

    @Override
    public boolean isAvailable() {
        return spaceAvailable;
    }

    public void setHourlyRate(double rate) {
        hourlyRate = rate;
    }

    public boolean setTicket(String ticket) {
        if (!spaceAvailable)
            return false;

        this.ticket = ticket;
        spaceAvailable = false;
        return true;
    }



}
