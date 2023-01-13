package Part3_Ch02._03_Adapter;

public class AirConditioner implements Electronic220V{

    @Override
    public void connect() {
        System.out.println("에어컨 220v on");
    }

}
