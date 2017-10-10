package Vehicle;

public abstract class Vehicle implements Drivable{

    private String licensePlateID;
    private String color;
    private String size;

    public String getLicensePlateID() {
        return licensePlateID;
    }

    public void setLicensePlateID(String licensePlateID) {
        this.licensePlateID = licensePlateID;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
