package Part2_Ch02;
import java.util.ArrayList;

public class ArrayListTest {

    // 객체 배열을 구현한 클래스
    public static void main(String [] args) {

        ArrayList<Book> library = new ArrayList<>();

        library.add(new Book("강1", "강강강"));
        library.add(new Book("강2", "강강강"));
        library.add(new Book("강3", "강강강"));
        library.add(new Book("강4", "강강강"));
        library.add(new Book("강5", "강강강"));

        for(int i = 0; i<library.size(); i++) {
            library.get(i).showInfo();
        }
    }

}
