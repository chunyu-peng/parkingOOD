public class Bus extends Vehicle {
    public Bus() {
        spotsNeeded = 5;
        size = VehicleSize.Large;
    }

    public boolean canFitInSpot(ParkingSpot spot) {
        if (spot.getSize() == VehicleSize.Large) {
            return true;
        }
    }

    public void print() {
        System.out.println("Bus");
    }
}
