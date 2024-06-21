import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PitStopTest {
    @Test
    public void testRefuel() {
        RaceCar car = new SportsCar(100, "SportsCar");
        car.fuelLevel = 50;
        PitStop pitStop = new PitStop(0);
        pitStop.refuel(car);
        assertEquals(100, car.fuelLevel);
    }

    @Test
    public void testChangeTires() {
        RaceCar car = new Truck(80, "Truck");
        car.tireWear = 70;
        PitStop pitStop = new PitStop(0);
        pitStop.changeTires(car);
        assertEquals(0, car.tireWear);
    }
}