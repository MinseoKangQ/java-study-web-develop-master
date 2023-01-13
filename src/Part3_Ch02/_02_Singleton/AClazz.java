package Part3_Ch02._02_Singleton;

public class AClazz {

    private SocketClient socketClient;

    public AClazz() { this.socketClient = SocketClient.getInstance(); }

    public SocketClient getSocketClient() { return this.socketClient; }

}
