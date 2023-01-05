package Part2_Ch06._09._1;

public class AutoCloseableObj implements AutoCloseable{

    @Override
    public void close() throws Exception {
        System.out.println("closing...");
    }
}
