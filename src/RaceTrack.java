import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.random.*;

public class RaceTrack {
    // Set up the track!
    public int lap;
    public double length;
    String currentWeather = "Sunny";
    public ArrayList<RaceCar> cars = new ArrayList<RaceCar>();
    public FinishLine finishLine = new FinishLine();

    // Initiate everything?
    static double tick = 0;
    public List<RaceCar> finishedRaceCars = new ArrayList<RaceCar>();
    private ArrayList<Double> simulate_time_cars = new ArrayList<Double>();
    private Random r = new Random();
    // To prevent the scenario where track length is not a multiple of car's speed,
    // i.e.: We assume the track has the same starting and finishing line.
    public int test = 0;

    public RaceTrack(double length, List<RaceCar> cars, int pitStop) {
        this.length = length;
        for (RaceCar car : cars) {
            this.cars.add(car);
            car.pitStop = new PitStop(pitStop);
        }
    }

    public double getlength() {
        return length;
    }

    public void simulate(int lap) {
        this.lap = lap;
        while (tick >= 0) {
            // The Weather
            int y = r.nextInt(36);
            if (y % 3 == 0) {
                currentWeather = "Sunny";
            }
            if (y % 5 == 1) {
                currentWeather = "Rainy";
            }
            if (y % 4 == 2) {
                currentWeather = "Windy";
            }
            System.out.println("The weather is " + currentWeather + " now!");
            for (RaceCar car : cars) {
                // The Race
                car.updateSpeed(currentWeather);
                car.wearTires();
                car.consumeFuel();
                car.moveForOneTick();
                if ((car.fuelLevel <= 10 || car.tireWear >= 90) && car.pitStop.leftPitStop() > 0) {
                    car.pitStop.refuel(car);
                    car.pitStop.changeTires(car);
                    car.pitStop.stops -= 1;
                }
                finishLine.cannotFinish(car);
                if (car.getDistance() >= lap * length && !finishLine.getDisFinishedCars().contains(car)
                        && !finishLine.getFinishedCars().contains(car)) {
                    car.time = tick;
                    finishLine.crossed(car);

                }
            }
            // 这里我直接物理
            tick += 0.001;
            // Finish
            if (finishLine.getFinishedCars().size() + finishLine.getDisFinishedCars().size() == cars.size()) {
                for (RaceCar car : finishLine.getFinishedCars()) {
                    simulate_time_cars.add(car.time);
                }
                finishedRaceCars = finishLine.sortingIfNotMultiple(simulate_time_cars);
                break;
            }
        }
    }

    public ArrayList<Double> get_eachCarTime() {
        return simulate_time_cars;
    }

    public List<RaceCar> getFinishedCars() {
        return finishedRaceCars;
    }

    public List<RaceCar> getDisFinishedCars() {
        return finishLine.getDisFinishedCars();
    }
}
