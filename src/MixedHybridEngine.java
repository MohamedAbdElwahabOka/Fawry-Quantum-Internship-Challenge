public class MixedHybridEngine implements Engine {
    private final GasolineEngine gasEngine = new GasolineEngine();
    private final ElectronicEngine electricEngine = new ElectronicEngine();
    private Engine activeEngine;

    @Override
    public void start() {
        activeEngine = electricEngine; 
        activeEngine.start();
        System.out.println("MixedHybridEngine is active.");
    }
    @Override
    public void stop() {
        if (activeEngine != null) activeEngine.stop();
        System.out.println("MixedHybridEngine stopped.");
    }
    @Override
    public void increase() {
        if (activeEngine != null) activeEngine.increase();
    }
    @Override
    public void decrease() {
        if (activeEngine != null) activeEngine.decrease();
    }
    @Override
    public void updateSpeed(int targetSpeed) {
        if(targetSpeed>=50 && activeEngine == electricEngine){
            electricEngine.stop();
            gasEngine.start();
            while (gasEngine.getInternalSpeed() < targetSpeed) gasEngine.increase();
            activeEngine = gasEngine;
             System.out.println("[HYBRID SYSTEM] Switched to GasolineEngine");
       
        }else if(targetSpeed < 50 && activeEngine == gasEngine){
            gasEngine.stop();
            electricEngine.start();
            while (electricEngine.getInternalSpeed() < targetSpeed) electricEngine.increase();
            activeEngine = electricEngine;
            System.out.println("[HYBRID SYSTEM] Switched to ElectronicEngine");
      
    }else{
        if(activeEngine != null) activeEngine.updateSpeed(targetSpeed);
    }

}
@Override
    public int getInternalSpeed() {
        return activeEngine != null ? activeEngine.getInternalSpeed() : 0;
    }

}
