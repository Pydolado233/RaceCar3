public class PitStop {
    public int stops;

    public PitStop(int stops) {
        this.stops = stops;
    }

    public int leftPitStop() {
        return stops;
    }

    public void changeTires(RaceCar car) {
        car.tireWear = 0;
    }

    public void refuel(RaceCar car) {
        car.fuelLevel = 100;
        System.out
                .println(car.getName() + " has left the pitstop and refuels. " + "He has " + stops + " pitstops left!");
    }
}
