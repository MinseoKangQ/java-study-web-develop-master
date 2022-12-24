package Part2_Ch03._01_12;

public class CarTest {

    public static void main(String [] args) {

        Car aiCar = new AICar();
        aiCar.run();

        System.out.println("==============");

        Car mCar = new ManulCar();
        mCar.run();
    }

}
