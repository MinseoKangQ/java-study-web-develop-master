package Part3_Ch02._07_Facade;

public class SftpClient {

    private Ftp ftp;
    private Reader reader;
    private Writer writer;

    public SftpClient(Ftp ftp, Reader reader, Writer writer) {
        this.ftp = ftp;
        this.reader = reader;
        this.writer = writer;
    }

    // 오버로딩
    public SftpClient(String host, int port, String path, String fileName) {
        this.ftp = new Ftp(host, port, path);
        this.reader = new Reader(fileName);
        this.writer = new Writer(fileName);
    }

    public void connect() {
        ftp.connect();
        ftp.moveDiretory();
        writer.fileConnect();
        reader.fileConnect();
    }

    public void disConnect() {
        writer.fileDisconnect();
        reader.fileDisconnect();
        ftp.disconnect();
    }

    public void read() { reader.fileRead(); }
    public void write() { writer.write(); }

}
