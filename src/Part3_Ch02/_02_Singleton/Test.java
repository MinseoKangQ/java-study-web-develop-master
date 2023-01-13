package Part3_Ch02._02_Singleton;

public class Test {

    public static void main(String [] args) {

        AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();

        SocketClient aClient = aClazz.getSocketClient();
        SocketClient bClient = bClazz.getSocketClient();

        System.out.println("두 개의 객체가 동일한가?");
        System.out.println(aClient.equals(bClient));

        System.out.println(aClazz);
        System.out.println(bClazz);

        System.out.println(aClient);
        System.out.println(bClient);

    }

}
