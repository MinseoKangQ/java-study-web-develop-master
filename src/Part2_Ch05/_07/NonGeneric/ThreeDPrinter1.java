package Part2_Ch05._07.NonGeneric;

public class ThreeDPrinter1 {

    private Powder material;

    public Powder getMaterial() {
        return material;
    }

    public void setMaterial(Powder material) {
        this.material = material;
    }

    public String toString() {
        return "재료는 Powder 입니다";
    }
}
