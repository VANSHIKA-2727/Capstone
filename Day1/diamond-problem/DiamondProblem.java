interface DeviceA {
    default void turnON() {
        System.out.println("Device A is On");
    }
}

interface DeviceB {
    default void turnON() {
        System.out.println("Device B is On");
    }
}

class SmartDevice implements DeviceA, DeviceB {
    public void turnON() {
        DeviceA.super.turnON();
        DeviceB.super.turnON();
    }
}

public class DiamondProblem {
    public static void main(String[] args) {
        SmartDevice device = new SmartDevice();
        device.turnON();
    }
}