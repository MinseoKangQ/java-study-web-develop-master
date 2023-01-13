package Part3_Ch02._03_Adapter;

public class Test {

    // 콘센트
    public static void connect(Electronic110V electronic110V) {
        electronic110V.powerOn();
    }

    public static void main(String[] args) {

        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
        Electronic110V cleanerAdapter = new SocketAdapter(cleaner); // adapter 이용한 전압 변환 =
        connect(cleanerAdapter);

        AirConditioner airConditioner = new AirConditioner();
        Electronic110V airAdapter = new SocketAdapter(airConditioner);
        connect(airAdapter);

    }

}