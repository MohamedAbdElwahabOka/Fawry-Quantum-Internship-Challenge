public abstract class BaseEngine implements Engine{
    protected int internalSpeed = 0;
    protected boolean isRunning = false;

    @Override
    public void start(){
        isRunning = true;
        internalSpeed = 0;
        System.out.println(this.getClass().getSimpleName() + " started.");
    }

    @Override
    public void stop() {
        isRunning = false;
        internalSpeed = 0;
        System.out.println(this.getClass().getSimpleName() + " stopped.");
    }
    @Override
    public void increase() {
        if (isRunning) internalSpeed++;
    }
    @Override
    public void decrease() {
        if (isRunning) internalSpeed--;
    }
    @Override
    public void updateSpeed(int targetSpeed){
        if(!isRunning) return;
        while (internalSpeed < targetSpeed) increase();
        while (internalSpeed > targetSpeed) decrease();
    }
    @Override
    public int getInternalSpeed() {
        return internalSpeed;
    }

}
