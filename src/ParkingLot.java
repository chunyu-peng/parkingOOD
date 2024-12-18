public class ParkingLot {
    private Level[] levels;
    private int NUM_LEVELS;

    public ParkingLot(int n, int num_rows, int spots_per_row) {
        this.NUM_LEVELS = n;
        levels = new Level[this.NUM_LEVELS];
        for (int i = 0; i < this.NUM_LEVELS; i++) {
            levels[i] = new Level(i, num_rows, spots_per_row);
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.parkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public void unParkVehicle(Vehicle vehicle) {
        vehicle.clearSpots();
    }

    public void print() {
        for (int i = 0; i < levels.length; i++) {
            System.out.print("Level" + i + ": ");
            levels[i].print();
            System.out.println("");
        }
        System.out.println("");
    }
}
