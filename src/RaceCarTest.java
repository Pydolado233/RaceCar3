import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RaceCarTest {
    @Test
    public void testConsumeFuel() {
        RaceCar car = new Truck(100, "SportsTr");
        car.consumeFuel();
        assertEquals(90, car.fuelLevel);
    }

    @Test
    public void testWearTires() {
        RaceCar car = new SportsCar(80, "caruck");
        car.wearTires();
        assertEquals(3, car.tireWear);
    }
}
