package Part2_Ch03._01_12;

public class AICar extends Car {

    @Override
    public void drive() {
        System.out.println("자율 주행을 합니다.");
        System.out.println("자동차가 스스로 방향을 바꿉니다.");
    }

    @Override
    public void stop() {
        System.out.println("장애를 일으켰습니다.");
    }

    @Override
    public void wiper() {

    }

    @Override
    public void washCar() {
        System.out.println("자동으로 세차를 합니다.");
    }
}
