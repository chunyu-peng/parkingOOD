import java.util.ArrayList;

enum VehicleSize {
    Motorcycle,
    Compact,
    Large
}

public abstract class Vehicle {
    protected int spotsNeeded;
    protected VehicleSize size;
    protected String licensePlate;

    protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<>();

    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    public VehicleSize getSize() {
        return size;
    }

    public void parkInSpot(ParkingSpot spot) {
        parkingSpots.add(spot);
    }

    public void clearSpots() {
        for (ParkingSpot parkingSpot : parkingSpots) {
            parkingSpot.removeVehicle();
        }
        parkingSpots.clear();
    }

    public abstract boolean canFitInSpot(ParkingSpot spot);
    public abstract void print();
}
