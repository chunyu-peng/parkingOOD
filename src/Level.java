public class Level {
    private int floor;
    private ParkingSpot[] spots;
    private int availableSpots;
    private int SPOTS_PER_ROW;

    public Level(int floor, int numRows, int spotsPerRow) {
        this.floor = floor;
        this.SPOTS_PER_ROW = spotsPerRow;
        int numberSpots = 0;
        spots = new ParkingSpot[numRows * spotsPerRow];

        for (int row = 0; row < numRows; row++) {
            // 1 / 4 of total spots for moto
            for (int spot = 0; spot < spotsPerRow / 4; spot++) {
                VehicleSize size = VehicleSize.Motorcycle;
                spots[numberSpots] = new ParkingSpot(this, row, numberSpots, size);
                numberSpots++;
            }
            // 1 / 2 of total spots for compact
            for (int spot = spotsPerRow / 4; spot < spotsPerRow / 4 * 3; spot++) {
                VehicleSize size = VehicleSize.Compact;
                spots[numberSpots] = new ParkingSpot(this, row, numberSpots, size);
                numberSpots++;
            }
            // 1 / 4 of total spots for large
            for (int spot = spotsPerRow / 4 * 3; spot < spotsPerRow; spot++) {
                VehicleSize size = VehicleSize.Large;
                spots[numberSpots] = new ParkingSpot(this, row, numberSpots, size);
                numberSpots++;
            }
        }

        availableSpots = numberSpots;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        if (availableSpots() < vehicle.getSpotsNeeded()) {
            return false;
        }
        int spotNumber = findAvailableSpots(vehicle);
        if (spotNumber < 0) {
            return false;
        }
        return parkStartingAtSpot(spotNumber, vehicle);
    }

    private int findAvailableSpots(Vehicle vehicle) {
        int spotsNeeded = vehicle.getSpotsNeeded();
        int lastRow = -1;
        for (ParkingSpot spot : spots) {
            if (lastRow != spot.getRow()) {
                spotsFound = 0;
                lastRow = spot.getRow();
            }
            if (spot.canFitVehicle(vehicle)) {
                spotsFound++;
            } else {
                spotsFound = 0;
            }
            if (spotsFound == spotsNeeded) {
                return
            }
        }
    }

    public void spotFreed() {
        availableSpots++;
    }
    public int availableSpots() {
        return availableSpots;
    }
}
