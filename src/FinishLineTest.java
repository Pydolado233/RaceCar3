import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class FinishLineTest {
    @Test
    public void testCrossWithSufficientFuel() {
        RaceCar car = new SportsCar(100, "SportsCar");
        FinishLine finishLine = new FinishLine();
        finishLine.crossed(car);
        assertTrue(!finishLine.getDisFinishedCars().contains(car));
    }

    @Test
    public void testCrossWithInsufficientFuel() {
        RaceCar car = new Truck(80, "Truck");
        car.fuelLevel = 0;
        FinishLine finishLine = new FinishLine();
        finishLine.crossed(car);
        assertFalse(!finishLine.getDisFinishedCars().contains(car));
    }

    @Test
    public void testGetFinishedCars() {
        RaceCar car1 = new SportsCar(100, "SportsCar");
        RaceCar car2 = new Truck(80, "Truck");
        FinishLine finishLine = new FinishLine();
        finishLine.crossed(car1);
        finishLine.crossed(car2);
        List<RaceCar> finishedCars = finishLine.getFinishedCars();
        assertEquals(2, finishedCars.size());
        assertTrue(finishedCars.contains(car1));
        assertTrue(finishedCars.contains(car2));
    }
}