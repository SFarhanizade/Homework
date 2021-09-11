package store.products.electrical;

import store.products.Product;

public class ElectricalAppliance extends Product {
    private Voltage voltage;
    private PowerSource powerSource;
    private int powerConsumption;

    public ElectricalAppliance(int id, String name, int price, int amount, Voltage voltage, PowerSource powerSource, int powerConsumption) {
        super(id, name, price, amount);
        this.voltage = voltage;
        this.powerSource = powerSource;
        this.powerConsumption = powerConsumption;
    }

    public Voltage getVoltage() {
        return voltage;
    }

    public void setVoltage(Voltage voltage) {
        this.voltage = voltage;
    }

    public PowerSource getPowerSource() {
        return powerSource;
    }

    public void setPowerSource(PowerSource powerSource) {
        this.powerSource = powerSource;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    @Override
    public String toString() {
        return super.toString()+"\n     Voltage "+voltage+" PowerSource " + powerSource +" PowerConsumption " + powerConsumption;
    }
}
