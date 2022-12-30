package Part2_Ch06._01;

class Outer {

    int outNum = 100;
    static int sNum = 200;

    Runnable getRunnable(int i ) {

        int num = 10;

        return new Runnable() {

            int localNum = 1000;

            @Override
            public void run() {

                // 메서드 호출과 변수의 생명주기가 다르기 때문에 오류 -> final로 선언 시 상수가 됨
//                i = 50;
//                num = 20;

                System.out.println("i =" + i);
                System.out.println("num = " +num);
                System.out.println("localNum = " +localNum);

                System.out.println("outNum = " + outNum + "(외부 클래스 인스턴스 변수)");
                System.out.println("Outer.sNum = " + Outer.sNum + "(외부 클래스 정적 변수)");


            }
        };

    }

    Runnable runnable = new Runnable() {

        @Override
        public void run() {
            System.out.println("Runnable class");
        }
    };

}
public class AnnonumousInnerTest {

    public static void main(String[] args) {

        Outer out = new Outer();
        Runnable runner = out.getRunnable(100);

        runner.run();

        out.runnable.run();
    }

}