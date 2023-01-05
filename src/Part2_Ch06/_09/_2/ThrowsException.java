package Part2_Ch06._09._2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

// throws를 이용하여 예외 미루기, 실제 코드를 사용하는 쪽에서 처리하기
public class ThrowsException {

    public Class loadClass(String fileName, String className) throws ClassNotFoundException, FileNotFoundException {

        FileInputStream fis = new FileInputStream(fileName);
        Class c = Class.forName(className);
        return c;
    }

    public static void main(String [] args) {

        ThrowsException test = new ThrowsException();

        try {
            test.loadClass("a.txt", "java.lang.String");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (Exception e) { // 디폴트 Exception
                                // 위의 두 Exception 외에 나머지 모든 것
                                // 주의 할 것, 디폴트 Exception은 맨 밑에 써야 함
        }

//        혹은 두 개를 한번에 처리
//        try {
//            test.loadClass("a.txt", "java.lang.String");
//        } catch (ClassNotFoundException | FileNotFoundException e) {
//            e.printStackTrace();
//        }

        System.out.println("end");

    }
}
