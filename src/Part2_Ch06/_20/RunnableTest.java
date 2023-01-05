package Part2_Ch06._20;

class MyRunnable implements Runnable {

    @Override
    public void run() {
        int i;
        for (i = 1; i <= 200; i++) {
            System.out.print(i + "\t");
        }
    }

}

public class RunnableTest {

    public static void main(String[] args) {

        System.out.println(Thread.currentThread() + "start");

        MyRunnable runnable = new MyRunnable();

        Thread th1 = new Thread(runnable);
        Thread th2 = new Thread(runnable);

        th1.start();
        th2.start();

        System.out.println(Thread.currentThread() + "end");

        Runnable run = new Runnable() {

            @Override
            public void run() {
                System.out.println("run");
            }
        };

        run.run();
    }

}