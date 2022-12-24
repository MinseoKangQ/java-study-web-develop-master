package Part2_Ch03._15._1;

public interface Buy {

    void buy();

    default void order() {
        System.out.println("buy order");
    }
}
