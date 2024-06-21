import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TruckTest {
    @Test
    public void testMoveForOneTick() {
        Truck truck = new Truck((double) 80, "Truck");
        truck.moveForOneTick();
        assertEquals(64, truck.getDistance());
    }

    @Test
    public void testUpdateSpeedInSunnyCondition() {
        Truck truck = new Truck((double) 80, "Truck");
        truck.updateSpeed("SUNNY");
        assertEquals(80, truck.getSpeed());
    }

    @Test
    public void testUpdateSpeedInRainyCondition() {
        Truck truck = new Truck((double) 80, "Truck");
        truck.updateSpeed("RAINY");
        assertEquals(64, truck.getSpeed());
    }

    @Test
    public void testUpdateSpeedInWindyCondition() {
        Truck truck = new Truck((double) 80, "Truck");
        truck.updateSpeed("WINDY");
        assertEquals(72, truck.getSpeed());
    }
}