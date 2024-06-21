abstract class RaceCar {
    protected double spd;
    protected double initspd;
    protected double dist = 0;
    protected String name;
    protected double fuelLevel = 100;
    protected double fuelEfficiency;
    protected double tireWear = 0;
    protected double tireWearRate;
    public PitStop pitStop;
    protected double time = 0;

    public double getSpeed() {
        return spd;
    }

    public double getInitSpd() {
        return initspd;
    }

    public double getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    abstract void moveForOneTick();

    abstract void updateSpeed(String condition);

    public double getDistance() {
        return (dist);
    }

    public void consumeFuel() {
        fuelLevel -= fuelEfficiency;
    }

    public void wearTires() {
        tireWear += tireWearRate;
    }
}