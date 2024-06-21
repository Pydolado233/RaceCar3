import java.util.Random;

class SportsCar extends RaceCar {
    public SportsCar(double spd, String name) {
        this.spd = spd;
        this.initspd = spd;
        this.name = name;
        this.fuelEfficiency = 10;
        this.tireWearRate = 5;
    }

    public void moveForOneTick() {
        Random r = new Random();
        if (spd > 0) {
            this.dist += 1.2 * spd;
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
            this.spd *= 0.9;
            this.tireWearRate = 10;
        }
        if (condition.equals("WINDY")) {
            this.spd *= 0.95;
        }
    }
}
