public class Car extends Vehicle {
    public Car() {
        spotsNeeded = 1;
        size = VehicleSize.Compact;
    }

    public boolean canFitInSpot(ParkingSpot spot) {
        if (spot.getSize() == VehicleSize.Large || spot.getSize() == VehicleSize.Compact) {
            return true;
        }
    }

    public void print() {
        System.out.println("Car");
    }
}
