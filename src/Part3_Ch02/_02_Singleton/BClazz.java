package Part3_Ch02._02_Singleton;

public class BClazz {

    private SocketClient socketClient;

    public BClazz() { this.socketClient = SocketClient.getInstance(); }

    public SocketClient getSocketClient() { return this.socketClient; }

}
