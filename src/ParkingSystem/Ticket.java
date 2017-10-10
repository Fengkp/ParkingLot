package ParkingSystem;

public class Ticket extends ParkingSystem {

    private String vehicleID;
    private String vehicleColor;
    private String vehicleType;

    public Ticket(String licensePlateID, String color, String size) {
        vehicleID = licensePlateID;
        vehicleColor = color;
        vehicleType = determineVehicleType(size);
    }

    public String determineVehicleType(String size) {

        if (size.toUpperCase().equals("SMALL"))
            return "MOTORCYCLE";
        else if (size.toUpperCase().equals("MEDIUM"))
            return "CAR";
        return "BUS";
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void display() {
        System.out.println("Vehicle ID: " + vehicleID
                + "Vehicle Color: " + vehicleColor
                + "Vehicle Type: " + vehicleType);
    }
}
