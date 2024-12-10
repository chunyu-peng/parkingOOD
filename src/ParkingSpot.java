public class ParkingSpot {
    private Vehicle vehicle;
    private VehicleSize spotSize;
    private int row;
    private int spotNumber;
    private Level level;

    public ParkingSpot(Level level, int row, int spotNumber, VehicleSize vehicleSize) {
        this.level = level;
        this.row = row;
        this.spotNumber = spotNumber;
        this.spotSize = vehicleSize;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        return isAvailable() && vehicle.canFitInSpot(this);
    }

    public boolean park(Vehicle vehicle) {
        if (!canFitVehicle(vehicle)) {
            return false;
        }
        this.vehicle = vehicle;
        vehicle.parkInSpot(this);
        return true;
    }

    public void removeVehicle() {
        level.spotFreed();
        vehicle = null;
    }


}
