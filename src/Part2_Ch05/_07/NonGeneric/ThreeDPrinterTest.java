package Part2_Ch05._07.NonGeneric;

public class ThreeDPrinterTest {

    public static void main(String [] args) {

        Powder powder = new Powder();
        ThreeDPrinter3 printer = new ThreeDPrinter3();

        printer.setMaterial(powder);

        Powder p = (Powder)printer.getMaterial();
    }

}
