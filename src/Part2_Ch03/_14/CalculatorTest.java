package Part2_Ch03._14;

public class CalculatorTest {

    public static void main(String [] args) {

        int num1 = 10;
        int num2 = 2;

        CompleteCalc calc = new CompleteCalc();
        System.out.println(calc.add(num1, num2));
        System.out.println(calc.substract(num1, num2));
        System.out.println(calc.times(num1, num2));
        System.out.println(calc.divide(num1, num2));

        calc.description();

        // 정적 메서드는 인스턴스 생성 전 사용 가능
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Calc.total(arr));


    }
}
