package store.products.electrical;

public class Television extends ElectricalAppliance{
    TV_Type tvType;
    int sizeInInch;
    int[] resolution = new int[2];

    public Television(int id, String name, int price, Voltage voltage, PowerSource powerSource,
                      int powerConsumption, TV_Type tvType, int sizeInInch, int[] resolution) {
        super(id, name, price, voltage, powerSource, powerConsumption);
        this.tvType = tvType;
        this.sizeInInch = sizeInInch;
        this.resolution = resolution;
    }

    public TV_Type getTvType() {
        return tvType;
    }

    public void setTvType(TV_Type tvType) {
        this.tvType = tvType;
    }

    public int getSizeInInch() {
        return sizeInInch;
    }

    public void setSizeInInch(int sizeInInch) {
        this.sizeInInch = sizeInInch;
    }

    public int[] getResolution() {
        return resolution;
    }

    public void setResolution(int[] resolution) {
        this.resolution = resolution;
    }
}
