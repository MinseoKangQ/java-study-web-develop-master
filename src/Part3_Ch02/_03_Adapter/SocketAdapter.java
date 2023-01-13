package Part3_Ch02._03_Adapter;

// adapter 이용하여 변환
public class SocketAdapter implements Electronic110V{

    // 자기 자신은 110V를 가지고 있어야 하고
    // 변환할 220V도 가지고 있어야 함

    private Electronic220V electronic220V;

    public SocketAdapter(Electronic220V electronic220V) {
        this.electronic220V = electronic220V;
    }

    @Override
    public void powerOn() {
        electronic220V.connect();
    }
}
