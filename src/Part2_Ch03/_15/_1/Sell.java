package Part2_Ch03._15._1;

public interface Sell {

    void sell();

    default void order() {
        System.out.println("sell order");
    }
}
