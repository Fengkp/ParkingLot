package Vehicle;

public class Bus extends Vehicle{

    public Bus() {}

    public Bus(String iD, String color, String size) {
        super.setLicensePlateID(iD);
        super.setColor(color);
        super.setSize(size);
    }
}