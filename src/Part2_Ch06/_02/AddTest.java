package Part2_Ch06._02;

public class AddTest {

    public static void main(String [] args) {

//        Add add = (x, y) -> { return x+y; };
        Add add = (x, y) -> x+y;

        System.out.println(add.add(2, 3));
    }

}
