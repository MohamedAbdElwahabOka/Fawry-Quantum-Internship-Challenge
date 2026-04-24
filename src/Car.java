public class Car {
    private Engine engine;
    private int speed;
    private boolean isStarted = false; 

    public void setEngine(Engine engine) {
        if (speed > 0) {
            System.out.println("WARNING: Cannot replace engine while the car is moving!");
            return;
        }
        this.engine = engine;
        System.out.println("Engine successfully installed/replaced.");
    }

    public void start() {
        if (engine == null) {
            System.out.println("Cannot start: No engine installed.");
            return;
        }
        speed = 0;
        isStarted = true; 
        engine.start();
        System.out.println("Car started. Speed: " + speed + " km/h");
    }

    public void stop() {
        if (!isStarted) {
            System.out.println("Car is already stopped.");
            return;
        }
        if (speed > 0) {
            System.out.println("WARNING: Cannot stop! Car speed must be 0 before stopping. Current speed: " + speed + " km/h");
            return;
        }
        isStarted = false; 
        engine.stop();
        System.out.println("Car stopped safely.");
    }

    public void accelerate() {
        if (!isStarted) {
            System.out.println("WARNING: You must start the car first!");
            return;
        }

        if (speed + 20 <= 200) {
            speed += 20;
        } else {
            speed = 200;
        }
        System.out.println("Car Accelerated. Current Speed: " + speed + " km/h");
        engine.updateSpeed(speed);
    }

    public void brake() {
        if (!isStarted) {
            System.out.println("WARNING: The car is not running!");
            return;
        }

        if (speed - 20 >= 0) {
            speed -= 20;
        } else {
            speed = 0;
        }
        System.out.println("Car Braked. Current Speed: " + speed + " km/h");
        engine.updateSpeed(speed);
    }


}