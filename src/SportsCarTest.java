
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SportsCarTest {
    @Test
    public void testMoveForOneTick() {
        SportsCar car = new SportsCar((double) 100, "SportCar");
        car.moveForOneTick();
        assertEquals(120, car.getDistance());
    }

    @Test
    public void testUpdateSpeedInSunnyCondition() {
        SportsCar car = new SportsCar((double) 100, "SportCar");
        car.updateSpeed("SUNNY");
        assertEquals(100, car.getSpeed());
    }

    @Test
    public void testUpdateSpeedInRainyCondition() {
        SportsCar car = new SportsCar((double) 100, "SportCar");
        car.updateSpeed("RAINY");
        assertEquals(90, car.getSpeed());
    }

    @Test
    public void testUpdateSpeedInWindyCondition() {
        SportsCar car = new SportsCar((double) 100, "SportCar");
        car.updateSpeed("WINDY");
        assertEquals(95, car.getSpeed());
    }
}