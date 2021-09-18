public class ElementArray {
    static Element[] elements = new Element[4];

    public static void main(String[] args) {
        elements[0] = new MetalElement("Na", 11, 22.98);
        elements[1] = new MetalElement("Mg", 12, 24.30);
        elements[2] = new NonMetalElement("O",8,15.99);
        elements[3] = new NonMetalElement("H",1,1);
        for(Element element:elements)
            element.describeElement();
    }
}
