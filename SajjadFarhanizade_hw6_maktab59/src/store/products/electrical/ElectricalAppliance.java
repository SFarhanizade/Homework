package store.products.electrical;

import store.products.Product;

public class ElectricalAppliance extends Product {
    private Voltage voltage;
    private PowerSource powerSource;
    private int powerConsumption;

    public ElectricalAppliance(int id, String name, int price, Voltage voltage, PowerSource powerSource, int powerConsumption) {
        super(id, name, price);
        this.voltage = voltage;
        this.powerSource = powerSource;
        this.powerConsumption = powerConsumption;
    }
}
