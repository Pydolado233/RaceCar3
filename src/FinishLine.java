import java.util.concurrent.locks.ReadWriteLock;
import java.util.*;

public class FinishLine {
    private List<RaceCar> finishedCars = new ArrayList<RaceCar>();
    private List<RaceCar> disfinishedCars = new ArrayList<RaceCar>();
    public int test = 0;

    public FinishLine() {
    }

    public void crossed(RaceCar car) {
        finishedCars.add(car);
        car.spd = 0;
        car.fuelEfficiency = 0;
        car.tireWearRate = 0;
        car.fuelLevel = 100;
        car.tireWear = 0;
    }

    public void cannotFinish(RaceCar car) {
        if ((car.fuelLevel <= 0 || car.tireWear >= 100) && !disfinishedCars.contains(car)) {
            disfinishedCars.add(car);
            System.out
                    .println("Looks like " + car.getName() + " ran out of juice! This guy cannot finish the race!");
            car.spd = 0;
            car.time = RaceTrack.tick;
            car.fuelEfficiency = 0;
            car.tireWearRate = 0;
            car.fuelLevel = 100;
            car.tireWear = 0;
        }
    }

    public List<RaceCar> getFinishedCars() {
        return finishedCars;
    }

    public List<RaceCar> getDisFinishedCars() {
        return disfinishedCars;
    }

    public List<RaceCar> sortingIfNotMultiple(ArrayList<Double> time) {
        List<RaceCar> fCarsN = new ArrayList<RaceCar>();
        Collections.sort(time);
        for (double j : time) {
            for (RaceCar i : finishedCars) {
                if (i.time == j) {
                    fCarsN.add(i);
                }
            }
        }
        return fCarsN;
    }

}
