package Vehicle;

public class Motorcycle extends Vehicle {

    public Motorcycle() {}

    public Motorcycle(String iD, String color, String size) {
        super.setLicensePlateID(iD);
        super.setColor(color);
        super.setSize(size);
    }
}