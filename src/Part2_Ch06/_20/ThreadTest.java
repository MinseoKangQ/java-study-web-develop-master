package Part2_Ch06._20;

class MyThread extends Thread {

    @Override
    public void run() {
        int i;
        for(i = 1; i<=200; i++) {
            System.out.print(i + "\t");
        }
    }

}

public class ThreadTest {

    public static void main(String [] args) {

        System.out.println(Thread.currentThread() + "start");
        MyThread th1 = new MyThread();
        MyThread th2 = new MyThread();

        th1.start();
        th2.start();
        System.out.println(Thread.currentThread() + "end");
    }

}
