### Advanced Race Car Simulator with Pit Stops and Weather Conditions

#### Objective
Create an advanced race car simulator that incorporates pit stops and weather conditions. The simulator will have different types of race cars (e.g., sports cars, trucks) competing on a track for a specified number of laps. Each type of car will have its own characteristics, such as speed, fuel efficiency, and tire wear rate. The simulation will be based on discrete time intervals called ticks. Cars will need to make pit stops to refuel and change tires when necessary. The race will be affected by changing weather conditions, which will impact the cars' performance. The race will end when all cars have crossed the finish line or run out of fuel.

#### Description
You will be creating a Java program to simulate a race with different types of cars competing on a track under varying weather conditions. The track has a specified length, and the cars will complete a specified number of laps. Each type of car will have its own attributes and behaviors, including:
- Speed: The car's base speed.
- Fuel Efficiency: The amount of fuel consumed by the car per tick.
- Tire Wear Rate: The rate at which the car's tires wear out per tick.
- Fuel Level: The car's current fuel level, initially set to 100.
- Tire Wear: The car's current tire wear percentage, initially set to 0.

The simulation will be based on ticks, and the cars will move a certain distance based on their speed during each tick. Cars will consume fuel and experience tire wear during the race. They will need to make pit stops to refuel and change tires when their fuel level is low or tire wear is high.

The race will be affected by changing weather conditions, which will impact the cars' speed and tire wear rate. The weather conditions can be one of the following:
- Sunny: No impact on car performance.
- Rainy: Reduces car speed by 10% for sports cars and 20% for trucks. Increases tire wear rate.
- Windy: Reduces car speed by 5% for sports cars and 10% for trucks.

The race will end when all cars have crossed the finish line or run out of fuel.

#### Implementation Details
1. Update the abstract `RaceCar` class:
   - Add properties for `fuelLevel` (initially set to 100), `tireWear` (initially set to 0), `fuelEfficiency`, and `tireWearRate`.
   - Add an abstract method `updateSpeed(String condition)` to update the car's speed based on the current weather condition.
   - Add methods `consumeFuel()` and `wearTires()` to handle fuel consumption and tire wear.

2. `WeatherCondition` String with values: `"SUNNY"`, `"RAINY"`, and `"WINDY"`.

3. Create concrete subclasses of `RaceCar`:
   - `SportsCar`:
     - Speed: Passed as a parameter to the constructor.
     - Fuel Efficiency: 10 units per tick.
     - Tire Wear Rate: 5 units per tick.
     - Implement the `updateSpeed(String condition)` method based on the weather conditions mentioned above.
     - Implement the `moveForOneTick()` method, where the distance is increased by the car's speed multiplied by 1.2.
   - `Truck`:
     - Speed: Passed as a parameter to the constructor.
     - Fuel Efficiency: 15 units per tick.
     - Tire Wear Rate: 3 units per tick.
     - Implement the `updateSpeed(String condition)` method based on the weather conditions mentioned above.
     - Implement the `moveForOneTick()` method, where the distance is increased by the car's speed multiplied by 0.8.

4. Create a `PitStop` class with methods to refuel a car (set fuel level to 100) and change its tires (set tire wear to 0).

5. Update the `RaceTrack` class:
   - Add fields for `currentWeather` (initially set to "SUNNY") and `pitStop`.
   - Modify the `simulate()` method to handle weather changes (with a 10% probability of changing) and check if cars need to make pit stops based on their fuel level (less than or equal to 10) and tire wear (greater than or equal to 90).
   - Add a method to randomly update the weather conditions during the race.

6. Update the `FinishLine` class:
   - Modify the `cross()` method to handle cars that have run out of fuel and cannot finish the race.

7. In the `Main` class:
   - Create instances of `SportsCar` and `Truck` with appropriate speeds.
   - Create a `RaceTrack` instance with the desired length and list of cars.
   - Specify the number of laps for the race.
   - Call the `simulate()` method to run the race simulation.
   - Print the results, including the order in which the cars finished the race.
