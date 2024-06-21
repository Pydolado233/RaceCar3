import java.math.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        int test = 0;
        Random r = new Random();
        // RaceCars initiated.
        // ******** WARNING: Car speed cannot be the same *******/
        List<RaceCar> beNormalPls = new ArrayList<RaceCar>();
        for (int i = 0; i < 20; i++) {
            beNormalPls.add(new SportsCar(0.5 * (i + 1), "RaceCar" + (i + 1)));
        }
        // Track initiated
        RaceTrack normaltrack = new RaceTrack(100, beNormalPls, 10);
        // Race simulated
        normaltrack.simulate(3);
        // Present cars' placements
        for (RaceCar car : normaltrack.getFinishedCars()) {
            System.out.println(
                    car.getName() + " with the speed " + car.getInitSpd() + " is placed No."
                            + (normaltrack.getFinishedCars().indexOf(car) + 1)
                            + " in this race !!!! Finishing off with "
                            + car.getTime() * 1000 + " seconds");
        }
        for (RaceCar car : normaltrack.getDisFinishedCars()) {
            System.out.println(
                    car.getName() + " with the speed " + car.getInitSpd() + "; failed to finish the race :(((");
        }
        // random version
        // If the car speed is random double, there will be different cars finishing
        // with the same speed due to how the tick is discrete.
        // Try several times for the following code to work as intended:

        // List<RaceCar> randomCars = new ArrayList<RaceCar>();
        // ArrayList<Double> rand1 = new ArrayList<Double>();
        // while (randomCars.size() < 20) {
        // Random random = new Random();
        // double rand2 = Math.abs(random.nextDouble(100));
        // if (!rand1.contains(rand2)) {
        // rand1.add(rand2);
        // if (r.nextInt(2) == 0) {
        // randomCars.add(new SportsCar(rand2 + 10, "RS" + (randomCars.size() +
        // 1)));
        // } else {
        // randomCars.add(new Truck(rand2 + 10, "RS" + (randomCars.size() + 1)));
        // }
        // }
        // }

        // // Track initiated
        // RaceTrack track = new RaceTrack(273 * r.nextDouble(100), randomCars, 100);
        // // Race simulated
        // track.simulate(r.nextInt(5));
        // // Present cars' placements
        // for (RaceCar car : track.getFinishedCars()) {
        // System.out.println(
        // car.getName() + " with the speed " + car.getInitSpd() + " is placed No."
        // + (track.getFinishedCars().indexOf(car) + 1)
        // + " in this race !!!! Finishing off with "
        // + car.getTime() * 1000+" seconds.");
        // }
        // for (RaceCar car : track.getDisFinishedCars()) {
        // System.out.println(
        // car.getName() + " with the speed " + car.getInitSpd() + "; failed to finish
        // the race :(((");
        // }
    }
}
