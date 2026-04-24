public class CarFactory {
    public static Car createCar(EngineType type) {
        Car car = new Car();
        replaceEngine(car, type);
        return car;
    }

    public static void replaceEngine(Car car, EngineType type) {
        switch (type) {
            case GAS: 
                car.setEngine(new GasolineEngine()); 
                break;
            case ELECTRIC: 
                car.setEngine(new ElectronicEngine()); 
                break;
            case HYBRID: 
                car.setEngine(new MixedHybridEngine()); 
                break;
        }
    }
}
