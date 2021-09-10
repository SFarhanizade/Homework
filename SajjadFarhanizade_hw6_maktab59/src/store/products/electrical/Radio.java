package store.products.electrical;

public class Radio extends ElectricalAppliance {
    int antennaRange;
    SignalModulationMode signal;

    public Radio(int id, String name, int price, Voltage voltage, PowerSource powerSource,
                 int powerConsumption, int antennaRange, SignalModulationMode signal) {
        super(id, name, price, voltage, powerSource, powerConsumption);
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