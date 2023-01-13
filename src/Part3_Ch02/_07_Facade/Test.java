package Part3_Ch02._07_Facade;

public class Test {

    public static void main(String[] args) {

        Ftp ftpClient = new Ftp("www.foo.co.kr", 22, "/home/etc");
        ftpClient.connect();
        ftpClient.moveDiretory();

        Writer writer = new Writer("text.tmp");
        writer.fileConnect();
        writer.write();

        Reader reader = new Reader("text.tmp");
        reader.fileConnect();
        reader.fileRead();

        reader.fileDisconnect();
        writer.fileDisconnect();
        ftpClient.disconnect();

        System.out.println();

        // facade 이용
        SftpClient sftpClient = new SftpClient("www.foo.co.kr", 22, "home/etc", "text.tmp");
        sftpClient.connect();
        sftpClient.read();
        sftpClient.write();
        sftpClient.disConnect();

    }
}
