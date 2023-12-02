package v1.task2;

public class Main {
    public static void main(String[] args) {
        Television television = new Television();
        Computer computer = new Computer();
        manageElectronicDevices(television, computer);
        manageElectronicDevices(television, computer);
    }

    public static void manageElectronicDevices(ElectronicDevice... electronicDevices) {
        for (ElectronicDevice electronicDevice : electronicDevices) {
            if (!electronicDevice.getStatus()) electronicDevice.turnOn();
            else electronicDevice.turnOff();
        }
    }
}
