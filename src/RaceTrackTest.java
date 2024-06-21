import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class RaceTrackTest {
    @Test
    public void testSimulate() {
        List<RaceCar> cars = new ArrayList<>();
        cars.add(new SportsCar(100, "SportsCar"));
        cars.add(new Truck(80, "Truck"));

        RaceTrack raceTrack = new RaceTrack(100, cars, 5);
        raceTrack.simulate(3);

        List<RaceCar> finishedCars = raceTrack.getFinishedCars();
        assertEquals(2, finishedCars.size());
    }
}
