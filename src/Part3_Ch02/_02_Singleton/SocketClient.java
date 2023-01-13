package Part3_Ch02._02_Singleton;

public class SocketClient {

    private static SocketClient socketClient = null;

    private SocketClient() {

    }

    public static SocketClient getInstance() {
        if(socketClient == null) { socketClient = new SocketClient(); }
        return socketClient;
    }

    public void connect() {
        System.out.println("connect");
    }

}
