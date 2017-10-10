package Vehicle;

public class Car extends Vehicle {

    public Car() {}

    public Car(String iD, String color, String size) {
        super.setLicensePlateID(iD);
        super.setColor(color);
        super.setSize(size);
    }
}
