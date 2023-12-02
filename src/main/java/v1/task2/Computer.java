package v1.task2;

public class Computer implements ElectronicDevice {
    private boolean isTurnedOn = false;
    @Override
    public void turnOn() {
        isTurnedOn = true;
        System.out.println("Turning on Computer");
    }

    @Override
    public void turnOff() {
        isTurnedOn = false;
        System.out.println("Turning off Computer");
    }

    @Override
    public boolean getStatus() {
        return isTurnedOn;
    }
}
