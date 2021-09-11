package store.products.electrical;

public class Radio extends ElectricalAppliance {
    private int antennaRange;
    private SignalModulationMode signal;

    public Radio(int id, String name, int price, int amount, Voltage voltage, PowerSource powerSource, int powerConsumption, int antennaRange, SignalModulationMode signal) {
        super(id, name, price, amount, voltage, powerSource, powerConsumption);
        this.antennaRange = antennaRange;
        this.signal = signal;
    }

    public int getAntennaRange() {
        return antennaRange;
    }

    public void setAntennaRange(int antennaRange) {
        this.antennaRange = antennaRange;
    }

    public SignalModulationMode getSignal() {
        return signal;
    }

    public void setSignal(SignalModulationMode signal) {
        this.signal = signal;
    }
}