import java.util.Random;

class Truck extends RaceCar {
    public Truck(double spd, String name) {
        this.spd = spd;
        this.initspd = spd;
        this.name = name;
        this.fuelEfficiency = 15;
        this.tireWearRate = 3;
    }

    public void moveForOneTick() {
        Random r = new Random();
        if (spd > 0) {
            this.dist += 0.8 * spd;
            int x = r.nextInt(4);
            if (x == 0) {
                System.out.println(getName() + " cuts through the air!");
            }
            if (x == 1) {
                System.out.println(getName() + " slices through the wind!");
            }
            if (x == 2) {
                System.out.println(getName() + " rockets down the straightaway!");
            }
            if (x == 3) {
                System.out.println(getName() + " soars down the track!");
            }
        }
    }

    public void updateSpeed(String condition) {
        if (condition.equals("RAINY")) {
            this.spd *= 0.8;
            this.tireWearRate = 10;
        }
        if (condition.equals("WINDY")) {
            this.spd *= 0.9;
        }
    }
}