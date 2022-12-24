package Part2_Ch03._14;

public interface Calc {

    double PI = 3.14;
    int ERROR = -99999;

    int add(int num1, int num2);
    int substract(int num1, int num2);
    int times(int num1, int num2);
    int divide(int num1, int num2);

    // 디폴트 메서드
    default void description() {
        System.out.println("정수의 사칙연산을 제공합니다.");
        myMethod();
    }

    // 정적 메서드
    static int total(int [] arr) {

        int total = 0;
        for(int num : arr) {
            total += num;
        }
        myStaticMethod();
        return total;
    }

    // private 메서드
    // 단지 인터페이스 내에서만 사용 목적
    // 구현 코드에서 재정의 X
    private void myMethod() {
        System.out.println("myMethod");
    }

    private static void myStaticMethod() {
        System.out.println("myStaticMethod");
    }
}
