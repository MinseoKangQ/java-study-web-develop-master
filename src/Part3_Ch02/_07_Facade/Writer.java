package Part3_Ch02._07_Facade;

public class Writer {

    private String fileName;

    public Writer(String fileName) {
        this.fileName = fileName;
    }

    public void fileConnect() {
        String msg = String.format("Reader %s로 연결합니다.", fileName);
        System.out.println(msg);
    }

    public void write() {
        String msg = String.format("Reader %s의 내용을 읽어옵니다.", fileName);
        System.out.println(msg);
    }

    public void fileDisconnect() {
        String msg = String.format("Reader %s로 연결 종료합니다.", fileName);
        System.out.println(msg);
    }
}
