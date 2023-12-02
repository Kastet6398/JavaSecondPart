package v1.task1;

public class Motorcycle implements Vehicle {
    private boolean isRunning = false;
    @Override
    public void start() {
        isRunning = true;
        System.out.println("Motorcycle started");
    }

    @Override
    public void stop() {
        isRunning = false;
        System.out.println("Motorcycle stopped");
    }

    @Override
    public boolean getStatus() {
        return isRunning;
    }
}
