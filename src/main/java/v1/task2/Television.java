package v1.task2;

public class Television implements ElectronicDevice {
    private boolean isTurnedOn = false;
    @Override
    public void turnOn() {
        isTurnedOn = true;
        System.out.println("Turning on Television");
    }

    @Override
    public void turnOff() {
        isTurnedOn = false;
        System.out.println("Turning off Television");
    }

    @Override
    public boolean getStatus() {
        return isTurnedOn;
    }
}
