package v1.task1;

public class Car implements Vehicle {
    private boolean isRunning = false;
    @Override
    public void start() {
        isRunning = true;
        System.out.println("Car started");
    }

    @Override
    public void stop() {
        isRunning = false;
        System.out.println("Car stopped");
    }

    @Override
    public boolean getStatus() {
        return isRunning;
    }
}
