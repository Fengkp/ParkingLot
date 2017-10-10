package App;

import ParkingLot.ParkingLot;
import Vehicle.*;

public class App {
        public static void main(String[] args) {
            ParkingLot lot = new ParkingLot();
            Vehicle car = new Car("HDX1234", "red");
            Vehicle bus = new Bus("HDX1235", "black");

            lot.occupySpace(bus, 2);
            lot.occupySpace(bus, 10);
            lot.occupySpace(car, 2);
            lot.occupySpace(bus, 20);
            lot.occupySpace(car, 19);
            lot.occupySpace(car, 19000);
            lot.occupySpace(bus, 25000);
            //car.display();
            lot.getUsedSpaces("HDX1234");
            lot.getUsedSpaces("HDX1235");

            System.out.println();
        }
}
