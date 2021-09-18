public class MetalElement extends Element{
    public MetalElement(String symbol, int atomicNumber, double atomicWeight) {
        super(symbol, atomicNumber, atomicWeight);
    }

    @Override
    public void describeElement() {
        System.out.println(symbol+" is good conductor of electricity");
    }
}
