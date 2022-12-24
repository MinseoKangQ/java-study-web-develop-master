package Part2_Ch03._01_12;

public abstract class Car {

    public abstract void drive();
    public abstract void stop();
    public abstract void wiper();

    public void starCar() {
        System.out.println("시동을 켭니다.");
    }

    public void turnOff() {
        System.out.println("시동을 끕니다.");
    }

    // 필요한 경우에 재정의 가능 메서드
    public void washCar() { }

    // 흐름은 변하면 안되기 때문에 final로 선언
    final public void run() {
        starCar();
        drive();
        wiper();
        stop();
        turnOff();
        washCar();
    }
}
