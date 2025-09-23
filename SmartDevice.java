// File: SmartHome.java
class SmartDevice {
    protected String name;

    public SmartDevice(String name) {
        this.name = name;
    }

    public void turnOn() {
        System.out.println(name + " is now ON");
    }

    public void turnOff() {
        System.out.println(name + " is now OFF");
    }
}

class SmartLight extends SmartDevice {
    public SmartLight(String name) {
        super(name);
    }

    public void changeColor(String color) {
        System.out.println(name + " changed color to " + color);
    }
}

class SmartThermostat extends SmartDevice {
    public SmartThermostat(String name) {
        super(name);
    }

    public void setTemperature(int temp) {
        System.out.println(name + " set to " + temp + "°C");
    }
}

public class SmartHome {
    public static void main(String[] args) {
        SmartDevice device1 = new SmartLight("Living Room Light");
        SmartDevice device2 = new SmartThermostat("Nest Thermostat");

        device1.turnOn();
        device2.turnOn();

        // Safe downcasting with instanceof
        if (device1 instanceof SmartLight) {
            SmartLight light = (SmartLight) device1;
            light.changeColor("Blue");
        }

        if (device2 instanceof SmartThermostat) {
            SmartThermostat thermostat = (SmartThermostat) device2;
            thermostat.setTemperature(22);
        }

        // Unsafe without instanceof → prevented
        if (device2 instanceof SmartLight) {
            SmartLight wrongCast = (SmartLight) device2;
            wrongCast.changeColor("Red");
        } else {
            System.out.println("Safe check: device2 is not a SmartLight!");
        }
    }
}
