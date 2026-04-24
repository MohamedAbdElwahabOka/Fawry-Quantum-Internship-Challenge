public interface Engine {
    void start();
    void stop();
    void increase();
    void decrease();
    void updateSpeed(int targetSpeed); 
    int getInternalSpeed();
}
